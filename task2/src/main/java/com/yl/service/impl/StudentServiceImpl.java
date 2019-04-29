package com.yl.service.impl;

import com.yl.mapper.StudentMapper;
import com.yl.pojo.Student;
import com.yl.service.StudentService;
import com.yl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    /***/
    @Autowired
    private StudentMapper studentMapper;

    //查询全表数据
    @Override
    public List<Student> listStudent() {
        return studentMapper.listStudent();
    }

    //查询数据记录数
    @Override
    public int total() {
        return studentMapper.total();
    }

    //查询全表并将数据分页
    @Override
    public List<Student> list(Page page) {
        return studentMapper.list(page);
    }

    //增加学员数据
    @Override
    public boolean add(Student student) {
        int a = studentMapper.add(student);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    //删除学员数据
    @Override
    public boolean delete(int id) {
        int a = studentMapper.delete(id);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    //更新学员数据
    @Override
    public boolean update(Student student) {
        int a = studentMapper.update(student);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    //按id查找学员数据
    @Override
    public Student getById(int id) {
        return studentMapper.getById(id);
    }

    //按姓名模糊查询
    public List<Student> getByName(String name) {
        return studentMapper.getByName(name);
    }
}
