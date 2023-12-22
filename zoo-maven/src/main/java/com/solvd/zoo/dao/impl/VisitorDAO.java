package com.solvd.zoo.dao.impl;

import com.solvd.zoo.dao.IVisitorDAO;
import com.solvd.zoo.dao.connectionpool.ConnectionPool;
import com.solvd.zoo.model.Visitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitorDAO implements IVisitorDAO {
    private static final Logger LOGGER = LogManager.getLogger(VisitorDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getConnectionPool();
    @Override
    public Visitor getEntityById(long id) {
        Connection conn = CONNECTION_POOL.getConnection();

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
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
        return visitor;
    }

    @Override
    public void saveEntity(Visitor entity) {
        Connection conn = CONNECTION_POOL.getConnection();

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
            generatedKeys.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public void updateEntity(Visitor entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("UPDATE visitors SET first_name = ?, last_name = ? WHERE `id` = ?;")){
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setLong(3,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public void removeEntity(Visitor entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("DELETE FROM visitors WHERE id=?")){
            ps.setLong(1,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public List<Visitor> getEntities() {
        Connection conn = CONNECTION_POOL.getConnection();

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
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
        return list;
    }
}
