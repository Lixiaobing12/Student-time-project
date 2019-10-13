package edu.ssm.service.impl;

import edu.ssm.mapper.MajorMapper;
import edu.ssm.model.Major;
import edu.ssm.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    public List<Major> getAllMajor() {
        return majorMapper.selectAllMajor();
    }

    public void insert(String name,String pastern){
        Assert.notNull(name);
        Assert.notNull(pastern);
        Assert.hasLength(name,"名字不能为空");
        Assert.notNull(pastern,"专业系部不能为空");
        majorMapper.insertMajor(name,pastern);
    }

    public void delMajorById(String id) {
        majorMapper.delById(id);
    }
}
