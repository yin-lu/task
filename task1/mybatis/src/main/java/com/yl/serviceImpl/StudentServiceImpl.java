package com.yl.serviceImpl;

import com.yl.mapper.StudentMapper;
import com.yl.pojo.Student;
import com.yl.services.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

public class StudentServiceImpl implements StudentService {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(StudentServiceImpl.class));
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
    StudentMapper service = session.getMapper(StudentMapper.class);

    /**
     * 插入数据
     * 日志记录插入id
     */
    @Override
    public int add(Student student) {
        service.add(student);
        session.commit();
        session.close();
        logger.info("新增id：" + student.getId());
        return student.getId();

    }

    /**
     * 删除数据
     */
    @Override
    public boolean delete(int id) {
        int a = service.delete(id);
        session.commit();
        session.close();
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 更新数据
     */
    @Override
    public boolean update(Student student) {
        int a = service.update(student);
        session.commit();
        session.close();
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 按学号查找学生记录
     * 并打印
     */
    @Override
    public Student getByNumber(int number) {
        Student s = new Student();
        s = service.getByNumber(number);
        session.commit();
        session.close();
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
        return s;
    }

    /**
     * 按姓名查找学生记录
     * 并打印
     */
    @Override
    public Student getByName(String name) {
        Student s = new Student();
        s = service.getByName(name);
        session.commit();
        session.close();
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
        return s;
    }

    /**
     * 批量插入
     */
    @Override
    public int batchInsert(List<Student> list) {
        int a = service.batchInsert(list);
        session.commit();
        return a;
    }

}
