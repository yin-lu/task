package com.yl;

import com.yl.pojo.Student;
import com.yl.services.StudentService;
import com.yl.serviceImpl.StudentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestService {
    StudentService service = new StudentServiceImpl();
    Student s = new Student();

    /**
     * 插入数据
     */
    @Test
    public void add() {
        s.setName("王六");
        s.setNumber(4587);
        s.setQq(23658977);
        s.setSubject("java");
        s.setJoinTime(1553736884);
        s.setSchool("湖北大学");
        s.setWish("成功");
        s.setInstructor("张龙");
        s.setKnowFrom("知乎");
        s.setCreateAt(1553736884);
        s.setUpdateAt(1553736884);
        service.add(s);
    }

    /**
     * 删除数据
     */
    @Test
    public void delete() {
        service.delete(45);

    }

    /**
     * 更新数据
     */
    @Test
    public void update() {
        s.setId(10);
        s.setWish("成功");
        service.update(s);

    }

    /**
     * 按学号查找学生记录
     * 并打印
     */
    @Test
    public void getByNumber() {
        service.getByNumber(1234);
    }

    /**
     * 按姓名查找学生记录
     * 并打印
     */
    @Test
    public void getByName() {
        service.getByName("王二");

    }

    @Test
    public void batchInsert() {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
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
            service.batchInsert(list);
        }
    }
}


