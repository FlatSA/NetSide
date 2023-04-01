package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.Moderator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeratorDao extends AbstractDao<Moderator> {

    public ModeratorDao(Connection connection) {
        super(connection);
    }

    @Override
    public Moderator findEntityById(Integer id) throws DaoException {
        String sql = "SELECT * FROM moderator WHERE id = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                UserDao userDao = new UserDao(connection);
                return new Moderator(userDao.findEntityById(id));
            }
            return null;
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean delete(Moderator entity) throws DaoException {
        String sql = "DELETE FROM moderator WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.setInt(1, entity.getId());
           int ret = statement.executeUpdate();
           return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean create(Moderator entity) throws DaoException {
        String sql = "INSERT INTO moderator (id) VALUES(?);";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.setInt(1, entity.getId());
           int ret = statement.executeUpdate();
           return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean update(Moderator entity) throws DaoException {
        UserDao userDao = new UserDao(connection);
        return userDao.update(entity);
    }
}
