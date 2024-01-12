package com.solvd.zoo.patterns;

import com.solvd.zoo.dao.IBaseDAO;
import com.solvd.zoo.dao.implMyBatis.AddressDAOMyBatis;
import com.solvd.zoo.dao.implMyBatis.EmployeeDAOMyBatis;
import com.solvd.zoo.dao.implMyBatis.PassportDAOMyBatis;
import com.solvd.zoo.dao.implMyBatis.VisitorDAOMyBatis;

public class MyBatisDaoFactory extends BaseDaoFactory {
    @Override
    public IBaseDAO<?> getDaoImplementation(String dao){
        return switch (dao) {
            case "address" -> new AddressDAOMyBatis();
            case "employee" -> new EmployeeDAOMyBatis();
            case "passport" -> new PassportDAOMyBatis();
            case "visitor" -> new VisitorDAOMyBatis();
            default -> throw new RuntimeException("Unable to find an implementation with this name " + dao);
        };
    }
}
