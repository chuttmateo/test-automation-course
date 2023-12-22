package com.solvd.zoo.dao.impl;

import com.solvd.zoo.dao.IVeterinarianDAO;
import com.solvd.zoo.dao.connectionpool.ConnectionPool;
import com.solvd.zoo.model.Veterinarian;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDAO implements IVeterinarianDAO {
    private static final Logger LOGGER = LogManager.getLogger(VeterinarianDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getConnectionPool();

    @Override
    public Veterinarian getEntityById(long id) {
        Connection conn = CONNECTION_POOL.getConnection();

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
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
        return veterinarian;
    }

    @Override
    public void saveEntity(Veterinarian entity) {
        Connection conn = CONNECTION_POOL.getConnection();

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
            generatedKeys.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }

    }

    @Override
    public void updateEntity(Veterinarian entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("UPDATE veterinarians SET specialization = ?, first_name = ?, last_name = ? WHERE id = ?;")){
            ps.setString(1, entity.getSpecialization());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.setLong(4,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public void removeEntity(Veterinarian entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("DELETE FROM veterinarians WHERE ?;")){
            ps.setLong(1,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public List<Veterinarian> getEntities() {
        Connection conn = CONNECTION_POOL.getConnection();

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
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
        return list;
    }
}
