package com.atguigu1.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的工具类
 * @author shkstart
 * @create 2020-04-17 9:54
 */
public class JDBCUtils {
    /**
     * 获取数据库的连接
     * @return 连接
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //读取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        System.out.println(is);
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");
        //加载驱动
        Class.forName(driverClass);
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * 关闭连接和Steane
     * @param conn
     * @param ps
     */
    public static void closeResourece(Connection conn, Statement ps){
        try {
            if (ps!=null)
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn!=null)
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 关闭连接和Steane
     * @param conn
     * @param ps
     */
    public static void closeResourece(Connection conn, Statement ps,ResultSet rs){
        try {
            if (ps!=null)
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn!=null)
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs!=null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
