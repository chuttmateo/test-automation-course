package com.solvd.zoo.dao.impl;

import com.solvd.zoo.dao.IVisitorDAO;
import com.solvd.zoo.dao.connectionpool.ConnectionPool;
import com.solvd.zoo.model.Visitor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitorDAO implements IVisitorDAO {
    @Override
    public Visitor getEntityById(long id) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        Visitor visitor = new Visitor();

        try (PreparedStatement ps = conn
                .prepareStatement("SELECT id, first_name, last_name FROM visitors WHERE id=?;")){
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                visitor.setId(resultSet.getLong(1));
                visitor.setFirstName(resultSet.getString(2));
                visitor.setLastName(resultSet.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
        return visitor;
    }

    @Override
    public void saveEntity(Visitor entity) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("INSERT INTO visitors (first_name, last_name) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            while (generatedKeys.next()){
                entity.setId(generatedKeys.getLong(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void updateEntity(Visitor entity) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("UPDATE visitors SET first_name = ?, last_name = ? WHERE `id` = ?;")){
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setLong(3,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void removeEntity(Visitor entity) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("DELETE FROM visitors WHERE id=?")){
            ps.setLong(1,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public List<Visitor> getEntities() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        List<Visitor> list = new ArrayList<>();

        try (PreparedStatement ps = conn
                .prepareStatement("SELECT id, first_name, last_name FROM visitors")){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Visitor visitor = new Visitor();
                visitor.setId(resultSet.getLong(1));
                visitor.setFirstName(resultSet.getString(2));
                visitor.setLastName(resultSet.getString(3));
                list.add(visitor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
        return list;
    }
}
