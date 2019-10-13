package edu.ssm.controller;

import edu.ssm.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Blse
 * @date 2019/6/25
 * @description
 */
@Controller
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        System.out.println("_---------");
        return String.valueOf(testMapper.select());
    }
}
