package com.myself.dosql.demo;

import com.myself.dosql.demo.mapper.SqlMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName SqlTest
 * @Description sql测试类
 * @Auther 1022
 * @Date 2023/3/7 13:33
 * @Version 1.0
 */
@SpringBootTest
public class SqlTest {
    @Autowired
    private SqlMapper sqlMapper;
    @Test
    public void sqlTest1(){
        String sql="select id  from test1;";
        sqlMapper.writesql(sql);

    }
}
