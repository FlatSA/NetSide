package src.servlet;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.UserDao;
import src.by.fpmibsu.netside.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "SignUpController", value = "/SignUpController")
public class SignUpController extends HttpServlet {

    private UserDao userDao = null;
    private Connection connection = null;

    public void init() throws ServletException {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://dpg-cgdgd102qv2aq5lnnegg-a.frankfurt-postgres.render.com:5432/net_side?user=user&password=DtBAsqFIMyWL6HCHs7PBreMF9SguZuJi");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failed from LoginController");
            throw new RuntimeException(e);
        }

        try {
            userDao = new UserDao(connection);
        } catch (DaoException e) {
            System.out.println("Dao creation failed from LoginController");
            throw new RuntimeException(e);
        }

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
            if(userDao.create(new User(username, password, email))) {
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
