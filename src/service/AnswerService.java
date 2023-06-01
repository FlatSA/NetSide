package src.service;

import org.apache.log4j.Logger;
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
    private static final Logger LOGGER = Logger.getLogger(AnswerService.class.getName());
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
        LOGGER.info("createAnswer: "+questionId);
        Question question = questionDao.findEntityById(questionId);
        return answerDao.create(new Answer(message, question));
    }
}