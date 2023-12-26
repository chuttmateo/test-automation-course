package com.solvd.zoo.dao.implMyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisConfig {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisConfig.class);
    private static final SqlSessionFactory sqlSessionFactory;
    private static Reader reader = null;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            LOGGER.warn(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
