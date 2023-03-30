package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User> {

    public UserDao() {
        super();
    }

    public UserDao(Connection connection) throws DaoException {
        super();
        setConnection(connection);
    }

    public List<User> findAll() throws DaoException {
        //String backup = "SELECT * FROM \"user\"";
        String sql = "SELECT * FROM \"user\"";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
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

    @Override
    public User findEntityById(Integer id) throws DaoException {
        //String backup = "SELECT * FROM \"user\" WHERE id = " + id + ";";
        String sql = "SELECT * FROM \"user\" WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
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

    @Override
    public boolean delete(User entity) throws DaoException {
        //String backup = "DELETE FROM \"user\" WHERE id=" + entity.getId() + ";";
        String sql = "DELETE FROM \"user\" WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

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

    //TODO add title to data_base
    public void getQuestions(User entity) throws DaoException {
        String sql = "SELECT * FROM question WHERE user_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Question question = new Question();
                question.setUser(entity);
                question.setId(resultSet.getInt(1));
                question.setMessage(resultSet.getString(3));
                question.setVotes(resultSet.getInt(4));
                entity.getQuestions().add(question);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    //TODO add votes to data_base
    public void getAnswers(User entity) throws DaoException {
        String sql = "SELECT * FROM answer WHERE user_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Answer answer = new Answer();
                answer.setUser(entity);
                answer.setId(resultSet.getInt(1));
                answer.setMessage(resultSet.getString(2));
                entity.getAnswers().add(answer);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public void getRoutes(User entity) throws DaoException {
        String sql = "SELECT * FROM route WHERE user_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Route route = new Route();
                route.setUser(entity);
                route.setId(resultSet.getInt(1));
                route.setLength(resultSet.getInt(3));
                route.setTime(resultSet.getString(4));
                entity.getRoutes().add(route);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public void getSpeedTests(User entity) throws DaoException {
        String sql = "SELECT * FROM speed_test WHERE user_id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                SpeedTest test = new SpeedTest();
                test.setUser(entity);
                test.setUploadSpeed(resultSet.getDouble(3));
                test.setDownloadSpeed(resultSet.getDouble(4));
                test.setPing(resultSet.getDouble(5));
                entity.getSpeedTests().add(test);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
