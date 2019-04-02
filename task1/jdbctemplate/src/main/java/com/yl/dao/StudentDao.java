package com.yl.dao;


import com.yl.pojo.Student;

public interface StudentDao {
    public int add(final Student s);

    public boolean delete(int id);

    public boolean update(Student student);

    public Student getByNumber(int number);

    public Student getByName(String name);

}
