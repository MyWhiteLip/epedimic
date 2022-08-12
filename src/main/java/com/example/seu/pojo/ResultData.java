package com.example.seu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

public class ResultData{
    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }

    private String code;
    private JSONObject data;
    private Object res;

    public ResultData(String code, JSONObject data,Object res) {
        this.code = code;
        this.data = data;
        this.res = res;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
