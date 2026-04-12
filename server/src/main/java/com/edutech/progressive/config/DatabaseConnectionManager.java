package com.edutech.progressive.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DatabaseConnectionManager {

    private static Properties props = new Properties();
    static {
        try {
            InputStream is = DatabaseConnectionManager.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties");

            props.load(is);
            Class.forName(props.getProperty("spring.datasource.driver-class-name"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final String URL = "spring.datasource.url";
    private static final String USER = "spring.datasource.username";
    private static final String PASSWORD = "spring.datasource.password";

    
public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
