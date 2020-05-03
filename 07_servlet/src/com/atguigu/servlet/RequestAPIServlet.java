package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author shkstart
 * @create 2020-04-16 16:04
 */

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
//        super.doGet(req, resp);
//        getRequestURI() 获取请求的资源路径
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);
//        ii. getRequestURL() 获取请求的统一资源定位符（绝对路径）
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);
//        iii. getRemoteHost() 获取客户端的ip 地址
//        iv. getHeader() 获取请求头
//        v. getParameter() 获取请求的参数
//        vi. getParameterValues() 获取请求的参数（多个值的时候使用）
//        vii. getMethod() 获取请求的方式GET 或POST
//        viii. setAttribute(key, value); 设置域数据
        PrintWriter writer = resp.getWriter();
        writer.write("你好");
        writer.write("one?");
    }
}
