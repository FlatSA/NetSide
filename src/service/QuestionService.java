package src.service;

import org.apache.log4j.Logger;
import src.by.fpmibsu.netside.Connector;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.QuestionDao;
import src.by.fpmibsu.netside.entity.Question;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {
    private Connection connection = null;
    private QuestionDao questionDao = null;
    private static final Logger LOGGER = Logger.getLogger(QuestionService.class.getName());

    public QuestionService()  {
        try {
            connection = Connector.createConnection();
            questionDao = new QuestionDao(connection);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Error QuestionService");
            throw new RuntimeException(e);
        }
    }

    public List<Question> getTop20Questions() throws DaoException {
        LOGGER.info("getTop20Questions");
        List<Question> questionList = new ArrayList<>();
        questionList = questionDao.getTop20Questions();
        return questionList;
    }

    public Question findQuestionById(Integer id) throws DaoException {
        LOGGER.info("findQuestionById: "+id);
        return questionDao.findEntityById(id);
    }

    public List<Question> getAllQuestions() throws DaoException {
        LOGGER.info("getAllQuestions");
        return questionDao.getAllQuestions();
    }
}
