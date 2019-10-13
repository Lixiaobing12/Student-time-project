package edu.ssm.controller;

import edu.ssm.model.Course;
import edu.ssm.model.Direction;
import edu.ssm.model.Major;
import edu.ssm.model.Teacher;
import edu.ssm.service.CourseService;
import edu.ssm.service.DirectionService;
import edu.ssm.service.MajorService;
import edu.ssm.service.TeacherService;
import edu.ssm.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("admin")
public class ManagerController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DirectionService directionService;
    @Autowired
    private MajorService majorService;


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "admin/adminLogin";
    }

    @RequestMapping("login")
    public String login(String name, String password, HttpSession session, Model model) {
        if (!"admin".equals(name) && !"123456".equals(password)){
            model.addAttribute("info", "0");
            return "redirect: /admin/toLogin";
        }
        session.setAttribute("admin", 1);
        return "redirect: /admin/admin";
    }


    @RequestMapping("/admin")
    public String admin(HttpServletRequest request){
        return "admin/admin";

    }
    @RequestMapping("/course")
    public String coursePage(HttpServletRequest request){
        request.getSession().setAttribute("id","1");
        List<Course> courseList = courseService.getAll();
        ResultObject<Teacher> teacherResultObject = teacherService.getAll();
        ResultObject<Course> result = new ResultObject<Course>();
        if(courseList.size()==0){
            result.setCode("000");
            result.setMsg("无相关信息");
            result.setData(null);
        }else{
            result.setCode("200");
            result.setMsg("获取信息成功");
            result.setData(courseList);
        }
        request.setAttribute("result",result);
        request.setAttribute("teacher",teacherResultObject);
        return "admin/course";
    }

    @RequestMapping("/course/add")
    public String courseAdd(HttpServletRequest request){
        ResultObject<String> result = courseService.add(request.getParameter("name"),request.getParameter("intro"),request.getParameterValues("tId"));
        return "redirect:/admin/admin";
    }

    @RequestMapping("/course/del")
    public String courseDel(HttpServletRequest request){
        ResultObject<String> result = courseService.del(request.getParameter("cId"));
        return "redirect:/admin/course/delPage";
    }
    @RequestMapping("/course/delPage")
    public String cdelPage(HttpServletRequest request){
        List<Course> result = courseService.getAll();
        request.setAttribute("course",result);
        return "admin/delectCourse";
    }

    @RequestMapping("/dir/delPage")
    public String ddelPage(HttpServletRequest request){
        ResultObject<Direction> result = directionService.getAll();
        request.setAttribute("result",result.getData());
        return "admin/delectDirection";
    }

    @RequestMapping("/dir")
    public String dirPage(HttpServletRequest request){
        List<Course> courseList = courseService.getAll();
        List<Major> majors = majorService.getAllMajor();
        request.setAttribute("course",courseList);
        request.setAttribute("major",majors);
        return "admin/direction";
    }

    @RequestMapping("/dir/add")
    public String dirAdd(HttpServletRequest request){
        ResultObject<String> result = directionService.insert(request.getParameter("name"),
                request.getParameter("intro"),request.getParameter("target"),request.getParameterValues("cid"),
                request.getParameter("start"),request.getParameter("end"),request.getParameter("majorId"),
                request.getParameter("number")
        );
        return "redirect:/admin/admin";
    }

    @RequestMapping("/dir/update")
    public String dirUpdate(HttpServletRequest request){
        Direction direction = directionService.selectById(request.getParameter("id"));
        List<Course> courseList = courseService.getAll();
        List<Integer> coursesId = directionService.getConnectionCourseId(request.getParameter("id"));
        List<Major> majors = majorService.getAllMajor();
        request.setAttribute("id",request.getParameter("id"));
        request.setAttribute("course",courseList);
        request.setAttribute("courseList",coursesId);
        request.setAttribute("major",majors);
        request.setAttribute("dir",direction);
        request.setAttribute("start",new SimpleDateFormat("yyyy-MM-dd").format(direction.getDirLimitStart()));
        request.setAttribute("end",new SimpleDateFormat("yyyy-MM-dd").format(direction.getDirLimitEnd()));
//        request.
        return "admin/directionUpdate";
    }

    @RequestMapping("/dir/doUpdate")
    public String doUpdate(HttpServletRequest request){
        ResultObject<String> result = directionService.update(request.getParameter("id"),request.getParameter("name"),
                request.getParameter("intro"),request.getParameter("target"),request.getParameterValues("cid"),
                request.getParameter("start"),request.getParameter("end"),request.getParameter("majorId"),
                request.getParameter("number")
        );
        return "redirect:/admin/admin";
    }

    @RequestMapping("/dir/del")
    public String delDir(HttpServletRequest request){
        directionService.deleteDir(request.getParameter("id"));
        return "redirect:/admin/dir/delPage";
    }


    @RequestMapping("/teacher")
    public String teacherPage(HttpServletRequest request){
        return "admin/teacher";
    }

    @RequestMapping("/teacher/add")
    public String teacherAdd(HttpServletRequest request){
        teacherService.add(request.getParameter("name"),request.getParameter("intro"));
        return "redirect:/admin/admin";
    }
    @RequestMapping("/teacher/del")
    public String teacherDel(HttpServletRequest request){
        teacherService.delTeacherById(request.getParameter("id"));
        return "redirect:/admin/teacher/delPage";
    }

    @RequestMapping("/teacher/delPage")
    public String tdelPage(HttpServletRequest request){
        ResultObject<Teacher> result = teacherService.getAll();
        request.setAttribute("result",result.getData());
        return "admin/delectTeacher";
    }



    @RequestMapping("/major")
    public String major(HttpServletRequest request){

        return "admin/major";
    }

    @RequestMapping("/major/add")
    public String majorAdd(HttpServletRequest request){
        majorService.insert(request.getParameter("name"),request.getParameter("pastern"));
        return "redirect:/admin/admin";
    }

    @RequestMapping("/major/del")
    public String majorDel(HttpServletRequest request){
        majorService.delMajorById(request.getParameter("id"));
        return "redirect:/admin/major/delPage";
    }

    @RequestMapping("/major/delPage")
    public String mdelPage(HttpServletRequest request){
        List<Major> result = majorService.getAllMajor();
        request.setAttribute("result",result);
        return "admin/delectMajor";
    }

    @RequestMapping("/major/see")
    public String see(HttpServletRequest request){
        return "updateDirection";
    }
}
