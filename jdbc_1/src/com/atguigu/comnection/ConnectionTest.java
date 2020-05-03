package com.atguigu.comnection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2020-04-16 22:52
 */
public class ConnectionTest {
    @Test
    public void testConnection1() throws SQLException {
        String url="jdbc:mysql://localhost:3306/test";
        Properties info=new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "tvb123456");

        Driver driver=new com.mysql.jdbc.Driver();
        Connection conn=driver.connect(url,info);
        System.out.println(conn);

    }
    @Test
    public void getConnection() throws Exception {
//        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        System.out.println(is);
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }
}
