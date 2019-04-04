package com.yl.mapper;

import com.yl.pojo.Student;
import org.apache.ibatis.annotations.*;

public interface StudentMapper {
    @Insert("insert into student (id,name,number,qq,subject,join_time,school,wish,instructor,know_from,create_at,update_at)" +
            "values(#{id},#{name},#{number},#{qq},#{subject},#{joinTime},#{school},#{wish},#{instructor},#{knowFrom},#{createAt},#{updateAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int add(Student student);

    @Delete("delete from student where id=#{id}")
    public int delete(int id);

    @Update("update student set wish=#{wish} where id=#{id}")
    public int update(Student student);

    @Select("select * from student where number=#{number}")
    public Student getByNumber(int number);

    @Select("select * from student where name=#{name}")
    public Student getByName(String name);
}
