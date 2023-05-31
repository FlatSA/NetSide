package src.service;

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
        List<Question> questionList = new ArrayList<>();
        questionList = questionDao.getTop20Questions();
        return questionList;
    }

    public Question findQuestionById(Integer id) throws DaoException {
        return questionDao.findEntityById(id);
    }
}
