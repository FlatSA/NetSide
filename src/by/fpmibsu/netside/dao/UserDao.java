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
        super(connection);
    }

    public List<User> findAll() throws DaoException {
        String sql = "SELECT * FROM \"user\";";
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
        String sql = "SELECT * FROM \"user\" WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                String login = resultSet.getString("login");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                return new User(id, login, password, email);
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean delete(User entity) throws DaoException {
        String sql = "DELETE FROM \"user\" WHERE id = ?;";
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
        String sql = "INSERT INTO \"user\" (login, password, email) VALUES (?, ?, ?) RETURNING id;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                entity.setId(resultSet.getInt(1));
                return true;
            }
            return false;
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean update(User entity) throws DaoException {
        String sql = "UPDATE \"user\" SET login = ?, password = ?, email = ? WHERE id = ?;";
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

    public void getQuestions(User entity) throws DaoException {
        String sql = "SELECT * FROM question WHERE user_id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            ResultSet resultSet = statement.executeQuery();
            entity.getQuestions().clear();
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

    public void getAnswers(User entity) throws DaoException {
        String sql = "SELECT * FROM answer WHERE user_id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            ResultSet resultSet = statement.executeQuery();
            entity.getAnswers().clear();
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
        String sql = "SELECT * FROM route WHERE user_id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            ResultSet resultSet = statement.executeQuery();
            entity.getRoutes().clear();
            while(resultSet.next()) {
                Route route = new Route();
                route.setUser(entity);
                route.setId(resultSet.getInt(1));
                route.setLength(resultSet.getInt(3));
                route.setTime(resultSet.getTime(4));
                entity.getRoutes().add(route);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public void getSpeedTests(User entity) throws DaoException {
        String sql = "SELECT * FROM speed_test WHERE user_id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            ResultSet resultSet = statement.executeQuery();
            entity.getSpeedTests().clear();
            while(resultSet.next()) {
                SpeedTest test = new SpeedTest();
                test.setUser(entity);
                test.setUploadSpeed(resultSet.getDouble(3));
                test.setDownloadSpeed(resultSet.getDouble(4));
                test.setPing(resultSet.getInt(5));
                test.setId(resultSet.getInt(1));
                entity.getSpeedTests().add(test);
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
