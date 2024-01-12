package com.solvd.zoo.patterns;

import com.solvd.zoo.dao.IBaseDAO;
import com.solvd.zoo.dao.impl.AddressDAO;
import com.solvd.zoo.dao.impl.EmployeeDAO;
import com.solvd.zoo.dao.impl.PassportDAO;
import com.solvd.zoo.dao.impl.VisitorDAO;

public class MysqlDaoFactory extends BaseDaoFactory {
    @Override
    public IBaseDAO<?> getDaoImplementation(String dao){
        IBaseDAO<?> impl = null;
        return switch (dao) {
            case "address" -> new AddressDAO();
            case "employee" -> new EmployeeDAO();
            case "passport" -> new PassportDAO();
            case "visitor" -> new VisitorDAO();
            default -> throw new RuntimeException("Unable to find an implementation with this name " + dao);
        };
    }
}
