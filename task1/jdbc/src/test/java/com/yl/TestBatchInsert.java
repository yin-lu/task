package com.yl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class TestBatchInsert {
    static Logger logger = Logger.getLogger(String.valueOf(TestStudent.class));

    public static void main(String[] args) {
        //初始化驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/task1?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
                    "root", "123456");
            String sql = "insert into student values(null,?,?,?,?,?,?,?,?,?,?,?)";
            long startTime = System.currentTimeMillis();
            c.setAutoCommit(false);//设置不自动提交
            PreparedStatement ps = c.prepareStatement(sql);
            for (int i = 0; i < 10000; i++) {
                ps.setString(1, "赵子龙");
                ps.setInt(2, 5895);
                ps.setInt(3, 89685485);
                ps.setString(4, "PM");
                ps.setLong(5, 1553680711);
                ps.setString(6, "郑州大学");
                ps.setString(7, "有钱");
                ps.setString(8, "刘备");
                ps.setString(9, "三国");
                ps.setLong(10, 1553680711);
                ps.setLong(11, 1553680711);
                ps.addBatch();
            }
            ps.executeBatch();
            c.commit();
            ps.close();
            c.close();
            long endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            logger.info("程序运行时间：" + time + "ms");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

