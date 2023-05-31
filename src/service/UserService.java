package src.service;

import src.by.fpmibsu.netside.Connector;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.UserDao;
import src.by.fpmibsu.netside.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private UserDao userDao = null;
    private Connection connection = null;

    public UserService() {
        try {
            connection = Connector.createConnection();
            userDao = new UserDao(connection);
        } catch (SQLException e) {
            System.err.println("Error IpService");
            throw new RuntimeException(e);
        }
    }

    public User getUserByName(String username) throws DaoException {
        return userDao.getUserByName(username);
    }

    public boolean createUser(String username, String password, String email) throws DaoException {
        return userDao.create(new User(username, password, email));
    }

    public User findUserById(Integer id) throws DaoException {
        return userDao.findEntityById(id);
    }
    public boolean delete(User entity) throws DaoException {
        return userDao.delete(entity);
    }


}
