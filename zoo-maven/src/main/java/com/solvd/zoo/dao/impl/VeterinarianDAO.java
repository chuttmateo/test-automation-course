package com.solvd.zoo.dao.impl;

import com.solvd.zoo.dao.IVeterinarianDAO;
import com.solvd.zoo.dao.connectionpool.ConnectionPool;
import com.solvd.zoo.model.Veterinarian;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDAO implements IVeterinarianDAO {

    @Override
    public Veterinarian getEntityById(long id) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        Veterinarian veterinarian = new Veterinarian();

        try (PreparedStatement ps = conn
                .prepareStatement("SELECT id, specialization, first_name, last_name FROM veterinarians WHERE id=?;")){
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                veterinarian.setId(resultSet.getLong(1));
                veterinarian.setSpecialization(resultSet.getString(2));
                veterinarian.setFirstName(resultSet.getString(3));
                veterinarian.setLastName(resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
        return veterinarian;
    }

    @Override
    public void saveEntity(Veterinarian entity) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("INSERT INTO veterinarians (specialization, first_name, last_name) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, entity.getSpecialization());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());

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
    public void updateEntity(Veterinarian entity) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("UPDATE veterinarians SET specialization = ?, first_name = ?, last_name = ? WHERE id = ?;")){
            ps.setString(1, entity.getSpecialization());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.setLong(4,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public void removeEntity(Veterinarian entity) {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("DELETE FROM veterinarians WHERE ?;")){
            ps.setLong(1,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
    }

    @Override
    public List<Veterinarian> getEntities() {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        Connection conn = connectionPool.getConnection();

        List<Veterinarian> list = new ArrayList<>();

        try (PreparedStatement ps = conn
                .prepareStatement("SELECT id, specialization, first_name, last_name FROM veterinarians;")){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Veterinarian veterinarian = new Veterinarian();
                veterinarian.setId(resultSet.getLong(1));
                veterinarian.setSpecialization(resultSet.getString(2));
                veterinarian.setFirstName(resultSet.getString(3));
                veterinarian.setLastName(resultSet.getString(4));
                list.add(veterinarian);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            connectionPool.releaseConnection(conn);
        }
        return list;
    }
}
