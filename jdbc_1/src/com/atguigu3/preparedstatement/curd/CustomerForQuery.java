package com.atguigu3.preparedstatement.curd;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @author shkstart
 * @create 2020-04-17 10:53
 */
public class CustomerForQuery {
    @Test
    public void selectTest() throws Exception {
        String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
        Customer customer = queryForCustomers(sql, 4);
        System.out.println("customer = " + customer);
    }

    public Customer queryForCustomers(String sql, Object... args) throws Exception {
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        if (rs.next()) {
            Customer cust = new Customer();
            for (int i = 0; i < columnCount; i++) {
                Object columnValue = rs.getObject(i + 1);
//                String columnName = rsmd.getColumnName(i + 1);
                String columnName = rsmd.getColumnLabel(i + 1);
                Field field = Customer.class.getDeclaredField(columnName);
                field.setAccessible(true);//允许私有化可以访问
                field.set(cust, columnValue);
            }
            return cust;
        }
        JDBCUtils.closeResourece(conn, ps, rs);
        return null;

    }

    @Test
    public void testQuery1() throws Exception {
        Connection conn = JDBCUtils.getConnection();
//        String sql="select id,name,email,birth from custosers where id=?";
        String sql = "select id,name,email,birth from customers where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, 2);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Date birth = resultSet.getDate(4);
            Customer customer = new Customer(id, name, email, birth);
            System.out.println(customer);
        }

        JDBCUtils.closeResourece(conn, ps, resultSet);

    }

}
