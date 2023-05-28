package src;

import src.by.fpmibsu.netside.dao.*;
import src.by.fpmibsu.netside.entity.Ip;
import src.by.fpmibsu.netside.entity.Route;
import src.service.RouteService;
import src.servlet.RouteController;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws DaoException {
        /*
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
         */
    }
}