package src.service;

import src.by.fpmibsu.netside.Connector;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.RouteDao;
import src.by.fpmibsu.netside.dao.UserDao;
import src.by.fpmibsu.netside.entity.Route;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class RouteService {
    private RouteDao routeDao = null;
    private Connection connection = null;

    public RouteService() {
        try {
            connection = Connector.createConnection();
            routeDao = new RouteDao(connection);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            System.err.println("Error RouteService");
            throw new RuntimeException(e);
        }
    }

    public List<Route> getFirstFiveRoutes() throws DaoException {
        return routeDao.getTopFiveRoutes();
    }

    public Route findRouteByUserId(Integer id) throws DaoException {
        Integer route_id = routeDao.findRouteIdByUserId(id);
        return routeDao.findEntityById(route_id);
    }

    public boolean create(Route route) throws DaoException {
        return routeDao.create(route);
    }
}