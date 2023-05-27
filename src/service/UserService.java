package src.service;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.UserDao;
import src.by.fpmibsu.netside.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserService {
    private UserDao userDao = null;
    private Connection connection = null;

    public UserService() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://dpg-cgdgd102qv2aq5lnnegg-a.frankfurt-postgres.render.com:5432/net_side?user=user&password=DtBAsqFIMyWL6HCHs7PBreMF9SguZuJi");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failed from LoginService");
            throw new RuntimeException(e);
        }

        try {
            userDao = new UserDao(connection);
        } catch (DaoException e) {
            System.out.println("Dao creation failed from LoginService");
            throw new RuntimeException(e);
        }
    }

    public User getUserByName(String username) throws DaoException {
        return userDao.getUserByName(username);
    }

    public boolean createUser(String username, String password, String email) throws DaoException {
        return userDao.create(new User(username, password, email));
    }
}
