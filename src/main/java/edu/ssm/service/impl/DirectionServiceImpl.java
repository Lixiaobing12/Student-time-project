package edu.ssm.service.impl;

import edu.ssm.mapper.DirectionMapper;
import edu.ssm.model.Direction;
import edu.ssm.service.DirectionService;
import edu.ssm.vo.ResultObject;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class DirectionServiceImpl implements DirectionService {
    @Autowired
    private DirectionMapper directionMapper;

    public ResultObject<Direction> getAll() {
        List<Direction> directionList = directionMapper.selectAllDirection();
        ResultObject<Direction> result = new ResultObject<Direction>();
        if(directionList==null || directionList.size()==0){
            result.setData(null);
            result.setMsg("无相关信息");
            result.setCode("000");
        }else{
            result.setSuccess();
            result.setData(directionList);
        }
        return result;
    }


    @Transactional
    public ResultObject<String> insert(String name, String intro, String target, String[] cId,String startDate,String endDate,String majorId,String number){
        Assert.notNull(name,"参数非法-001");
        Assert.notNull(intro,"参数非法-002");
        Assert.notNull(target,"参数非法-003");
        Assert.notNull(cId,"参数非法-004");
        Assert.notNull(startDate,"参数非法-005");
        Assert.notNull(endDate,"参数非法-006");
        Assert.hasLength(name,"名字不能为空-001");
        Assert.hasLength(intro,"介绍不能为空-002");
        Assert.hasLength(target,"培养目标不能为空-003");
        Assert.notEmpty(cId,"课程不能为空-004");
        Assert.hasLength(startDate,"日期不能为空-005");
        Assert.hasLength(endDate,"日期不能为空-006");
        if(!StringUtils.isNumeric(majorId) || !StringUtils.isNumeric(number)) throw new RuntimeException("参数非法-007");


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = sdf.parse(startDate);

            end = sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Direction direction = new Direction();
        direction.setName(name);
        direction.setIntroduction(intro);
        direction.setTarget(target);
        direction.setDirLimitStart(start);
        direction.setDirLimitEnd(end);
        direction.setMajorId(majorId);
        direction.setNumber(Integer.parseInt(number));

        directionMapper.insertDirection(direction);
        for(String i:cId){
            directionMapper.insertDirCCourse(direction.getId().toString(),i);
        }
        ResultObject<String> result = new ResultObject<String>();
        result.setSuccess();
        return result;
    }

    public ResultObject<String> del(String dId) {
        if(!StringUtils.isNumeric(dId)) throw new RuntimeException("非法参数");
        directionMapper.delDirection(Integer.parseInt(dId));
        ResultObject<String> result = new ResultObject<String>();
        result.setSuccess();
        return result;
    }

    public Direction selectById(String id) {
        if(!StringUtils.isNumeric(id)) throw new RuntimeException("参数有误");


        return directionMapper.selectById(id);
    }

    public List<Integer> getConnectionCourseId(String id){
        if(!StringUtils.isNumeric(id)) throw new RuntimeException("参数有误");
        return directionMapper.getConnectionId(id);
    }


    @Transactional
    public ResultObject<String> update(String id,String name, String intro, String target, String[] cId, String startDate, String endDate, String majorId,String number) {

        Assert.notNull(name,"参数非法-001");
        Assert.notNull(intro,"参数非法-002");
        Assert.notNull(target,"参数非法-003");
        Assert.notNull(cId,"参数非法-004");
        Assert.notNull(startDate,"参数非法-005");
        Assert.notNull(endDate,"参数非法-006");
        if(!StringUtils.isNumeric(majorId) ||!StringUtils.isNumeric(id)|| !StringUtils.isNumeric(number)) throw new RuntimeException("参数非法-007");


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = sdf.parse(startDate);

            end = sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Direction direction = new Direction();
        direction.setId(Integer.parseInt(id));
        direction.setName(name);
        direction.setIntroduction(intro);
        direction.setTarget(target);
        direction.setDirLimitStart(start);
        direction.setDirLimitEnd(end);
        direction.setMajorId(majorId);
        direction.setNumber(Integer.parseInt(number));
        System.out.println("majorId+="+majorId);
        directionMapper.update(direction);
        //删除后插入
        directionMapper.delConnectionById(id);
        for(String i:cId){
            directionMapper.insertDirCCourse(direction.getId().toString(),i);
        }
        ResultObject<String> result = new ResultObject<String>();
        result.setSuccess();
        return result;
    }

    @Transactional
    public void deleteDir(String id) {
        directionMapper.delDirection(Integer.parseInt(id));
        directionMapper.delConnectionById(id);
        System.out.println(id);
    }
}
