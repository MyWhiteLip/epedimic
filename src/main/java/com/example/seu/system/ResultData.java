package com.example.seu.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultData {
    private int code;
    private Object msg;

    static public ResultData success(Object object){
        ResultData resultData = new ResultData();
        resultData.setCode(1);
        resultData.setMsg(object);
        return resultData;
    }
    static public ResultData error(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(0);
        resultData.setMsg(msg);
        return resultData;
    }
}
