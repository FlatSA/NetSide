package src.servlet;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.Question;
import src.service.IpService;
import src.service.QuestionService;
import src.service.RouteService;
import src.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class QuestionController extends HttpServlet {
    QuestionService questionService = null;

    public void init() throws ServletException {
        questionService = new QuestionService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");
        Integer userId = null;
        if(request.getParameter("userId") != null) {
            userId = Integer.valueOf(request.getParameter("userId"));
        }

        if("questionButton".equals(button)) {
            try {
                List<Question> questions = questionService.getTop20Questions();
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
