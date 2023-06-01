package src.by.fpmibsu.netside.dao;

import org.apache.log4j.Logger;
import src.by.fpmibsu.netside.entity.Answer;
import src.by.fpmibsu.netside.entity.Question;
import src.by.fpmibsu.netside.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao extends AbstractDao<Question> {

    public QuestionDao() {
        super();
    }

    public QuestionDao(Connection connection) {
        super(connection);
    }
    private static final Logger LOGGER = Logger.getLogger(QuestionDao.class.getName());
    public List<Question> findAll() throws DaoException {
        String sql = "SELECT * FROM question;";
        LOGGER.info("findAll");
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            List<Question> questions = new ArrayList<>();
            UserDao userDao = new UserDao(connection);
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer user_id = resultSet.getInt("user_id");
                String message = resultSet.getString("message");
                Integer votes = resultSet.getInt("votes");
                User user = userDao.findEntityById(user_id);
                questions.add(new Question(id, user, message, votes));
            }
            return questions;
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Question findEntityById(Integer id) throws DaoException {
        String sql = "SELECT * FROM question WHERE id = ?;";
        LOGGER.info("findEntityById: "+ id);
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            UserDao userDao = new UserDao(connection);
            if(resultSet.next()) {
                Question question = new Question();
                question.setId(id);
                question.setMessage(resultSet.getString(3));
                question.setVotes(resultSet.getInt(4));
                question.setUser(userDao.findEntityById(resultSet.getInt(2)));
                return question;
            }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
        return null;
    }

    @Override
    public boolean delete(Question entity) throws DaoException {
        String sql = "DELETE FROM question WHERE id = ?;";
        LOGGER.info("delete"+entity.getId());
        try(PreparedStatement statement = connection.prepareStatement(sql)){
           statement.setInt(1, entity.getId());
           int ret = statement.executeUpdate();
           return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean create(Question entity) throws DaoException {
        String sql = "INSERT INTO question (user_id, message, votes) VALUES(?, ?, ?) RETURNING id;";
        LOGGER.info("create"+entity.getId());
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getUser().getId());
            statement.setString(2, entity.getMessage());
            statement.setInt(3, entity.getVotes());
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
    public boolean update(Question entity) throws DaoException {
        String sql = "UPDATE question SET message = ?, votes = ? WHERE id = ?;";
        LOGGER.info("update"+entity.getId());
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.setString(1, entity.getMessage());
           statement.setInt(2, entity.getVotes());
           statement.setInt(3, entity.getId());
           int ret = statement.executeUpdate();
           return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public void getAnswers(Question entity) throws DaoException {
        String sql = "SELECT * FROM answer WHERE question_id = ?;";
        LOGGER.info("getAnswers"+ entity.getId());
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.setInt(1, entity.getId());
           ResultSet resultSet = statement.executeQuery();
           UserDao userDao = new UserDao(connection);
           entity.getAnswers().clear();
           while(resultSet.next()) {
              Answer answer = new Answer();
              User user = userDao.findEntityById(resultSet.getInt(3));
              answer.setUser(user);
              answer.setMessage(resultSet.getString(2));
              answer.setQuestion(entity);
              answer.setId(resultSet.getInt(1));
              entity.getAnswers().add(answer);
           }
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public List<Question> getTop20Questions() throws DaoException {
        String sql = "SELECT * FROM question ORDER BY votes DESC LIMIT 20";
        List<Question> questions = new ArrayList<>();
        LOGGER.info("getTop20Questions");
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            UserDao userDao = new UserDao(connection);
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer userId = resultSet.getInt("user_id");
                String message = resultSet.getString("message");
                Integer votes = resultSet.getInt("votes");
                User user = userDao.findEntityById(userId);
                questions.add(new Question(id, user, message, votes));
            }
        } catch (SQLException e) {
            System.err.println("Error while getting top 20 questions in QuestionDao");
            throw new RuntimeException(e);
        }
        return questions;
    }

    public List<Question> getAllQuestions() throws DaoException {
        String sql = "SELECT * FROM question";
        List<Question> questions = new ArrayList<>();
        LOGGER.info("getAllQuestions");
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            UserDao userDao = new UserDao(connection);
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer userId = resultSet.getInt("user_id");
                String message = resultSet.getString("message");
                Integer votes = resultSet.getInt("votes");
                User user = userDao.findEntityById(userId);
                questions.add(new Question(id, user, message, votes));
            }
        } catch (SQLException e) {
            System.err.println("Error while getting all questions in QuestionDao");
            throw new RuntimeException(e);
        }
        return questions;
    }
}
