package src.servlet;

import org.apache.log4j.Logger;
import src.by.fpmibsu.netside.DownloadSpeed;
import src.by.fpmibsu.netside.SearchEngine;
import src.by.fpmibsu.netside.TraceRoute;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.Ip;
import src.by.fpmibsu.netside.entity.Question;
import src.by.fpmibsu.netside.entity.Route;
import src.by.fpmibsu.netside.entity.User;
import src.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;


public class Controller extends HttpServlet {
    private UserService userService = null;
    private RouteService routeService = null;
    private IpService ipService = null;
    private QuestionService questionService = null;
    private AnswerService answerService = null;
    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    public void init() throws ServletException {
        userService = new UserService();
        routeService = new RouteService();
        ipService = new IpService();
        questionService = new QuestionService();
        answerService = new AnswerService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");
        LOGGER.info("doPost");
        try {
            if ("getRouteButton".equals(button)) {

                TraceRoute traceRoute = new TraceRoute(new Ip(request.getParameter("destinationIp")));
                Integer userId = Integer.valueOf(request.getParameter("userId"));
                List<Ip> ipList = traceRoute.getListIpFromServerToUser();
                fillDataBaseWithIp(ipList, new Ip(request.getParameter("destinationIp")), userId);
                List<double[]> dotList = DrawService.getListOfDots(ipList);
                request.setAttribute("dotList", dotList);
                request.getRequestDispatcher("route-map-styled.jsp").forward(request, response);

            } else if ("answerOnTheQuestion".equals(button)) {

                String message = request.getParameter("textAnswerOnTheQuestion");
                Integer questionId = Integer.valueOf(request.getParameter("questionId"));
                answerService.createAnswer(questionId, message);
                response.sendRedirect("logged-user.jsp");

            } else if ("Create account".equals(button)) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                User user = userService.getUserByName(username);
                if (user == null) {
                    if (userService.createUser(username, password, email)) {
                        response.sendRedirect("login.jsp");
                    } else {
                        response.sendRedirect("login-fail.jsp");
                    }
                } else {
                    response.sendRedirect("login-fail.jsp");
                }
            } else if("speedTestButton".equals(button)) {

                String link = request.getParameter("drone");
                User user = new User(null, null, null, null);
                int counter = 0;
                double speedSummary = 0;
                double duration = 0;
                Instant startClock = Instant.now();
                while (duration < 5) {
                    counter += 1;
                    double speed = DownloadSpeed.mbSpeedPerTick(link);
                    speedSummary += speed;
                    duration = Duration.between(startClock, Instant.now()).toMillis() / (double)1000;
                    System.out.println(duration);
                }
                double speed = speedSummary / counter;
                SpeedTestService stSer = new SpeedTestService();
                //SpeedTest test = new SpeedTest(user, null, speed, null);
                //stSer.create(test); uncomment when we get user
                request.setAttribute("downloadSpeed", String.format("%.3f", speed));
                request.setAttribute("link", link);
                request.setAttribute("user_id", user.getId());
                request.getRequestDispatcher("download-sp-table.jsp").forward(request, response);
            }
        } catch (DaoException e) {
            System.err.println("doPost Fail");
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button");
        String source = request.getParameter("source");
        LOGGER.info("doGet");
        try {
            if ("LogIn".equals(button)) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                User user = userService.getUserByName(username);
                if (user == null) {
                    response.sendRedirect("login-fail.jsp");
                } else if (password.equals(user.getPassword())) {
                    response.sendRedirect("logged-user.jsp?userId=" + user.getId());
                } else {
                    response.sendRedirect("login-fail.jsp");
                }
            } else if("routeButton".equals(button)) {

                List<Route> routes = routeService.getFirstFiveRoutes();
                request.setAttribute("routes", routes);
                request.getRequestDispatcher("routes-list-styled.jsp").forward(request, response);

            } else if(source != null && "route-box".equals(source)) {

                Integer routeId = Integer.valueOf(request.getParameter("routeId"));
                List<Ip> ipList = routeService.findRouteById(routeId).getIpList();
                List<double[]> dotList = DrawService.getListOfDots(ipList);
                request.setAttribute("dotList", dotList);
                request.getRequestDispatcher("route-map-styled.jsp").forward(request, response);

            } else if("questionButton".equals(button)) {

                List<Question> questions = questionService.getTop20Questions();
                request.setAttribute("questions", questions);
                request.getRequestDispatcher("question-home-styled.jsp").forward(request, response);

            } else if(button != null && isInteger(button)) {

                Integer questionId = Integer.valueOf(button);
                Question question = questionService.findQuestionById(questionId);
                request.setAttribute("questionObject", question);
                request.getRequestDispatcher("answer-question-styled.jsp").forward(request, response);

            } else if("questionSearchButton".equals(button)) {

                response.sendRedirect("search-question-styled.jsp");

            } else if("searchQuestion".equals(button)) {

                String query = request.getParameter("queryQuestion");
                List<Question> questions = questionService.getAllQuestions();
                SearchEngine searchEngine = new SearchEngine(questions, query);
                Question closestQuestion = searchEngine.getClosestQuestion();
                request.setAttribute("closestQuestion", closestQuestion);
                request.getRequestDispatcher("searched-question-styled.jsp").forward(request, response);

            }
        } catch (DaoException e) {
            System.err.println("doGet Fail");
            throw new RuntimeException(e);
        }
    }

    protected void fillDataBaseWithIp(List<Ip> ipList, Ip end, Integer userId) {
        LOGGER.info("fillDataBaseWithIp");
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

    public boolean isInteger(String str) {
        LOGGER.info("isInteger "+ str);
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

