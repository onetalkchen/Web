package com.atguigu3.preparedstatement.curd;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @author shkstart
 * @create 2020-04-17 12:07
 */
public class OrderForQuery {
   @Test
    public void testQuery1() throws Exception{
       Connection conn = JDBCUtils.getConnection();
       String sql = "SELECT id,NAME,email,birth FROM customers WHERE id = ?";
       PreparedStatement ps = conn.prepareStatement(sql);
       ps.setObject(1, 1);


       ResultSet rs = ps.executeQuery();
       ResultSetMetaData rsmd = rs.getMetaData();
       int columnCount = rsmd.getColumnCount();
       if (rs.next()) {
           Customer cust = new Customer();
           for (int i = 0; i < columnCount; i++) {
               Object columnValue = rs.getObject(i + 1);
               String columnName = rsmd.getColumnName(i + 1);
               Field field = Customer.class.getDeclaredField(columnName);
               field.setAccessible(true);//允许私有化可以访问
               field.set(cust, columnValue);
           }

       }
       JDBCUtils.closeResourece(conn, ps, rs);

   }
}
