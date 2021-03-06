package com.yl;

import com.yl.pojo.Student;
import com.yl.services.StudentService;
import com.yl.serviceImpl.StudentServiceImpl;
import org.junit.Test;

public class TestService {
    StudentService service = new StudentServiceImpl();
    Student s = new Student();

    /**
     * 插入数据
     */
    @Test
    public void add() {
        s.setName("周星驰");
        s.setNumber(8574);
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
        service.delete(48);

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
}
