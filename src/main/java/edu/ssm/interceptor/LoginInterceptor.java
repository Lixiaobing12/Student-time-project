package edu.ssm.interceptor;

import edu.ssm.model.Student;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by i on 2017/5/15.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> excludeUrls;

    private String adminPrefix;

    public List<String> getExcludeUrls() {
        return excludeUrls;
    }

    public String getAdminPrefix() {
        return adminPrefix;
    }

    public void setAdminPrefix(String adminPrefix) {
        this.adminPrefix = adminPrefix;
    }

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String requestUrl = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUrl.substring(contextPath.length());
        HttpSession session = request.getSession();
        if(excludeUrls.contains(url) || url.equals(adminPrefix)){
            System.out.println(url);
            System.out.println("通过了拦截器");
            return true;
        }else{
            Student student = (Student) request.getSession().getAttribute("student");
            System.out.println(url);
            System.out.println("student-->" + student);
            if (student != null && student.getId() != null) {
                return true;
            } else {
                System.out.println("未通过拦截器");
                session.setAttribute("interInfo", 0);
                request.getRequestDispatcher("/student/toLogin").forward(request,response);
                return false;
            }
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandelr-->");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion-->");
    }
}
