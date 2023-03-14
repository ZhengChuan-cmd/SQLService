package com.myself.dosql.demo.controller;

import com.myself.dosql.demo.service.SqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SqlController
 * @Description
 * @Auther 1022
 * @Date 2023/3/14 10:24
 * @Version 1.0
 */
@RestController
@Slf4j
public class SqlController {
    @Autowired
    private SqlService sqlService;

    @RequestMapping(value = "/writeSqlReturn")
    public String writeSqlReturn(){
        String sql="select id  from test1;";
        String returnString=null;
        try {
            returnString=sqlService.writeSqlReturn(sql).toString();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return returnString;
    }
}
