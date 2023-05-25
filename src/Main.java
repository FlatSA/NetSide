package src;

import src.by.fpmibsu.netside.dao.*;

import java.sql.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load configuration: " + e.getMessage());
            return;
        }
        String connectionUrl = props.getProperty("db.url");
        System.out.println(connectionUrl);
        try(Connection connection = DriverManager.getConnection(connectionUrl)) {
            IpDao ipDao = new IpDao(connection);
            RouteDao routeDao = new RouteDao(connection);
            RatingDao ratingDao = new RatingDao(connection);
            UserDao userDao = new UserDao(connection);
        } catch (SQLException | DaoException e) {
            System.out.println(e.getMessage());
        }
    }
}