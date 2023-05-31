package src.service;

import src.by.fpmibsu.netside.Connector;
import src.by.fpmibsu.netside.dao.AnswerDao;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.QuestionDao;
import src.by.fpmibsu.netside.dao.UserDao;
import src.by.fpmibsu.netside.entity.Answer;
import src.by.fpmibsu.netside.entity.Question;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AnswerService {
    private Connection connection = null;

    private AnswerDao answerDao = null;
    private UserDao userDao = null;
    private QuestionDao questionDao = null;

    public AnswerService()  {
        try {
            connection = Connector.createConnection();
            answerDao = new AnswerDao(connection);
            userDao = new UserDao(connection);
            questionDao = new QuestionDao(connection);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Error AnswerService");
            throw new RuntimeException(e);
        }
    }

    public boolean createAnswer(Integer questionId, String message) throws DaoException {
        Question question = questionDao.findEntityById(questionId);
        return answerDao.create(new Answer(message, question));
    }
}