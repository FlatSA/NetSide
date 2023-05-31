package src.by.fpmibsu.netside.dao;

import org.apache.log4j.Logger;
import src.by.fpmibsu.netside.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IpDao extends AbstractDao<Ip> {

    public IpDao() {
        super();
    }

    public IpDao(Connection connection) {
        super(connection);
    }
    private static final Logger LOGGER = Logger.getLogger(IpDao.class.getName());
    @Override
    public Ip findEntityById(Integer id) throws DaoException {
        String sql = "SELECT * FROM ip WHERE id = ?;";
        LOGGER.info("findEntityById"+id);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String ipAddress = resultSet.getString("ip_address");
                return new Ip(id, ipAddress);
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean delete(Ip entity) throws DaoException {
        String sql = "DELETE FROM ip WHERE id = ?;";
        LOGGER.info("delete"+entity.getId());
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean create(Ip entity) throws DaoException {
        String sql = "INSERT INTO ip (ip_address) VALUES (?) RETURNING id;";
        LOGGER.info("create: "+entity.getId());
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getIpAddress());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean update(Ip entity) throws DaoException {
        String sql = "UPDATE ip SET ip_address = ? WHERE id = ?;";
        LOGGER.info("update: "+entity.getId());
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, entity.getIpAddress());
            statement.setInt(2, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public Ip findIp(Ip ip) throws DaoException {
        String sql = "SELECT * FROM ip WHERE ip_address = ?;";
        LOGGER.info("findIp: "+ip);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ip.getIpAddress());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String ipAddress = resultSet.getString("ip_address");
                return new Ip(id, ipAddress);
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
