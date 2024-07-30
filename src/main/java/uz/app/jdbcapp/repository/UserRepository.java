package uz.app.jdbcapp.repository;

import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import uz.app.jdbcapp.db.DatabaseConfigurations;
import uz.app.jdbcapp.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {
    DatabaseConfigurations configurations = DatabaseConfigurations.getInstance();
    private List<User> users = new ArrayList<>();
    Connection connection = configurations.connection();

    public List<User> getUsers() {
        return users;
    }

    @SneakyThrows
    public void saveUser(User user) {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users where id = '" + user.getId() + "';");
        String text;
        if (resultSet.next()) {
            text = String.format("update users set name ='%s', email ='%s', password = '%s', has_confirmed = '%s' where id ='%s'; ",
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getHasConfirmed(),
                    user.getId());
        } else {
            text = String
                    .format("insert into users values('%s','%s','%s','%s','%s','%s');",
                            user.getId(),
                            user.getName(),
                            user.getEmail(),
                            user.getPassword(),
                            user.getHasConfirmed(),
                            user.getCode());
        }
        statement.execute(text);

//        Optional<User> optionalUser =
//                users
//                        .stream()
//                        .filter(
//                                temp -> temp.getEmail().equals(user.getEmail()))
//                        .findFirst();
//        if (optionalUser.isPresent()) {
//            throw new RuntimeException("User with email " + user.getEmail() + " already exists");
//        }
//        users.add(user);
    }

    @SneakyThrows
    public Optional<User> getUserByEmail(String email) {
        @Cleanup Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users where email = '" + email + "'");
        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setEmail(resultSet.getString("email"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setHasConfirmed(resultSet.getBoolean("has_confirmed"));
            user.setCode(resultSet.getString("code"));
            return Optional.of(user);
        }
        return Optional.empty();
//        return users
//                .stream()
//                .filter(user -> user.getEmail().equals(email))
//                .findFirst();
    }

    public void delete(String id) {

    }


    private static UserRepository userRepository;

    public static UserRepository getInstance() {
        if (userRepository == null)
            synchronized (UserRepository.class) {
                if (userRepository == null) {
                    userRepository = new UserRepository();
                }
            }
        return userRepository;
    }

}
