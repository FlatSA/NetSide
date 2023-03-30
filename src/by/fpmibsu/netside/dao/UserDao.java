package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User> {

    //TODO
    @Override
    public List<User> findAll() throws DaoException {
        try(Statement statement = connection.createStatement()) {
            String sql = "SELECT id, login, email FROM user"; //change statement
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                users.add(new User(id, login, password, email));
            }
            return users;
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    //TODO
    @Override
    public User findEntityById(Integer id) throws DaoException {
        try(Statement statement = connection.createStatement()) {
            String sql = "SELECT FROM user id=" + id; //change statement
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()) {
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                User user = new User(id, login, password, email);
                return user;
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
        return null;
    }

    //TODO
    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    //TODO
    @Override
    public boolean delete(User entity) throws DaoException {
        return false;
    }

    //TODO
    @Override
    public boolean create(User entity) throws DaoException {
        return false;
    }

    //TODO
    @Override
    public User update(User entity) throws DaoException {
        return null;
    }
}
