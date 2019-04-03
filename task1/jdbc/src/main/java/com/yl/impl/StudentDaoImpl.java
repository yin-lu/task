package com.yl.impl;

import com.yl.dao.StudentDao;
import com.yl.pojo.Student;
import com.yl.utils.JdbcUtil;
import org.apache.log4j.Logger;

import java.sql.*;

public class StudentDaoImpl implements StudentDao {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(StudentDaoImpl.class);

    /**
     * 插入数据 ，新增一个学生的记录
     * 日志打印新增学生id
     */
    @Override
    public int add(Student student) {
        //调用工具类，初始化数据库驱动并连接数据库
        Connection c = JdbcUtil.getConection();
        String sql = "insert into student values(null,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getNumber());
            ps.setInt(3, student.getQq());
            ps.setString(4, student.getSubject());
            ps.setLong(5, student.getJoinTime());
            ps.setString(6, student.getSchool());
            ps.setString(7, student.getWish());
            ps.setString(8, student.getInstructor());
            ps.setString(9, student.getKnowFrom());
            ps.setLong(10, student.getCreateAt());
            ps.setLong(11, student.getUpdateAt());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                logger.debug("新增主键：" + id);
            }
            //调用工具类释放资源
            rs.close();
            JdbcUtil.close(ps, c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 删除数据，删除某个id的学生的所有数据
     * 删除成功返回true
     * 删除失败返回false
     */
    @Override
    public boolean delete(int id) {
        //调用工具类，初始化数据库驱动并连接数据库
        Connection c = JdbcUtil.getConection();
        String sql = "delete from student where id=? ";
        int a = 0;
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            a = ps.executeUpdate();
            //调用工具类，释放资源
            JdbcUtil.close(ps, c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 更新数据，更新某个id的学生的的期望
     * 更改成功返回true
     * 更改失败返回false
     */
    @Override
    public boolean update(Student student) {
        //调用工具类，初始化数据库驱动并连接数据库
        Connection c = JdbcUtil.getConection();
        int a = 0;
        try {
            String sql = "update student set wish=? where id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, student.getWish());
            ps.setInt(2, student.getId());
            a = ps.executeUpdate();
            //调用工具类，释放资源
            JdbcUtil.close(ps, c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 查询数据，根据学生的学号或姓名查询这名学生的所有数据
     * 并将查询到的记录打印
     */
    @Override
    public Student get(int number, String name) {
        //调用工具类，初始化数据库驱动并连接数据库
        Connection c = JdbcUtil.getConection();
        String sql = "select * from student where number=? or name=?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, number);
            ps.setString(2, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                int id = rs.getInt(1);
                name = rs.getString(2);
                number = rs.getInt(3);
                int qq = rs.getInt(4);
                String subject = rs.getString(5);
                long joinTime = rs.getLong(6);
                String school = rs.getString(7);
                String wish = rs.getString(8);
                String instructor = rs.getString(9);
                String knowFrom = rs.getString(10);
                long createAt = rs.getLong(11);
                long updateAt = rs.getLong(12);
                logger.debug(id + " " + name + " " + number + " " + qq + " " + subject + " " + joinTime + " " + school + " " + wish + " " + instructor + " " + knowFrom + " " + createAt + " " + updateAt);
            }
            //调用工具类，释放资源
            rs.close();
            JdbcUtil.close(ps, c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
