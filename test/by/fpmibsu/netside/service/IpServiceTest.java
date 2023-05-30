package test.by.fpmibsu.netside.service;

import org.testng.Assert;
import org.testng.annotations.Test;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.entity.Ip;
import src.service.IpService;

public class IpServiceTest extends Assert {
    IpService ipService=new IpService();

    @Test(priority=1)
    public void testFindIp() throws DaoException {
        assertNotEquals(ipService.findIp(new Ip("79.89.24.2")),null);
    }
    @Test(priority=2)
    public void testFindIp1() throws DaoException {
        assertNull(ipService.findIp(new Ip("79.89.24.1")));
    }

    @Test(priority = 0)
    public void testCreate() throws DaoException {
        ipService.create(new Ip("79.89.24.2"));
        assertNotNull(ipService.findIp(new Ip("79.89.24.2")));
    }

}