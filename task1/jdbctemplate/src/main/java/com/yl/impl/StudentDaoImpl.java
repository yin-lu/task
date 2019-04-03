package com.yl.impl;

import com.yl.dao.StudentDao;
import com.yl.pojo.Student;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(StudentDaoImpl.class);

    /**
     * 插入数据 ，新增一个学生的记录
     * 返回插入学生id
     * 打印新增主键id
     */
    @Override
    public int add(final Student s) {
        final String sql = "insert into student values(null,?,?,?,?,?,?,?,?,?,?,?)";
        final KeyHolder holder = new GeneratedKeyHolder();
        this.getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, s.getName());
                ps.setInt(2, s.getNumber());
                ps.setInt(3, s.getQq());
                ps.setString(4, s.getSubject());
                ps.setLong(5, s.getJoinTime());
                ps.setString(6, s.getSchool());
                ps.setString(7, s.getWish());
                ps.setString(8, s.getInstructor());
                ps.setString(9, s.getKnowFrom());
                ps.setLong(10, s.getCreateAt());
                ps.setLong(11, s.getUpdateAt());
                return ps;
            }
        }, holder);
        int id = holder.getKey().intValue();
        logger.info("新增主键:" + id);
        return id;
    }

    /**
     * 删除数据，删除某个id的学生的所有数据
     * 删除成功返回true
     * 删除失败返回false
     */
    @Override
    public boolean delete(int id) {
        String sql = "delete from student where id=?";
        int a = this.getJdbcTemplate().update(sql, id);
        if (a == 1) {
            logger.info(true);
            return true;
        } else {
            logger.info(false);
            return false;
        }
    }

    /**
     * 更新数据，更新某个id的学生的的期望
     * 更改成功返回true
     * 更改失败返回false
     */
    @Override
    public boolean update(Student s) {
        String sql = "update student set wish=? where id=?";
        int a = this.getJdbcTemplate().update(sql, s.getWish(), s.getId());
        if (a == 1) {
            logger.info(true);
            return true;
        } else {
            logger.info(false);
            return false;
        }
    }

    /**
     * 按学号查找学生记录
     */
    @Override
    public Student getByNumber(int number) {
        String sql = "select * from student where number=?   ";
        Student s = this.getJdbcTemplate().queryForObject(sql, new StudentRowMapper(), number);
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
        return s;

    }

    /**
     * 按姓名查找学生记录
     */
    public Student getByName(String name) {
        String sql = "select * from student where name=?";
        Student s = this.getJdbcTemplate().queryForObject(sql, new StudentRowMapper(), name);
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
        return s;


    }

    class StudentRowMapper implements RowMapper<Student> {
        //rs为返回结果集，以每行为单位封装着
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student s = new Student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setNumber(rs.getInt("number"));
            s.setQq(rs.getInt("qq"));
            s.setSubject(rs.getString("subject"));
            s.setJoinTime(rs.getLong("join_time"));
            s.setSchool(rs.getString("school"));
            s.setWish(rs.getString("wish"));
            s.setInstructor(rs.getString("instructor"));
            s.setKnowFrom(rs.getString("know_from"));
            s.setCreateAt(rs.getLong("create_at"));
            s.setUpdateAt(rs.getLong("update_at"));

            return s;
        }
    }
}