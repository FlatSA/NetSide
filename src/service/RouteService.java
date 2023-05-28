package src.service;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.RouteDao;
import src.by.fpmibsu.netside.dao.UserDao;
import src.by.fpmibsu.netside.entity.Route;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class RouteService {
    private RouteDao routeDao = null;
    private Connection connection = null;

    public RouteService() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://dpg-cgdgd102qv2aq5lnnegg-a.frankfurt-postgres.render.com:5432/net_side?user=user&password=DtBAsqFIMyWL6HCHs7PBreMF9SguZuJi");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Connection failed from RouteService");
            throw new RuntimeException(e);
        }

        try {
            routeDao = new RouteDao(connection);
        } catch (DaoException e) {
            System.err.println("Dao creation failed from RouteService");
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
