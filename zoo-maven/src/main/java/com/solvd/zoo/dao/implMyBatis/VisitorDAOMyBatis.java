package com.solvd.zoo.dao.implMyBatis;

import com.solvd.zoo.dao.IVisitorDAO;
import com.solvd.zoo.model.Visitor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class VisitorDAOMyBatis implements IVisitorDAO {
    private static final Logger LOGGER = LogManager.getLogger(PassportDAOMyBatis.class);
    private static final SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    @Override
    public Visitor getEntityById(long id) {
        Visitor visitor = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
            visitor = mapper.getEntityById(id);
        }
        return visitor;
    }

    @Override
    public void saveEntity(Visitor entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
            mapper.saveEntity(entity);
            session.commit();
        }
    }

    @Override
    public void updateEntity(Visitor entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
            mapper.updateEntity(entity);
            session.commit();
        }
    }

    @Override
    public void removeEntity(Visitor entity) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
            mapper.removeEntity(entity);
            session.commit();
        }
    }

    @Override
    public List<Visitor> getEntities() {
        List<Visitor> visitors;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IVisitorDAO mapper = session.getMapper(IVisitorDAO.class);
            visitors = mapper.getEntities();
        }
        return visitors;
    }
}
