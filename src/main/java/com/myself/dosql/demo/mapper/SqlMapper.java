package com.myself.dosql.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName SqlMapper
 * @Description 通用数据库的操作
 * @Auther zhengchuan
 * @Date 2023/3/7 13:20
 * @Version 1.0
 */
@Mapper
public interface SqlMapper {
    /**
     * 无返回运行sql语句
     * @param sql 需要运行的sql语句
     */
    void writesql(String sql);

    /**
     * 有返回运行sql语句
     * @param sql 需要运行的sql语句
     * @return 数据库返回的数据
     */
    Object writesqlreturn (String sql);
}
