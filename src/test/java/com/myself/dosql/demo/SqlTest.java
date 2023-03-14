package com.myself.dosql.demo;

import com.myself.dosql.demo.service.SqlService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
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
@Slf4j
public class SqlTest {
    @Autowired
    private SqlService sqlService;
    @Test
    public void sqlTest1(){
        String sql="select id  from test1;";
        log.info(sqlService.writeSqlReturn(sql).toString());

    }
}
