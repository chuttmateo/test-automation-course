package com.solvd.zoo.dao.implMyBatis;

import com.solvd.zoo.dao.IAddressDAO;
import com.solvd.zoo.model.Address;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class AddressDAOMyBatis implements IAddressDAO {
    private static final Logger LOGGER = LogManager.getLogger(AddressDAOMyBatis.class);
    private static final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();


    @Override
    public Address getEntityById(long id) {
        Address address = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
            address = mapper.getEntityById(id);
        }
        return address;
    }

    @Override
    public void saveEntity(Address entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
            mapper.saveEntity(entity);
            session.commit();
        }
    }

    @Override
    public void updateEntity(Address entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
            mapper.updateEntity(entity);
            session.commit();
        }
    }

    @Override
    public void removeEntity(Address entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
            mapper.removeEntity(entity);
            session.commit();
        }
    }

    @Override
    public List<Address> getEntities() {
        List<Address> list;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAddressDAO mapper = session.getMapper(IAddressDAO.class);
            list = mapper.getEntities();
            //list = session.selectList("com.solvd.zoo.dao.IAddressDAO.getEntities");
        }
        return list;
    }
}

