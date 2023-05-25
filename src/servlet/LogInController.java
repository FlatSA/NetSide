package src.servlet;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.User;
import src.service.UserService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogInController extends HttpServlet {
    private UserService userService;
    public void init() throws ServletException {
        userService = new UserService();
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = userService.getUserByName(username);

            if(user == null) {
                response.sendRedirect("error.html");
                return;
            } else if(password.equals(user.getPassword())) {
                response.sendRedirect("success.html");
                return;
            } else {
                response.sendRedirect("error.html");
                return;
            }

        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.getRequestDispatcher("index.jsp").forward(request, response);
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
