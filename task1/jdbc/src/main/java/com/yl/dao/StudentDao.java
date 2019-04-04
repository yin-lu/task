package com.yl.dao;


import com.yl.pojo.Student;

public interface StudentDao {
    public int add(Student student);

    public boolean delete(int id);

    public boolean update(Student student);

    public Student get(int number, String name);


}
