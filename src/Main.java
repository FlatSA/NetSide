package src;

import src.by.fpmibsu.netside.entity.*;
import src.by.fpmibsu.netside.dao.*;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String url = "<url>";
        Properties prop = new Properties();
        prop.put("user", "<user>");
        prop.put("password", "pass");

        try(Connection connection = DriverManager.getConnection(url, prop)) {
            UserDao userDao = new UserDao();
            userDao.setConnection(connection);
            List<User> list = userDao.findAll();
            for(User user : list) {
                System.out.println(user.toString());
            }
        } catch (SQLException | DaoException e) {
            System.out.println(e.getMessage());
        }
    }
}