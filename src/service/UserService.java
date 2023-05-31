package src.service;

import org.apache.log4j.Logger;
import src.by.fpmibsu.netside.Connector;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.UserDao;
import src.by.fpmibsu.netside.entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class UserService {
    private UserDao userDao = null;
    private Connection connection = null;
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    public UserService() {
        try {
            connection = Connector.createConnection();
            userDao = new UserDao(connection);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Error IpService");
            throw new RuntimeException(e);
        }
    }

    public User getUserByName(String username) throws DaoException {
        LOGGER.info("getUserByName "+ username);
        return userDao.getUserByName(username);
    }

    public boolean createUser(String username, String password, String email) throws DaoException {
        LOGGER.info("createUser "+ username);
        return userDao.create(new User(username, password, email));
    }

    public User findUserById(Integer id) throws DaoException {
        LOGGER.info("findUserById "+ id);
        return userDao.findEntityById(id);
    }
    public boolean delete(User entity) throws DaoException {
        LOGGER.info("delete "+ entity.getId());
        return userDao.delete(entity);
    }
}
