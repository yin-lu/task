package com.yl;

import com.yl.mapper.StudentMapper;
import com.yl.pojo.Student;
import com.yl.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//表明是Spring的测试类
@RunWith(SpringJUnit4ClassRunner.class)
//定位Spring配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class TestService {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(TestService.class));
    /**
     * 给测试类装配Category对象
     */
    @Autowired
    private StudentService studentService;
    Student s = new Student();

    /**
     * 插入数据
     **/
    @Test
    public void add() {
        s.setName("赵龙");
        s.setNumber(4558);
        s.setQq(15897456);
        s.setSubject("QA");
        s.setJoinTime(1554036184);
        s.setSchool("郑州大学");
        s.setWish("富有");
        s.setInstructor("张龙");
        s.setKnowFrom("贴吧");
        s.setCreateAt(1554036184);
        s.setUpdateAt(1554036184);
        studentService.add(s);
        logger.info(String.valueOf(s.getId()));
    }

    /**
     * 按id删除数据
     **/
    @Test
    public void delete() {
        studentService.delete(33);

    }

    /**
     * 更改某id 学生的wish
     */
    @Test
    public void update() {
        s.setWish("高薪");
        s.setId(1);
        studentService.update(s);
    }


    /**
     * 按学号查询学生数据并打印
     */
    @Test
    public void getByNumber() {
        s = studentService.getByNumber(1234);
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
    }

    /**
     * 按姓名查询学生数据并打印
     */
    @Test
    public void getByName() {
        s = studentService.getByName("王三");
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
    }

    /**
     * 批量插入
     */
    @Test
    public void batchInsert() {
        long start = System.currentTimeMillis();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            s.setName("赵虎");
            s.setNumber(4567);
            s.setQq(12548774);
            s.setSubject("IU");
            s.setJoinTime(1553763321);
            s.setSchool("郑州大学");
            s.setWish("富有");
            s.setInstructor("张龙");
            s.setKnowFrom("贴吧");
            s.setCreateAt(1553763321);
            s.setUpdateAt(1553763321);
            list.add(s);
            studentService.batchInsert(list);
        }
        long end = System.currentTimeMillis();
        logger.info("---------------" + (start - end) + "---------------");

    }
}

