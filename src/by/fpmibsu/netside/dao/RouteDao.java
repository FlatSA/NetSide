package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.Ip;
import src.by.fpmibsu.netside.entity.Route;
import src.by.fpmibsu.netside.entity.User;

import java.net.InetAddress;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
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
        String sqlRatingIp = "SELECT * FROM ip WHERE id IN (SELECT ip_id FROM route_ip WHERE route_id = ?);";
        List<Ip> ipList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sqlRatingIp)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String ipString = resultSet.getString("ip_address");
                Integer ip_id = resultSet.getInt("id");
                ipList.add(new Ip(id, ipString));
            }

            PreparedStatement statement1 = connection.prepareStatement(sql);
            statement1.setInt(1, id);
            ResultSet resultSet1 = statement1.executeQuery();
            UserDao userDao = new UserDao(connection);
            if (resultSet1.next()) {
                Integer user_id = resultSet1.getInt("user_id");
                Integer length = resultSet1.getInt("length");
                String time = resultSet1.getString("created_at");
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

    //add ip separately and first
    @Override
    public boolean create(Route entity) throws DaoException {
        String sql = "INSERT INTO route (user_id, length, created_at) VALUES (?, ?, ?) RETURNING id;";
        String sqlRouteIp = "INSERT INTO route_ip (route_id, ip_id) VALUES (?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getUser().getId());
            statement.setInt(2, entity.getLength());
            statement.setString(3, entity.getTime());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
            }

            PreparedStatement statRouteIp = connection.prepareStatement(sqlRouteIp);
            statRouteIp.setInt(1, entity.getId());
            List<Ip> ipList = entity.getIpList();
            Iterator<Ip> it = ipList.iterator();
            System.out.println(ipList.toString());
            while (it.hasNext()){
                statRouteIp.setInt(1, entity.getId());
                statRouteIp.setInt(2, it.next().getId());
                statRouteIp.executeUpdate();
            }
            return true;
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
            statement.setString(3, entity.getTime());
            statement.setInt(4, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}