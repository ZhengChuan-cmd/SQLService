package com.myself.dosql.demo.service.impl;

import com.myself.dosql.demo.mapper.SqlMapper;
import com.myself.dosql.demo.service.SqlService;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public void writeSql(String sql) {
        sqlMapper.writesql(sql);
    }

    @Override
    public Object writeSqlReturn(String sql) {
        List<Map<String, Object>> maps = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        //获取到sqlsession
        SqlSession sqlSession = SqlSessionUtils.getSqlSession(sqlSessionTemplate.getSqlSessionFactory(),
                sqlSessionTemplate.getExecutorType(), sqlSessionTemplate.getPersistenceExceptionTranslator());
        try {
            //获取返回值
            preparedStatement = sqlSession.getConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            //获取set中的元素
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取列数
            int columnCount = metaData.getColumnCount();
            while(resultSet.next()){
                Map<String, Object> rowDate = new HashMap<String, Object>();
                for(int i=1;i<=columnCount;i++){
                    rowDate.put(metaData.getColumnName(i),resultSet.getObject(i));
                }
                maps.add(rowDate);
            }
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
        return maps;
    }
}
