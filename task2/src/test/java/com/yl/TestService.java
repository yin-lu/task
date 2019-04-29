package com.yl;
import com.yl.pojo.Student;
import com.yl.service.StudentService;
import com.yl.utils.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;
import java.util.logging.Logger;

//表明是Spring的测试类
@RunWith(SpringJUnit4ClassRunner.class)
//定位Spring配置文件
@ContextConfiguration("classpath:spring-mybatis.xml")
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
        s.setName("张三飞");
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

        studentService.delete(20);

    }

    /**
     * 更改学员数据
     */
    @Test
    public void update() {
        s.setName("李云");
        s.setNumber(6667);
        s.setQq(36925874);
        s.setSubject("Java");
        s.setJoinTime(20160205);
        s.setSchool("郑州大学");
        s.setWish("高薪");
        s.setInstructor("张龙");
        s.setKnowFrom("贴吧");
        s.setCreateAt(20160205);
        s.setUpdateAt(20160205);
        s.setId(1);
        studentService.update(s);
    }
    /**
     *查询从第(start+1)条数据开始的count条学员数据
     */
    @Test
    public void pageStudent() {
        Page page = new Page();
        page.setStart(5);
        page.setCount(5);
        List<Student> students = studentService.list(page);
        for (Student student : students) {
            logger.info(String.valueOf( student));
        }
    }

    /**
     * 按学号查询学生数据并打印
     */
    @Test
    public void getById() {
        s = studentService.getById(4);
        logger.info(s.getId() + " " + s.getName() + " " + s.getNumber() + " " + s.getQq() + " " + s.getSubject() + " " + s.getJoinTime() + " "
                + s.getSchool() + " " + s.getWish() + " " + s.getInstructor() + " " + s.getKnowFrom() + " " + s.getCreateAt() + " " + s.getUpdateAt());
    }
    /**
     * 按姓名模糊查询学生数据并打印
     */
    @Test
    public void getByName(){
        List<Student> students=studentService.getByName("张");
        for (Student student : students) {
            logger.info(String.valueOf(student));
        }
    }
    @Test
    public void getAll() {
        List<Student> students = studentService.listStudent();
        for (Student student : students) {
            logger.info(String.valueOf( student));
        }
    }
}