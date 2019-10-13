package edu.ssm.service.impl;

import edu.ssm.mapper.CourseMapper;
import edu.ssm.model.Course;
import edu.ssm.service.CourseService;
import edu.ssm.vo.ResultObject;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseMapper courseMapper;
    public List<Course> getAll() {
        return courseMapper.selectAllCourse();
    }

    @Transactional
    public ResultObject<String> add(String name, String intro, String[] tId) {
        Assert.notNull(name,"参数非法-001");
        Assert.notNull(intro,"参数非法-002");
        Assert.hasLength(name,"课程名不能为空-001");
        Assert.hasLength(intro,"课程介绍不能为空-002");
        Assert.notNull(tId,"参数非法-003");
        if(tId==null || tId.length==0) throw new RuntimeException("参数非法-004");
        Course stro = new Course();
        stro.setName(name);
        stro.setIntroduction(intro);
        courseMapper.insertCourse(stro);
        for(String i:tId){
            courseMapper.insertCT(i,stro.getId().toString());
        }
        ResultObject<String> result = new ResultObject<String>();
        result.setSuccess();
        return result;
    }

    public ResultObject<String> del(String cId){
        if(!StringUtils.isNumeric(cId)) throw new RuntimeException("参数非法");
        courseMapper.delCourse(Integer.parseInt(cId));
        ResultObject<String> result = new ResultObject<String>();
        result.setSuccess();
        return result;
    }
}
