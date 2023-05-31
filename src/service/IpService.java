package src.service;

import src.by.fpmibsu.netside.Connector;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.IpDao;
import src.by.fpmibsu.netside.entity.Ip;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class IpService {
    private IpDao ipDao;
    private Connection connection = null;

    public IpService() {
        try {
            connection = Connector.createConnection();
            ipDao = new IpDao(connection);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Error IpService");
            throw new RuntimeException(e);
        }
    }

    public Ip findIp(Ip ip) throws DaoException {
        return ipDao.findIp(ip);
    }

    public boolean create(Ip ip) throws DaoException {
        Ip existingIp = ipDao.findIp(ip);
        if(existingIp == null) {
            return ipDao.create(ip);
        } else {
            return false;
        }
    }
}
