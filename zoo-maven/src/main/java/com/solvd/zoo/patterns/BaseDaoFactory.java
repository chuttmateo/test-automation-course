package com.solvd.zoo.patterns;

import com.solvd.zoo.dao.IBaseDAO;

public abstract class BaseDaoFactory {
    public abstract IBaseDAO<?> getDaoImplementation(String dao);
}
