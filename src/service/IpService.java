package src.service;

import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.IpDao;
import src.by.fpmibsu.netside.dao.RouteDao;
import src.by.fpmibsu.netside.entity.Ip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IpService {
    private IpDao ipDao;
    private Connection connection = null;

    public IpService() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://dpg-cgdgd102qv2aq5lnnegg-a.frankfurt-postgres.render.com:5432/net_side?user=user&password=DtBAsqFIMyWL6HCHs7PBreMF9SguZuJi");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Connection failed from IpService");
            throw new RuntimeException(e);
        }

        ipDao = new IpDao(connection);
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
