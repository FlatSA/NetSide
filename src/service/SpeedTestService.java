package src.service;

import src.by.fpmibsu.netside.Connector;
import src.by.fpmibsu.netside.dao.DaoException;
import src.by.fpmibsu.netside.dao.SpeedTestDao;
import src.by.fpmibsu.netside.entity.SpeedTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SpeedTestService {
    private SpeedTestDao spDao;
    private Connection connection = null;

    public SpeedTestService() {
        try {
            connection = Connector.createConnection();
            spDao = new SpeedTestDao(connection);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            System.err.println("Error SPService");
            throw new RuntimeException(e);
        }
    }

    public List<SpeedTest> getFirstFiveSP(int userId) throws DaoException {
        return spDao.getFirstFiveSP(userId);
    }

    public SpeedTest findSpeedTest(SpeedTest speedTest) throws DaoException {
        return  spDao.findEntityById(speedTest.getId());
    }

    public boolean create(SpeedTest speedTest) throws DaoException {
        SpeedTest existingSP = spDao.findEntityById(speedTest.getId());
        if(existingSP == null) {
            return spDao.create(speedTest);
        }
        return false;
    }
}
