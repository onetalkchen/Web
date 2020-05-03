package com.atguigui.utils;

import java.sql.Connection;

/**
 * @author shkstart
 * @create 2020-04-16 21:19
 */
public class JdbcUtils {
    /**
     * 获取数据库连接池中的连接
     * @return
     */
    public static Connection getConnection(){
        return null;
    }

    /**
     * 关闭连接，放回数据库连接池
     * @param conn
     */
    public static void close(Connection conn){

    }
}
