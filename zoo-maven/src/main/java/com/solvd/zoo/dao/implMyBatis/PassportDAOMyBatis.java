package com.solvd.zoo.dao.implMyBatis;

import com.solvd.zoo.dao.IPassportDAO;
import com.solvd.zoo.model.Passport;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PassportDAOMyBatis implements IPassportDAO {
    private static final Logger LOGGER = LogManager.getLogger(PassportDAOMyBatis.class);
    private static final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    @Override
    public Passport getEntityById(long id) {
        Passport passport = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPassportDAO mapper = session.getMapper(IPassportDAO.class);
            passport = mapper.getEntityById(id);
        }
        return passport;
    }

    @Override
    public void saveEntity(Passport entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPassportDAO mapper = session.getMapper(IPassportDAO.class);
            mapper.saveEntity(entity);
            session.commit();
        }
    }

    @Override
    public void updateEntity(Passport entity) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IPassportDAO mapper = session.getMapper(IPassportDAO.class);
            mapper.updateEntity(entity);
            session.commit();
        }
    }

    @Override
    public void removeEntity(Passport entity) {
        try (SqlSession session = sqlSessionFactory.openSession()){
            IPassportDAO mapper = session.getMapper(IPassportDAO.class);
            mapper.removeEntity(entity);
            session.commit();
        }
    }

    @Override
    public List<Passport> getEntities() {
        List<Passport> passports = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPassportDAO mapper = session.getMapper(IPassportDAO.class);
            passports = mapper.getEntities();
        }
        return passports;
    }
}
