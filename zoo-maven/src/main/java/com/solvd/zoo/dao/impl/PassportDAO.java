package com.solvd.zoo.dao.impl;

import com.solvd.zoo.dao.IPassportDAO;
import com.solvd.zoo.dao.connectionpool.ConnectionPool;
import com.solvd.zoo.model.Passport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassportDAO implements IPassportDAO {
    private static final Logger LOGGER = LogManager.getLogger(PassportDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getConnectionPool();
    @Override
    public Passport getEntityById(long id) {
        Connection conn = CONNECTION_POOL.getConnection();

        Passport passport = new Passport();

        try (PreparedStatement ps = conn
                .prepareStatement("SELECT id, number FROM passports WHERE id=?")){
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                passport.setId(resultSet.getLong(1));
                passport.setNumber(resultSet.getString(2));
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
        return passport;
    }

    @Override
    public void saveEntity(Passport entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("INSERT INTO passports (number) VALUES (?)", Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, entity.getNumber());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                entity.setId(rs.getLong(1));
            }
            rs.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public void updateEntity(Passport entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("UPDATE passports SET number=? WHERE id=?")){
            ps.setString(1, entity.getNumber());
            ps.setLong(2,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public void removeEntity(Passport entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("DELETE FROM passports WHERE id=?")){
            ps.setLong(1,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public List<Passport> getEntities() {
        Connection conn = CONNECTION_POOL.getConnection();

        List<Passport> list = new ArrayList<>();

        try (PreparedStatement ps = conn
                .prepareStatement("SELECT id, number FROM passports")){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Passport passport = new Passport();
                passport.setId(resultSet.getLong(1));
                passport.setNumber(resultSet.getString(2));
                list.add(passport);
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
