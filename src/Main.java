package src;

import src.by.fpmibsu.netside.TraceRoute;
import src.by.fpmibsu.netside.dao.*;
import src.by.fpmibsu.netside.entity.Ip;
import src.by.fpmibsu.netside.entity.Route;
import src.by.fpmibsu.netside.entity.User;
import src.service.IpService;
import src.service.RouteService;
import src.service.UserService;
import src.servlet.RouteController;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.time.LocalTime;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static RouteService routeService;
    static UserService userService;
    static IpService ipService;

    public static void main(String[] args) throws DaoException {
        routeService = new RouteService();
        userService = new UserService();
        ipService = new IpService();

        TraceRoute traceRoute = new TraceRoute(new Ip("1.1.1.1"));
        List<Ip> ipList = traceRoute.getListIpFromServerToUser();
        //IpService ipService = new IpService();
        //System.out.println(ipService.findIp(new Ip("1.1.1.123142")).getId());
        fillDataBase(ipList, new Ip("1.1.1.1"), 17);
        /*
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Failed to load configuration: " + e.getMessage());
            return;
        }
        String connectionUrl = props.getProperty("db.url");
        System.out.println(connectionUrl);
        try(Connection connection = DriverManager.getConnection(connectionUrl)) {
            IpDao ipDao = new IpDao(connection);
            RouteDao routeDao = new RouteDao(connection);
            RatingDao ratingDao = new RatingDao(connection);
            UserDao userDao = new UserDao(connection);
        } catch (SQLException | DaoException e) {
            System.out.println(e.getMessage());
        }
         */
    }

    protected static void fillDataBase(List<Ip> ipList, Ip end, Integer userId) {
        try {
            ipList.add(end);
            for(Ip ip : ipList) {
                ipService.create(ip);
            }

            User user = userService.findUserById(userId);
            Route route = new Route(user, ipList.size(), ipList, LocalTime.now().toString());
            routeService.create(route);

        } catch (DaoException e) {
            System.err.println("Fail with finding user by id in RouteController");
            throw new RuntimeException(e);
        }
    }
}