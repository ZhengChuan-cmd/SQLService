package com.myself.dosql.demo.service;

/**
 * @ClassName SqlService
 * @Description 通用数据库的操作
 * @Auther 1022
 * @Date 2023/3/7 13:14
 * @Version 1.0
 */
public interface SqlService {
    /**
     * 无返回运行sql语句
     * @param sql 需要运行的sql语句
     */
    void writeSql(String sql);

    /**
     * 有返回运行sql语句
     * @param sql 需要运行的sql语句
     * @return 数据库返回的数据
     */
    Object writeSqlReturn (String sql);
}
