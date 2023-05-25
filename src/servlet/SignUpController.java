package src.servlet;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.UserDao;
import src.by.fpmibsu.netside.entity.User;
import src.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "SignUpController", value = "/SignUpController")
public class SignUpController extends HttpServlet {

   private UserService userService;
    public void init() throws ServletException {
        userService = new UserService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            if(userService.createUser(username, password, email)) {
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
}
