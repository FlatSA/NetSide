package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.Rating;
import src.by.fpmibsu.netside.entity.Route;
import src.by.fpmibsu.netside.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingDao extends AbstractDao<Rating> {

    public RatingDao() {
        super();
    }

    public RatingDao(Connection connection) {
        super(connection);
    }

    @Override
    public Rating findEntityById(Integer id) throws DaoException {
        String sql = "SELECT * FROM rating WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            RouteDao routeDao = new RouteDao(connection);
            if(resultSet.next()) {
                Integer routeId = resultSet.getInt("route_id");
                Integer value = resultSet.getInt("value");
                Route route = routeDao.findEntityById(id);
                return new Rating(value, route, id);
            }
            return null;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean delete(Rating entity) throws DaoException {
        String sql = "DELETE FROM rating WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean create(Rating entity) throws DaoException {
        String sql = "INSERT INTO rating (route_id, value) VALUES (?, ?) RETURNING id;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getRoute().getId());
            statement.setInt(2, entity.getValue());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                entity.setId(resultSet.getInt(1));
                return true;
            }
            return false;
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean update(Rating entity) throws DaoException {
        String sql = "UPDATE rating SET value = ? WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getValue());
            statement.setInt(2, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }
}
