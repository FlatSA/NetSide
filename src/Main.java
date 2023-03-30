package src;

import src.by.fpmibsu.netside.entity.*;
import src.by.fpmibsu.netside.dao.*;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.SortedMap;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load configuration: " + e.getMessage());
            return;
        }

        String connectionUrl = props.getProperty("db.url");

        try(Connection connection = DriverManager.getConnection(connectionUrl)) {
            UserDao userDao = new UserDao();
            userDao.setConnection(connection);
            User us = userDao.findEntityById(7);
            us.setLogin("JARIK");
            System.out.println(userDao.update(us));
            List<User> list = userDao.findAll();
            for(User user1 : list) {
                System.out.println(user1.toString());
            }
        } catch (SQLException | DaoException e) {
            System.out.println(e.getMessage());
        }
    }
}