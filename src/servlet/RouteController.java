package src.servlet;

import src.by.fpmibsu.netside.TraceRoute;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.Ip;
import src.by.fpmibsu.netside.entity.Route;
import src.by.fpmibsu.netside.entity.User;
import src.service.IpService;
import src.service.RouteService;
import src.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouteController extends HttpServlet {
    RouteService routeService;
    UserService userService;
    IpService ipService;

    public void init() throws ServletException {
        routeService = new RouteService();
        userService = new UserService();
        ipService = new IpService();
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
        Ip ip = new Ip(request.getParameter("userIp"));
        String destinationIp = request.getParameter("destinationIp");

        try {
            if("routeButton".equals(button)) {
                List<Route> routes = routeService.getFirstFiveRoutes();
                request.setAttribute("routes", routes);
                request.getRequestDispatcher("routes-list-styled.jsp").forward(request, response);
            } else if("getRouteButton".equals(button)) {
                TraceRoute traceRoute = new TraceRoute(new Ip(destinationIp));
                //List<Ip> ipList = routeService.findRouteByUserId(userId).getIpList();
                List<Ip> ipList = traceRoute.getListIpFromServerToUser();

                fillDataBase(ipList, new Ip(destinationIp), userId);
                List<double[]> dotList = getListOfDots(ipList);

                request.setAttribute("dotList", dotList);
                request.getRequestDispatcher("route-map-styled.jsp").forward(request, response);
            }
        } catch (DaoException e) {
            System.err.println("doPost RouteController failed");
            throw new RuntimeException(e);
        }

    }

    protected void fillDataBase(List<Ip> ipList, Ip end, Integer userId) {
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

    protected List<double[]> getListOfDots(List<Ip> ips) {
        List<double[]> dotList = new ArrayList<>();

        for (Ip ip : ips) {
            String apiUrl = "https://ipinfo.io/" + ip.getIpAddress() + "?token=6745615ab91d28";

            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    String responseData = response.toString();
                    reader.close();
                    connection.disconnect();

                    double[] latLng = getLatLngFromJson(responseData);
                    if(latLng != null) {
                        dotList.add(latLng);
                    }
                }
            } catch (Exception e) {
                System.err.println("Failed in converting ip to dot in RouteController");
                e.printStackTrace();
            }
        }

        return dotList;
    }

    private static double[] getLatLngFromJson(String jsonString) {
        Pattern pattern = Pattern.compile("-?\\d+\\.\\d+,-?\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(jsonString);

        if (matcher.find()) {
            String loc = matcher.group();
            List<String> latLng= List.of(loc.split(","));
            return new double[]{Double.parseDouble(latLng.get(0)), Double.parseDouble(latLng.get(1))};
        }

        return null;
    }
}
