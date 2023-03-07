package com.myself.dosql.demo.service.impl;

import com.myself.dosql.demo.mapper.SqlMapper;
import com.myself.dosql.demo.service.SqlService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName SqlServiceImpl
 * @Description 实现通用数据库的操作
 * @Auther 1022
 * @Date 2023/3/7 13:14
 * @Version 1.0
 */
@Service
public class SqlServiceImpl implements SqlService {
    private SqlMapper sqlMapper;
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public void writesql(String sql) {
        sqlMapper.writesql(sql);
    }

    @Override
    public Object writesqlreturn(String sql) {
        PreparedStatement preparedStatement = null;
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionTemplate.getSqlSessionFactory(),
                sqlSessionTemplate.getExecutorType(), sqlSessionTemplate.getPersistenceExceptionTranslator());
        try {
            preparedStatement = sqlSession.getConnection().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(preparedStatement!=null)
                    preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            SqlSessionUtils.closeSqlSession(sqlSession,sqlSessionTemplate.getSqlSessionFactory());
        }
        return sqlMapper.writesqlreturn(sql);
    }
}
