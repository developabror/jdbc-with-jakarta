package uz.app.jdbcapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String password;
    private String code;
    private Role role;
    private Boolean hasConfirmed;

    public User(String name, String email, String password, Boolean hasConfirmed) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.hasConfirmed = hasConfirmed;
        role = Role.USER;
    }
}
