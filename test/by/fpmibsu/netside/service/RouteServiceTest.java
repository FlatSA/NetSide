package test.by.fpmibsu.netside.service;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import src.service.RouteService;

public class RouteServiceTest extends Assert {
RouteService routeService=new RouteService();

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }
/*
    @Test
    public void testFindRouteByUserId() throws DaoException {
        Route route = routeService.getFirstFiveRoutes().get(0);
        Integer userID=route.getUser().getId();
        Route expected=route;
        Route actual=routeService.findRouteByUserId(userID);
        Assert.assertEquals(expected,actual);
    }
*/
}