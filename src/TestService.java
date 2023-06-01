package src;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.Ip;
import src.by.fpmibsu.netside.entity.User;
import src.service.*;

import java.io.IOException;
import java.sql.SQLException;

public class TestService extends Assert {
    private AnswerService answerService;
    private IpService ipService;
    private QuestionService questionService;
    private RouteService routeService;
    private UserService userService;

    public TestService() throws SQLException, DaoException, IOException {
        answerService=new AnswerService();
        ipService=new IpService();
        questionService=new QuestionService();
        routeService=new RouteService();
        userService = new UserService();
    }
    @BeforeClass
    private void set() throws DaoException {
        if(userService.getUserByName("Margo")!=null){
            userService.delete(userService.getUserByName("Margo"));
        }
    }
    @DataProvider(name = "ip")
    public Object[][] createId() {
        return new Object[][]{{new Ip("79.89.24.2")}};
    }
    @DataProvider(name = "ip2")
    public Object[][] createId2() {
        return new Object[][]{{new Ip("79.89.24.1")}};
    }

    @Test(priority = 0,dataProvider = "ip")
    public void testCreate(Ip ip) throws DaoException {
        ipService.create(ip);
        assertNotNull(ipService.findIp(ip));
    }

    @Test(priority=1,dataProvider = "ip")
    public void testFindIp(Ip ip) throws DaoException {
        assertNotNull(ipService.findIp(ip));
    }

    @Test(priority=2,dataProvider = "ip2")
    public void testFindIp1(Ip ip) throws DaoException {
        assertNull(ipService.findIp(ip));
    }

    @DataProvider(name = "user")
    public Object[][] createUser() {
        return new Object[][]{{"Margo", "11111","bushmargarita4@gmail.com"}};
    }

    @Test(priority =3,dataProvider = "user")
    public void testCreateUser(String username,String password,String email) throws DaoException {
        assert(userService.createUser(username,password,email));
    }

    @Test(priority =4,dataProvider = "user",expectedExceptions = DaoException.class)
    public void testCreateUser1(String username,String password,String email) throws DaoException {
        assert(userService.createUser(username,password,email));
    }

    @Test(priority = 5,dataProvider = "user")
    public void testFindUserById(String username,String password,String email) throws DaoException {
        Integer id =userService.getUserByName(username).getId();
        User actual=userService.findUserById(id);
        User expected=new User(id,username,password,email);
        assertEquals(actual.getLogin(), expected.getLogin());
        assertEquals(actual.getEmail(),expected.getEmail());
        assertEquals(actual.getPassword(),expected.getPassword());
    }

    @Test(priority = 6,dataProvider = "user")
    public void testGetUserByName(String username,String password,String email) throws DaoException {
        User actual=userService.getUserByName(username);
        User expected=new User(username,password,email);
        assertEquals(actual.getLogin(), expected.getLogin());
        assertEquals(actual.getEmail(),expected.getEmail());
        assertEquals(actual.getPassword(),expected.getPassword());
    }

}
