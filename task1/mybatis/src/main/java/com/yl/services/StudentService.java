package com.yl.services;

import com.yl.pojo.Student;

import java.util.List;

public interface StudentService {
    public int add(Student student);

    public boolean delete(int id);

    public boolean update(Student student);

    public Student getByNumber(int number);

    public Student getByName(String name);

    public int batchInsert(List<Student> list);
}
