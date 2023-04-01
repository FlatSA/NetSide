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
            UserDao userDao = new UserDao(connection);
            QuestionDao questionDao = new QuestionDao(connection);
            AnswerDao answerDao = new AnswerDao(connection);
            SpeedTestDao testDao = new SpeedTestDao(connection);

            List<User> users = userDao.findAll();
            User user = users.get(3);

            SpeedTest test = testDao.findEntityById(1);
            System.out.println(test);

        } catch (SQLException | DaoException e) {
            System.out.println(e.getMessage());
        }
    }
}