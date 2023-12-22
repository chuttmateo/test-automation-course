package com.solvd.zoo.dao.impl;

import com.solvd.zoo.dao.IEmployeeDAO;
import com.solvd.zoo.dao.connectionpool.ConnectionPool;
import com.solvd.zoo.model.Address;
import com.solvd.zoo.model.Employee;
import com.solvd.zoo.model.Passport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getConnectionPool();
    @Override
    public Employee getEntityById(long id) {
        Connection conn = CONNECTION_POOL.getConnection();

        Employee employee = new Employee();

        try (PreparedStatement ps = conn
                .prepareStatement("SELECT id, first_name, last_name, passport_id, address_id FROM employees WHERE id=?")){
            ps.setLong(1, id);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                employee.setId(resultSet.getLong(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));

                Passport p = new Passport();
                p.setId(resultSet.getLong(4));
                employee.setPassport(p);

                Address a = new Address();
                a.setId(resultSet.getLong(5));
                employee.setAddress(a);
            }
            resultSet.close();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
        return employee;
    }

    @Override
    public void saveEntity(Employee entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("INSERT INTO employees (first_name,last_name,passport_id,address_id)VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setLong(3, entity.getPassport().getId());
            ps.setLong(4, entity.getAddress().getId());

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
    public void updateEntity(Employee entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("UPDATE employees SET first_name=?, last_name=?, passport_id=?, address_id=? WHERE id=?")){
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setLong(3,entity.getPassport().getId());
            ps.setLong(4,entity.getAddress().getId());
            ps.setLong(5,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public void removeEntity(Employee entity) {
        Connection conn = CONNECTION_POOL.getConnection();

        if (entity == null) return;

        try (PreparedStatement ps = conn
                .prepareStatement("DELETE FROM employees WHERE id=?")){
            ps.setLong(1,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }finally {
            CONNECTION_POOL.releaseConnection(conn);
        }
    }

    @Override
    public List<Employee> getEntities() {
        Connection conn = CONNECTION_POOL.getConnection();

        List<Employee> list = new ArrayList<>();

        try (PreparedStatement ps = conn
                .prepareStatement("SELECT e.id, e.first_name, e.last_name, e.passport_id, p.number, e.address_id, a.city FROM employees e\n" +
                        "INNER JOIN addresses a ON e.address_id = a.id\n" +
                        "INNER JOIN passports p ON e.passport_id = p.id;")){
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));

                Passport p = new Passport(
                        resultSet.getLong(4),
                        resultSet.getString(5)
                );
                employee.setPassport(p);

                Address a = new Address(
                        resultSet.getLong(6),
                        resultSet.getString(7)
                );
                employee.setAddress(a);
                list.add(employee);
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
