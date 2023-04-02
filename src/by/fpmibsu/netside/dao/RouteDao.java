package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.Ip;
import src.by.fpmibsu.netside.entity.Route;
import src.by.fpmibsu.netside.entity.User;

import java.net.InetAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RouteDao extends AbstractDao<Route> {

    public RouteDao() {
        super();
    }

    public RouteDao(Connection connection) throws DaoException {
        super(connection);
    }

    @Override
    public Route findEntityById(Integer id) throws DaoException {
        String sql = "SELECT * FROM route WHERE id = ?;";
        String sqlRatingIp = "SELECT * FROM ip WHERE id = (SELECT ip_id FROM route_ip WHERE route_id = ?);";
        List<String> ipList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sqlRatingIp)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ipString = resultSet.getString("ip_address");
                ipList.add(ipString);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            UserDao userDao = new UserDao(connection);
            if (resultSet.next()) {
                Integer user_id = resultSet.getInt("user_id");
                Integer length = resultSet.getInt("length");
                Time time = resultSet.getTime("created_at");
                User user = userDao.findEntityById(user_id);
                return new Route(user, id, length, ipList, time);
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean delete(Route entity) throws DaoException {
        String sql = "DELETE FROM route WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean create(Route entity) throws DaoException {
        String sql = "INSERT INTO route (user_id, length, created_at) VALUES (?, ?, ?) RETURNING id;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getUser().getId());
            statement.setInt(2, entity.getLength());
            statement.setTime(3, entity.getTime());
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
    public boolean update(Route entity) throws DaoException {
        String sql = "UPDATE route SET user_id = ?, length = ?, created_at = ? WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getUser().getId());
            statement.setInt(2, entity.getLength());
            statement.setTime(3, entity.getTime());
            statement.setInt(4, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
