package edu.ssm.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import edu.ssm.mapper.TeacherMapper;
import edu.ssm.model.Teacher;
import edu.ssm.service.TeacherService;
import edu.ssm.vo.ResultObject;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    public ResultObject<Teacher> getAll() {
        List<Teacher> teacherList = teacherMapper.selectAllTeacher();
        ResultObject<Teacher> result = new ResultObject<Teacher>();
        if(teacherList==null || teacherList.size()==0){
            result.setData(null);
            result.setMsg("无相关信息");
            result.setCode("000");
        }else{
            result.setSuccess();
            result.setData(teacherList);
        }
        return result;
    }

    public ResultObject<Teacher> del(String tId) {
        if(!StringUtils.isNumeric(tId)) throw new RuntimeException("非法参数");
        teacherMapper.delTeacher(Integer.parseInt(tId));
        ResultObject<Teacher> resultObject = new ResultObject<Teacher>();
        resultObject.setSuccess();
        return resultObject;
    }

    public ResultObject<String> add(String name, String intro) {
        Assert.hasLength(name,"名字不能为空");
        Assert.hasLength(intro,"介绍不能为空");
        ResultObject<String> result = new ResultObject<String>();
        teacherMapper.insertTeacher(name,intro);
        result.setSuccess();
        return result;
    }

    public void delTeacherById(String id) {
        Assert.notNull(id,"参数非法");
        teacherMapper.delTeacher(Integer.parseInt(id));
    }
}
