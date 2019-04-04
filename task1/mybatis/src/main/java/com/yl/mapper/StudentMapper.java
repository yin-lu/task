package com.yl.mapper;

import com.yl.pojo.Student;

import java.util.List;

public interface StudentMapper {
    public int add(Student student);

    public int delete(int id);

    public int update(Student student);

    public Student getByNumber(int number);

    public Student getByName(String name);

    public int batchInsert(List<Student> list);

}
