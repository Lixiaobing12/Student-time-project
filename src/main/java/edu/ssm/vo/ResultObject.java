package edu.ssm.vo;

import lombok.Data;

import java.util.List;

@Data
public class ResultObject<T> {
    private String msg;
    private List<T> data;
    private String code;

    public void setSuccess(){
        msg = "success";
        code = "200";
        data = null;
    }

    public void setSuccessF() {
        code = "500";
    }

}
