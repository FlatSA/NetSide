package src.servlet;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.Question;
import src.service.AnswerService;
import src.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class QuestionController extends HttpServlet {
    QuestionService questionService = null;
    AnswerService answerService = null;

    public void init() throws ServletException {
        questionService = new QuestionService();
        answerService = new AnswerService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");

        if("questionButton".equals(button)) {
            try {
                List<Question> questions = questionService.getTop20Questions();
                request.setAttribute("questions", questions);
                request.getRequestDispatcher("question-home-styled.jsp").forward(request, response);
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }
        } else if(button != null && isInteger(button)) {
            try {
                Integer questionId = Integer.valueOf(button);
                Question question = questionService.findQuestionById(questionId);
                request.setAttribute("questionObject", question);
                request.getRequestDispatcher("answer-question-styled.jsp").forward(request, response);
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }
        } else if("answerOnTheQuestion".equals(button)) {
            try {
                String message = request.getParameter("textAnswerOnTheQuestion");
                Integer questionId = Integer.valueOf(request.getParameter("questionId"));
                answerService.createAnswer(questionId, message);
                response.sendRedirect("logged-user.jsp");
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
