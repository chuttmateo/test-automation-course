package com.solvd.zoo.patterns;

import com.solvd.zoo.model.enums.Factory;

public class AbstractFactory {
    public static BaseDaoFactory getFactory(Factory factory) {
        return switch (factory) {
            case MYSQL -> new MysqlDaoFactory();
            case MYBATIS -> new MyBatisDaoFactory();
        };
    }
}
