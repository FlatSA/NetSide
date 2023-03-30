package src.by.fpmibsu.netside.dao;

import src.by.fpmibsu.netside.entity.User;

import java.util.List;

public class UserDao extends AbstractDao<User> {
    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }

    @Override
    public User findEntityById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(User entity) throws DaoException {
        return false;
    }

    @Override
    public boolean create(User entity) throws DaoException {
        return false;
    }

    @Override
    public User update(User entity) throws DaoException {
        return null;
    }
}
