package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<K, T extends Entity> {
    List<T> findAll() throws DaoException;
    T findEntityById(K id) throws DaoException;
    boolean delete(T t) throws DaoException;
    boolean delete(K id) throws DaoException;
    boolean create(T t) throws DaoException;
    T update(T t) throws DaoException;
    default void close(Statement statement) {
        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
