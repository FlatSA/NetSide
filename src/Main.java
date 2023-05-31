package src;

import src.by.fpmibsu.netside.SearchEngine;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.Question;
import src.service.IpService;
import src.service.QuestionService;
import src.service.RouteService;
import src.service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    static RouteService routeService;
    static UserService userService;
    static IpService ipService;

    public static void main(String[] args) throws DaoException, SQLException, IOException, ClassNotFoundException {
        QuestionService questionService = new QuestionService();
        List<Question> questions = questionService.getAllQuestions();
        SearchEngine searchEngine = new SearchEngine(questions, "Testing prod");
        System.out.println(searchEngine.getClosestQuestion().getMessage());
        //IpService ipService = new IpService();
        //System.out.println(ipService.findIp(new Ip("1.1.1.123142")).getId());
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
}