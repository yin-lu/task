package com.yl.service.impl;

import com.yl.mapper.StudentMapper;
import com.yl.entity.Student;
import com.yl.service.StudentService;
import com.yl.utils.RedisUtil;
import com.yl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    Logger logger = Logger.getLogger(String.valueOf(StudentServiceImpl.class));
    /***/
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisUtil redisUtil;

    //查询全表数据
    @Override
    public List<Student> listStudent() {
        List<Student> students = (List<Student>) redisUtil.get("students");
        if (students == null) {
            students = studentMapper.listStudent();
            redisUtil.set("students", students, Long.valueOf(60 * 60 * 24));
        }
        return students;
    }

    //查询数据记录数
    @Override
    public int total() {
        Integer total = (Integer) redisUtil.get("total");
        if (total == null) {
            total = studentMapper.total();
            redisUtil.set("total", total, Long.valueOf(60 * 60 * 24));
        }
        return total;
    }

    @Override
    public int graTotal() {
        Integer graTotal = (Integer) redisUtil.get("graTotal");
        if (graTotal == null) {
            graTotal = studentMapper.graTotal();
            redisUtil.set("graTotal", graTotal, Long.valueOf(60 * 60 * 24));
        }
        return graTotal;
    }

    //查询全表并将数据分页
    @Override
    public List<Student> list(Page page) {
        List<Student> students = (List<Student>) redisUtil.get("students" + page.getStart());
        if (students == null) {
            students = studentMapper.list(page);
            redisUtil.set("students" + page.getStart(), students, Long.valueOf(60 * 60 * 24));
        }
        return students;
    }

    //增加学员数据
    @Override
    public int add(Student student) {
        int id = studentMapper.add(student);
        if (id == 1) {
            redisUtil.set("student" + id, student, Long.valueOf(60 * 60 * 24));
            logger.info("student" + id);
        }
        return id;
    }

    //删除学员数据
    @Override
    public int delete(int id) {
        int a = studentMapper.delete(id);
        if (a == 1) {
            redisUtil.remove("student" + id);
            logger.info("student" + id);
        }
        return a;
    }

    //更新学员数据
    @Override
    public int update(Student student) {
        int a = studentMapper.update(student);
        if (a == 1) {
            redisUtil.set("student" + student.getId(), student, Long.valueOf(60 * 60 * 24));
            logger.info("student" + student.getId());
        }
        return a;
    }

    //按id查找学员数据
    @Override
    public Student getById(int id) {
        Student student = (Student) redisUtil.get("student" + id);
        if (student == null) {
            student = studentMapper.getById(id);
            redisUtil.set("student" + id, student, Long.valueOf(60 * 60 * 24));
        }
        return student;
    }

    //按姓名模糊查询
    public List<Student> getByName(String name) {
        List<Student> students = (List<Student>) redisUtil.get("students" + name);
        if (students == null) {
            students = studentMapper.getByName(name);
            redisUtil.set("students" + name, students, Long.valueOf(60 * 60 * 24));
        }
        return students;
    }

    @Override
    public List<Student> salaryList() {
        List<Student> listSalary = (List<Student>) redisUtil.get("listSalary");
        if (listSalary == null) {
            listSalary = studentMapper.salaryList();
            redisUtil.set("listSalary", listSalary, Long.valueOf(60 * 60 * 24));
        }
        return listSalary;
    }
}
