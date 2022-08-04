package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/users";
    private static final String NAME = "Nina";
    private static final String PASSWORD = "root";
    private static Connection connection = null;
    public Util() {
    }
    private static SessionFactory sessionFactory; //настройка и работа с сессиями (фабрика сессий)

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                sessionFactory = configuration.buildSessionFactory(
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties())
                                .build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static void closeSession() {
        sessionFactory.close();
    }

    public static Connection getConnection() {
        //Properties properties = new Properties();
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            //properties.load(new FileInputStream(new File("src/resources/mySQL.properties")));
            //connection = DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("NAME"), properties.getProperty("PASSWORD"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
