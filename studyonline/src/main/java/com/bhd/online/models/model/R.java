package com.bhd.online.models.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * description: R
 * author: DaTao
 * email: jixu65@sina.com
 * date 2023-09-12 10:53
 * version: 1.0
 */
@Setter
@Getter
public class R {
    //状态码
    private Integer code;
    //状态
    private Boolean success;
    //消息
    private String message;
    //数据
    private Object data;

    //把构造方法私有
    private R() {}

    //成功静态方法
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("fail");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(Object value){
        this.data = value;
        return this;
    }

    public R data(String key, Object value){
        Map<String,Object> map = new HashMap<>();
        map.put(key,value);
        this.data = map;
        return this;
    }

}
