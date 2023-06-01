package src.service;

import org.apache.log4j.Logger;
import src.by.fpmibsu.netside.Connector;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.RouteDao;
import src.by.fpmibsu.netside.entity.Route;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RouteService {
    private RouteDao routeDao = null;
    private Connection connection = null;
    private static final Logger LOGGER = Logger.getLogger(RouteService.class.getName());
    public RouteService() {
        try {
            connection = Connector.createConnection();
            routeDao = new RouteDao(connection);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Error RouteService");
            throw new RuntimeException(e);
        }
    }

    public List<Route> getFirstFiveRoutes() throws DaoException {
        LOGGER.info("getFirstFiveRoutes");
        return routeDao.getTopFiveRoutes();
    }

    public Route findRouteByUserId(Integer id) throws DaoException {
        LOGGER.info("findRouteByUserId"+id);
        Integer route_id = routeDao.findRouteIdByUserId(id);
        return routeDao.findEntityById(route_id);
    }

    public boolean create(Route route) throws DaoException {
        LOGGER.info("create"+route.getId());
        return routeDao.create(route);
    }

    public Route findRouteById(Integer id) throws DaoException {
        LOGGER.info("findRouteById "+id);
        return routeDao.findEntityById(id);
    }
}
