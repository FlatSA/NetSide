package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.SpeedTest;
import src.by.fpmibsu.netside.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpeedTestDao extends AbstractDao<SpeedTest> {

    public SpeedTestDao() {
        super();
    }

    public SpeedTestDao(Connection connection) {
        super(connection);
    }

    @Override
    public SpeedTest findEntityById(Integer id) throws DaoException {
        String sql = "SELECT * FROM speed_test WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
           statement.setInt(1, id);
           ResultSet resultSet = statement.executeQuery();
           UserDao userDao = new UserDao(connection);
           if(resultSet.next()) {
                User user = userDao.findEntityById(resultSet.getInt(2));
                Double uploadSpeed = resultSet.getDouble(3);
                Double downloadSpeed = resultSet.getDouble(4);
                Integer ping = resultSet.getInt(5);
                return new SpeedTest(id, user, uploadSpeed, downloadSpeed, ping);
           }
           return null;
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean delete(SpeedTest entity) throws DaoException {
        String sql = "DELETE FROM speed_test WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public boolean create(SpeedTest entity) throws DaoException {
        String sql = "INSERT INTO speed_test (user_id, upload_speed, download_speed, ping) " +
                "VALUES(?, ?, ?, ?) RETURNING id;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, entity.getUser().getId());
            statement.setDouble(2, entity.getUploadSpeed());
            statement.setDouble(3, entity.getDownloadSpeed());
            statement.setInt(4, entity.getPing());
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
    public boolean update(SpeedTest entity) throws DaoException {
        String sql = "UPDATE speed_test SET upload_speed = ?, download_speed = ?, ping = ? WHERE id = ?;";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, entity.getUploadSpeed());
            statement.setDouble(2, entity.getDownloadSpeed());
            statement.setInt(3, entity.getPing());
            statement.setInt(4, entity.getId());
            int ret = statement.executeUpdate();
            return (ret != 0);
        } catch(SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }
    }

    public List<SpeedTest> getFirstFiveSP(User user) throws DaoException {
        List<SpeedTest> list = new ArrayList<>();
        String sql = "SELECT id FROM speed_test WHERE user_id = ? LIMIT 5";

        try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                SpeedTest speedTest = findEntityById(id);
                list.add(speedTest);
            }
        } catch (SQLException e) {
            throw new DaoException(e.getMessage(), e.getCause());
        }

        return list;
    }
}
