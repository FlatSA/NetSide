package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.Ip;
import src.by.fpmibsu.netside.entity.Route;
import src.by.fpmibsu.netside.entity.User;

import java.net.InetAddress;
import java.net.NoRouteToHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RouteDao extends AbstractDao<Route> {

    public RouteDao() {
        super();
    }

    public RouteDao(Connection connection) {
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

    public Integer findRouteIdByUserId(Integer id) throws DaoException {
        String sql = "SELECT id \n" +
                    "FROM route \n" +
                    "WHERE user_id = ? \n" +
                    "ORDER BY id DESC \n" +
                    "LIMIT 1;\n";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Integer route_id = resultSet.getInt("id");
                return route_id;
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
        String sqlExistRouteIp = "SELECT * FROM route_ip WHERE route_id = ? AND ip_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getUser().getId());
            statement.setInt(2, entity.getLength());
            statement.setString(3, entity.getTime());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                entity.setId(resultSet.getInt(1));
            }

            PreparedStatement statRouteIp = connection.prepareStatement(sqlRouteIp);
            PreparedStatement existRouteIp = connection.prepareStatement(sqlExistRouteIp);
            statRouteIp.setInt(1, entity.getId());
            List<Ip> ipList = entity.getIpList();
            Iterator<Ip> it = entity.getIpList().iterator();
            IpDao ipDao = new IpDao(connection);
            while (it.hasNext()){
                Ip currIp = it.next();

                existRouteIp.setInt(1, entity.getId());
                Ip ip = ipDao.findIp(currIp);

                if(ip == null) {
                    ipDao.create(currIp);
                    ip = ipDao.findIp(currIp);
                }

                existRouteIp.setInt(2, ip.getId());
                ResultSet resultSetIp = existRouteIp.executeQuery();

                if(!resultSetIp.next()) {
                    statRouteIp.setInt(1, entity.getId());
                    statRouteIp.setInt(2, ip.getId());
                    statRouteIp.executeUpdate();
                }
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

    public List<Route> getTopFiveRoutes() throws DaoException {
        List<Route> topRoutes = new ArrayList<>();
        String sql = "SELECT id FROM route ORDER BY length DESC LIMIT 40";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Route route = findEntityById(id);
                topRoutes.add(route);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }

        return topRoutes;
    }
}
