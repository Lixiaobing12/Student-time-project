package edu.ssm.controller;

import edu.ssm.model.Direction;
import edu.ssm.model.Student;
import edu.ssm.service.StudentService;
import edu.ssm.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Blse
 * @date 2019/6/25
 * @description
 */

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private Direction direction;

    /**
     * 注册
     * @param student
     * @return
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(Student student, Model model) {
        boolean isRepeat = studentService.regist(student) > 0 ? true : false;
        if (isRepeat) {
            model.addAttribute("info", "你已经注册过了，请登录");
        } else {
            int result = studentService.regist(student);
        }
        return "admin/login";
    }

    /**
     * 登陆
     * @param student
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Student student, HttpSession session, Model model) {
        if (student == null) {
            model.addAttribute("info", 0);
            return "student/login";
        }
        Student result = studentService.login(student);
        session.setAttribute("student", result);
        session.removeAttribute("interInfo");
        if (result == null) {
            model.addAttribute("info", 0);
            return "student/login";
        } else {
            return "redirect:/student/toStudent";
        }
    }

    /**
     * 注销
     * @return
     */
    @RequestMapping(value = "remove")
    public String remove() {
        return "redirect:/student/toLogin";
    }

    @RequestMapping(value = "toUpdate")
    public String toUpdate(HttpSession session) {
        session.removeAttribute("updateInfo");
        return "student/update";
    }

    /**
     * 修改密码
     * @param password
     * @param newPassword
     * @param session
     * @return
     */
    @RequestMapping(value = "updatePassword", method = RequestMethod.POST)
    public String update(String password, String newPassword, String surPassword, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        //先判断两次密码输入是否正确，然后判断旧密码是否输入正确，最后判断新密码是否与旧密码一样，一样就不改
        if (!newPassword.equals(surPassword)) {
            session.setAttribute("updateInfo", "-1");
            return "student/update";
        } else if (!student.getPassword().equals(password)) {
            session.setAttribute("updateInfo", "0");
            return "student/update";
        } else {
            if (password != newPassword) {
                 student.setPassword(newPassword);
                 session.setAttribute("student", student);
                 studentService.update(student.getId(), newPassword);
            }
        }
        return "redirect:/student/toStudent";
    }


    @RequestMapping(value = "toLogin")
    public String toLogin() {
        return "student/login";
    }

    @RequestMapping(value = "toStudent")
    public String toStudent(Model model, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        List<Direction> directions = studentService.selectDirName(student.getMajor());
        model.addAttribute("directions", directions);
        return "student/student";
    }


    /**
     * 学生选方向
     * @param
     * @return
     */
    @RequestMapping(value = "/pick", method = RequestMethod.POST)
    public String pick(int dirId, HttpSession session) {
        Student student = (Student) session.getAttribute("student");
        if (!studentService.selectDir(dirId)) {
            session.setAttribute("pickInfo", "0");
        } else {
            if (dirId != student.getDirection()) {
                studentService.pickDir(dirId, student.getDirection(), student.getId());
            }
            session.setAttribute("pickInfo", "1");
        }
        return "redirect:/student/toStudent";
    }

    /**
     * 根据方向id查看详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable int id, Model model) {
        Direction direction = studentService.showDetail(id);
        model.addAttribute("direction", direction);
        return "student/detail";
    }


    @RequestMapping("importStudent")
    public String importStudent(MultipartFile file,Model model)  {
        if (file.getOriginalFilename().length() <= 0) {
            model.addAttribute("info", "0");
            return "admin/admin";
        }
        studentService.importStudents(file);
        model.addAttribute("info", "1");
        return "admin/admin";
    }

}
