package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.Answer;
import src.by.fpmibsu.netside.entity.Question;
import src.by.fpmibsu.netside.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerDao extends AbstractDao<Answer> {

    public AnswerDao() {
        super();
    }

    public AnswerDao(Connection connection) {
        setConnection(connection);
    }

    @Override
    public Answer findEntityById(Integer id) throws DaoException {
        String sql = "SELECT * FROM answer WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            UserDao userDao = new UserDao(connection);
            QuestionDao questionDao = new QuestionDao(connection);
            if(resultSet.next()) {
                User user = userDao.findEntityById(resultSet.getInt(3));
                Question question = questionDao.findEntityById(resultSet.getInt(4));
                String message = resultSet.getString(2);
                return new Answer(id, message, user, question);
            }
            return null;
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean delete(Answer entity) throws DaoException {
        String sql = "DELETE FROM answer WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.setInt(1, entity.getId());
           int ret = statement.executeUpdate();
           return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean create(Answer entity) throws DaoException {
        String sql = "INSERT INTO answer (message, user_id, question_id) VALUES(?, ?, ?);";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getMessage());
            statement.setInt(2, entity.getUser().getId());
            statement.setInt(3, entity.getQuestion().getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean update(Answer entity) throws DaoException {
        String sql = "UPDATE answer SET message = ?, user_id = ?, question_id = ? WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.setString(1, entity.getMessage());
           statement.setInt(2, entity.getUser().getId());
           statement.setInt(3, entity.getQuestion().getId());
           statement.setInt(4, entity.getId());
           int ret = statement.executeUpdate();
           return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
