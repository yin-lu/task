package com.yl.controller;


import com.yl.entity.Student;
import com.yl.service.StudentService;
import com.yl.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.logging.Logger;

//告诉Spring mvc这是一个控制器
@Controller
@RequestMapping("")
public class StudentController {
    static Logger logger = Logger.getLogger(String.valueOf(StudentController.class));
    //注入service层
    @Autowired
    StudentService studentService;

    //全表查询
    @RequestMapping(value = "/u/students")
    public ModelAndView listStudent(Page page) {
        logger.info("开始listStudent方法");
        ModelAndView mav = new ModelAndView();
        List<Student> students = studentService.list(page);
        int total = studentService.total();
        page.caculateLast(total);
        //放入转发参数
        mav.addObject("students", students);
        //放入jsp路径
        mav.setViewName("listTiles");
        return mav;
    }

    //跳转到添加页面
    @RequestMapping(value = "/u/student", method = RequestMethod.GET)
    public String addStudent() {
        logger.info("进入添加方法");
        return "addTiles";
    }

    //增加学员后跳转到学生列表
    @RequestMapping(value = "/u/student", method = RequestMethod.POST)
    public String addStudent(@Validated Student student, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> ls = result.getAllErrors();
            for (ObjectError error : ls) {
                logger.info(error.getDefaultMessage());
            }
        }
        studentService.add(student);
        logger.info("student.getName():" + student.getName());
        return "redirect:/u/students";
    }


    //删除学员数据
    @RequestMapping(value = "/u/students/{id}", method = RequestMethod.DELETE)
    public ModelAndView deleteStudent(@PathVariable int id) {

        logger.info("进入删除方法，删除数据id为" + id);

        int a = studentService.delete(id);
        logger.info("删除结果 = " + a);

        ModelAndView mav = new ModelAndView("redirect:/u/students");
        return mav;
    }

    //根据id查询学员数据
    @RequestMapping(value = "/u/students/{id}", method = RequestMethod.GET)
    public ModelAndView editStudent(@PathVariable int id) {
        logger.info("开始编辑");
        Student student = studentService.getById(id);
        ModelAndView mav = new ModelAndView("editTiles");
        mav.addObject("student", student);
        logger.info(String.valueOf(student));
        return mav;
    }

    //更新学员数据
    @RequestMapping(value = "/u/students/{id}", method = RequestMethod.PUT)
    public ModelAndView updateStudent(Student student) {
        logger.info("开始更新");
        studentService.update(student);
        ModelAndView mav = new ModelAndView("redirect:/u/students");
        return mav;
    }

    //根据姓名查询数据
    @RequestMapping(value = "/u/student/name/", method = RequestMethod.GET)
    public ModelAndView byName(@RequestParam String name) {
        logger.info("调用模糊查询");
        List<Student> students = studentService.getByName(name);
        ModelAndView mav = new ModelAndView();
        mav.addObject("students", students);
        mav.setViewName("selectTiles");
        return mav;
    }

    @RequestMapping(value = "/home")
    public String home(Model model) {
//        System.out.println("开始展示学员");
        List<Student> list = studentService.salaryList();
        List<Student> graStudents = list.subList(0, 4);
//        for (Student s : graStudents) {
//            logger.info(String.valueOf(s));
//        }
        int total = studentService.total();
        int graTotal = studentService.graTotal();
        model.addAttribute("graStudents", graStudents);
        model.addAttribute("total", total);
        model.addAttribute("graTotal", graTotal);
        return "homeTiles";//返回tiles定义中的name

    }

    @RequestMapping(value = "/")
    public String jump() {

        return "redirect:/home";
    }

    @RequestMapping(value = "/recommend")
    public String recommend() {

        return "recommendTiles";//返回tiles定义中的name

    }

}
