package com.yl.service;

import com.yl.pojo.Student;

public interface StudentService {
    public int add(Student student);

    public boolean delete(int id);

    public boolean update(Student student);

    public Student getByNumber(int number);

    public Student getByName(String name);
}
