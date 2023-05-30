package test.by.fpmibsu.netside.service;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.User;
import src.service.UserService;


public class UserServiceTest extends Assert {

    private UserService userService;
    @BeforeClass
    private void set() throws DaoException {
        userService=new UserService();
        if(userService.getUserByName("Margo")!=null){
            userService.delete(userService.getUserByName("Margo"));
        }
    }



    @org.testng.annotations.BeforeMethod()
    public void setUp() throws DaoException {

    }

    @org.testng.annotations.AfterMethod()
    public void tearDown() throws DaoException {

    }

    @org.testng.annotations.Test(priority =0)
    public void testCreateUser() throws DaoException {
        assert(userService.createUser("Margo", "11111", "bushmargarita4@gmail.com"));
    }
    @org.testng.annotations.Test(priority =1,expectedExceptions = DaoException.class)
    public void testCreateUser1() throws DaoException {
        assert(userService.createUser("Margo", "11111", "bushmargarita4@gmail.com"));
    }

    @org.testng.annotations.Test(priority = 1)
    public void testFindUserById() throws DaoException {
        Integer id =userService.getUserByName("Margo").getId();
        User actual=userService.findUserById(id);
        User expected=new User(id,"Margo", "11111", "bushmargarita4@gmail.com");
        assertEquals(actual.getLogin(), expected.getLogin());
        assertEquals(actual.getEmail(),expected.getEmail());
        assertEquals(actual.getPassword(),expected.getPassword());
    }

    @org.testng.annotations.Test(priority = 3)
    public void testGetUserByName() throws DaoException {
        User actual=userService.getUserByName("Margo");
        User expected=new User("Margo", "11111", "bushmargarita4@gmail.com");
        assertEquals(actual.getLogin(), expected.getLogin());
        assertEquals(actual.getEmail(),expected.getEmail());
        assertEquals(actual.getPassword(),expected.getPassword());
    }
}
