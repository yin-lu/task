package com.yl.service;

import com.yl.entity.Student;
import com.yl.utils.Page;


import java.util.List;

public interface StudentService {
    //查询全表数据
    List<Student> listStudent();

    //查询数据记录数
    int total();

    //结业人数
    int graTotal();

    //查询全表并将数据分页
    List<Student> list(Page page);

    //增加学员数据
    int add(Student student);

    //删除学员数据
    int delete(int id);

    //更新学员数据
    int update(Student student);

    //按id查找学员数据
    Student getById(int id);

    //按姓名模糊查询
    List<Student> getByName(String name);

    List<Student> salaryList();

}


