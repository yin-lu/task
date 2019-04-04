package com.yl;

import com.yl.mapper.StudentMapper;
import com.yl.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TestStudent {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(TestStudent.class));
    Student s = new Student();
    /**
     * 读取mybatis配置文件，并读取成文字流形式（InputStream）
     */
    String resource = "mybatis-config.xml";
    InputStream inputStream;

    {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将读取后的参数交给SqlSessionFactory进行节点读取
     */
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    /**
     * 构建相应地session实例，实现sql语句
     */
    SqlSession session = sqlSessionFactory.openSession();
    StudentMapper mapper = session.getMapper(StudentMapper.class);

    /**
     * 插入数据
     * 打印插入主键id
     **/
    @Test
    public void add() {
        s.setName("王四");
        s.setNumber(1235);
        s.setQq(225874196);
        s.setSubject("web");
        s.setJoinTime(1553736884);
        s.setSchool("河北大学");
        s.setWish("成功");
        s.setInstructor("张龙");
        s.setKnowFrom("知乎");
        s.setCreateAt(1553736884);
        s.setUpdateAt(1553736884);
        mapper.add(s);
        session.commit();
        session.close();
        logger.info(String.valueOf(s.getId()));
    }

    /**
     * 按id删除数据
     **/
    @Test
    public void delete() {
        mapper.delete(47);
        session.commit();
        session.close();
    }

    /**
     * 更改某id 学生的wish
     */
    @Test
    public void update() {
        s.setId(2);
        s.setWish("老大最帅");
        mapper.update(s);
        session.commit();
        session.close();

    }

    /**
     * 按学号查询学生数据并打印
     */
    @Test
    public void getByNumber() {
        s = mapper.getByNumber(1234);
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
        session.commit();
        session.close();
    }

    /**
     * 按姓名查询学生数据并打印
     */
    @Test
    public void getByName() {
        s = mapper.getByName("王三");
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
        session.commit();
        session.close();
    }

    /**
     * 批量插入
     */
    @Test
    public void batchInsert() {
        long start = System.currentTimeMillis();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 4000; i++) {
            s.setName("王四");
            s.setNumber(1235 + i);
            s.setQq(225874196);
            s.setSubject("web");
            s.setJoinTime(1553736884);
            s.setSchool("河北大学");
            s.setWish("成功");
            s.setInstructor("张龙");
            s.setKnowFrom("知乎");
            s.setCreateAt(1553736884);
            s.setUpdateAt(1553736884);
            list.add(s);
            mapper.batchInsert(list);
        }
        session.commit();
        session.close();
        long end = System.currentTimeMillis();
        logger.info("---------------" + (start - end) + "---------------");
    }
}







