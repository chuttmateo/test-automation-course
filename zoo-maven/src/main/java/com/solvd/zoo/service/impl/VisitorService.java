package com.solvd.zoo.service.impl;

import com.solvd.zoo.dao.IVisitorDAO;
import com.solvd.zoo.model.Visitor;
import com.solvd.zoo.service.IVisitorService;

import java.util.List;

public class VisitorService implements IVisitorService {
    private final IVisitorDAO visitorDAO;

    public VisitorService(IVisitorDAO visitorDAO) {
        this.visitorDAO = visitorDAO;
    }

    @Override
    public Visitor getEntityById(long id) {
        return visitorDAO.getEntityById(id);
    }

    @Override
    public void saveEntity(Visitor entity) {
        visitorDAO.saveEntity(entity);
    }

    @Override
    public void updateEntity(Visitor entity) {
        visitorDAO.updateEntity(entity);
    }

    @Override
    public void removeEntity(Visitor entity) {
        visitorDAO.removeEntity(entity);
    }

    @Override
    public List<Visitor> getEntities() {
        return visitorDAO.getEntities();
    }
}
