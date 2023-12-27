package com.solvd.zoo.dao.implMyBatis;

import com.solvd.zoo.dao.IEmployeeDAO;
import com.solvd.zoo.model.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EmployeeDAOMyBatis implements IEmployeeDAO {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeDAOMyBatis.class);
    private static final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    @Override
    public Employee getEntityById(long id) {
        Employee employee = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEmployeeDAO mapper = session.getMapper(IEmployeeDAO.class);
            employee = mapper.getEntityById(id);
        }
        return employee;
    }

    @Override
    public void saveEntity(Employee entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEmployeeDAO mapper = session.getMapper(IEmployeeDAO.class);
            mapper.saveEntity(entity);
            session.commit();
        }
    }

    @Override
    public void updateEntity(Employee entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEmployeeDAO mapper = session.getMapper(IEmployeeDAO.class);
            mapper.updateEntity(entity);
            session.commit();
        }
    }

    @Override
    public void removeEntity(Employee entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEmployeeDAO mapper = session.getMapper(IEmployeeDAO.class);
            mapper.removeEntity(entity);
            session.commit();
        }
    }

    @Override
    public List<Employee> getEntities() {
        List<Employee> employees;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IEmployeeDAO mapper = session.getMapper(IEmployeeDAO.class);
            employees = mapper.getEntities();
        }
        return employees;
    }
}
