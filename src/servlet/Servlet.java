package src.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    // private String index = "index.jsp";

    public Servlet() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // request.getRequestDispatcher("index.jsp").forward(request, response);
        PrintWriter out = response.getWriter();
        out.print("<h1>Hello Servlet</h1>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
