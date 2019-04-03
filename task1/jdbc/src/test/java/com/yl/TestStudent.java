package com.yl;


import com.yl.impl.StudentDaoImpl;
import com.yl.pojo.Student;
import org.junit.Test;
/**
 * 测试类
 * */
public class TestStudent {
    /**
     * 插入数据
     * */
    @Test
    public void add(){

        StudentDaoImpl dao = new StudentDaoImpl();
        Student s=new Student();
//        s.setId(6);
        s.setName("李四");
        s.setNumber(5555);
        s.setQq(8888888);
        s.setSubject("web");
        s.setJoinTime(1553680347);
        s.setSchool("武大");
        s.setWish("高兴");
        s.setInstructor("王伟");
        s.setKnowFrom("知乎");
        s.setCreateAt(1553680347);
        s.setUpdateAt(1553680347);
        dao.add(s);
    }

    /**
     * 删除数据
     * */
    @Test
    public void delete() {
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.delete(32);
    }
    /**
     * 更新数据
     * */
    @Test
    public void update(){
        StudentDaoImpl dao = new StudentDaoImpl();
        Student s=new Student();
        s.setId(3);
        s.setWish("有钱");
        dao.update(s);
    }
    /**
     * 按学号或姓名查找学生记录
     * 并打印
     * */
    @Test
    public void get(){
        StudentDaoImpl dao = new StudentDaoImpl();
        dao.get(1112,"张飞");
    }

}