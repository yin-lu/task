package com.yl;

import com.yl.mapper.StudentMapper;
import com.yl.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

//表明是Spring的测试类
@RunWith(SpringJUnit4ClassRunner.class)
//定位Spring配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class TestStudent {
    /**
     * 获取日志对象
     */
    static Logger logger = Logger.getLogger(String.valueOf(TestStudent.class));
    /**
     * 给测试类装配Category对象
     */
    @Autowired
    private StudentMapper studentMapper;
    Student s = new Student();

    /**
     * 插入数据
     **/
    @Test
    public void demo1() {
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
        studentMapper.add(s);
        logger.info(String.valueOf(s.getId()));
    }

    /**
     * 按id删除数据
     **/
    @Test
    public void demo2() {
        int i = studentMapper.delete(33);
        if (i == 1) {
            logger.info("true");
        } else {
            logger.info("false");
        }
    }

    /**
     * 更改某id 学生的wish
     */
    @Test
    public void demo3() {
        s.setWish("高薪");
        s.setId(1);
        int i = studentMapper.update(s);
        if (i == 1) {
            logger.info("true");
        } else {
            logger.info("false");
        }
    }

    /**
     * 按学号查询学生数据并打印
     */
    @Test
    public void demo4() {
        s = studentMapper.getByNumber(1234);
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
    }

    /**
     * 按姓名查询学生数据并打印
     */
    @Test
    public void demo5() {
        s = studentMapper.getByName("李四");
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
    }
}

