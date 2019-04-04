package com.yl.utils;

import java.sql.*;

/**
 * 工具类
 * 作用是初始化和连接数据库，释放资源
 */
public class JdbcUtil {
    public static Connection getConection() {
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/task1?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "123456";
        Connection c = null;
        try {
            c = DriverManager.getConnection(url, user, password);
            Class.forName(Driver);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c;
    }

    /**
     * 定义一个静态方法，用于释放资源
     */
    public static void close(PreparedStatement ps, Connection c) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}


