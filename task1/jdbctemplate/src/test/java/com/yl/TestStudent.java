package com.yl;

import com.yl.dao.StudentDao;
import com.yl.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:E:/task1/task1/jdbctemplate/src/main/resources/applicationContext.xml");
    StudentDao dao = (StudentDao) applicationContext.getBean("studentDao");
    Student s = new Student();

    /**
     * 插入数据
     */
    @Test
    public void demo1() {
        s.setName("张飞");
        s.setNumber(6666);
        s.setQq(12345678);
        s.setSubject("PM");
        s.setJoinTime(1553680711);
        s.setSchool("河北大学");
        s.setWish("吃肉");
        s.setInstructor("刘备");
        s.setKnowFrom("三国");
        s.setCreateAt(1553680711);
        s.setUpdateAt(1553680711);
        dao.add(s);
    }

    /**
     * 删除数据
     */
    @Test
    public void demo2() {
        dao.delete(14);
    }

    /**
     * 更新数据
     */
    @Test
    public void demo3() {
        s.setId(10);
        s.setWish("有钱");
        dao.update(s);
    }

    /**
     * 按学号查找学生记录
     * 并打印
     */
    @Test
    public void demo4() {
        dao.getByNumber(5555);
    }

    /**
     * 按姓名查找学生记录
     * 并打印
     */
    @Test
    public void demo5() {
        dao.getByName("王四");
    }
}