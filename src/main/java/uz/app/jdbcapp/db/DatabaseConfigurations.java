package uz.app.jdbcapp.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfigurations {

    public static final String DB_DRIVER = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/auth_db";
    private static Connection connection;

    @SneakyThrows
    public Connection connection() {
        Class.forName(DB_DRIVER);
        if (connection == null)
            connection = DriverManager.getConnection(DB_URL, "postgres", "root123");
        return connection;
    }


    private static DatabaseConfigurations instance;

    public static DatabaseConfigurations getInstance() {
        if (instance == null) {
            instance = new DatabaseConfigurations();
        }
        return instance;
    }
}
