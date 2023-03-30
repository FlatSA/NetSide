package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User> {

    //TODO
    public List<User> findAll() throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"user\"")) {
            ResultSet resultSet = statement.executeQuery();
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
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"user\" WHERE id = " + id + ";")) {
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(id, login, password, email);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
        return null;
    }

    //TODO
    @Override
    public boolean delete(User entity) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement("DELETE FROM \"user\" WHERE id=" + entity.getId() + ";")) {
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    //TODO
    @Override
    public boolean create(User entity) throws DaoException {
        String sql = "INSERT INTO \"user\" (login, password, email) VALUES (?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getEmail());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    //TODO
    @Override
    public boolean update(User entity) throws DaoException {
        String sql = "UPDATE \"user\" SET login = ?, password = ?, email = ? WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getEmail());
            statement.setInt(4, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
