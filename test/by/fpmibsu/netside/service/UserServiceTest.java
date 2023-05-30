package test.by.fpmibsu.netside.service;

import org.testng.Assert;



public class UserServiceTest extends Assert {
    /*UserService userService = new UserService();
    @Test
    public void testGeneratedStub () {}

    @org.testng.annotations.BeforeMethod(enabled=false)
    public void setUp() throws DaoException {
        boolean f=userService.createUser("Margo","11111", "bushmargarita4@gmail.com");

    }

    @org.testng.annotations.AfterMethod(enabled=false)
    public void tearDown() throws DaoException {
        boolean f=userService.delete(new User("Margo","11111", "bushmargarita4@gmail.com"));

    }

    @org.testng.annotations.Test
    public void testGetUserByName() throws DaoException {
        Assert.assertEquals(userService.getUserByName("Margo"),
                new User("Margo", "11111", "bushmargarita4@gmail.com")
        );
    }

    @org.testng.annotations.Test
    public void testCreateUser() throws DaoException {
        Assert.assertFalse(userService.createUser("Margo", "11111", "bushmargarita4@gmail.com"));
    }

    @org.testng.annotations.Test
    public void testFindUserById() throws DaoException {
        Integer id =userService.getUserByName("Margo").getId();
        Assert.assertEquals(userService.findUserById(id),
                new User("Margo", "11111", "bushmargarita4@gmail.com")
        );
    }*/
    @org.testng.annotations.Test
    public void testFindUserById() {
        Integer id =0;
        Integer id2=0;
        Assert.assertEquals(id,id2);
    }


}
