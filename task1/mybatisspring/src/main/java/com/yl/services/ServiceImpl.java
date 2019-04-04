package com.yl.services;

import com.yl.mapper.StudentMapper;
import com.yl.pojo.Student;
import com.yl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class ServiceImpl implements StudentService {
    /***/
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean add(Student student) {
        int a = studentMapper.add(student);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        int a = studentMapper.delete(id);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean update(Student student) {
        int a = studentMapper.update(student);
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Student getByNumber(int number) {
        return studentMapper.getByNumber(number);
    }

    @Override
    public Student getByName(String name) {
        return studentMapper.getByName(name);
    }

    @Override
    public int batchInsert(List<Student> list) {
        return studentMapper.batchInsert(list);
    }
}
