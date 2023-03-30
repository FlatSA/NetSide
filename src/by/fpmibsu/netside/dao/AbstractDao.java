package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.Entity;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao <T extends Entity> {
    protected Connection connection;
    public abstract T findEntityById(Integer id) throws DaoException;
    public abstract boolean delete(T entity) throws DaoException;
    public abstract boolean create(T entity) throws DaoException;
    public abstract boolean update(T entity) throws DaoException;
    public void close(Statement statement) {
        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void setConnection(Connection connection) {
        if(connection != null) {
            this.connection = connection;
        }
    }
}
