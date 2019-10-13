package edu.ssm.service;

import edu.ssm.model.Course;
import edu.ssm.vo.ResultObject;

import java.util.List;

public interface CourseService {
    public List<Course> getAll();
    public ResultObject<String> add(String name, String intro, String[] tId);
    public ResultObject<String> del(String cId);
}
