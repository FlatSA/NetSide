package src.servlet;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.Route;
import src.service.RouteService;
import src.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

public class RouteController extends HttpServlet {
    RouteService routeService;

    public void init() throws ServletException {
        routeService = new RouteService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Route> routes = routeService.getFirstFiveRoutes();
            request.setAttribute("routes", routes);
            request.getRequestDispatcher("routes-list-styled.jsp").forward(request, response);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }
}
