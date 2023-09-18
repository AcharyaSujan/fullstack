package com.bhd.online.interceptor;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.bhd.online.models.model.LoginException;
import com.bhd.online.models.model.R;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description: GlobalExceptionHandler
 * author: DaTao
 * email: jixu65@sina.com
 * date 2023-09-12 11:09
 * version: 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //指定出现什么异常时执行此方法
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("出错了,进入全局异常...");
    }


    //指定出现什么异常时执行此方法
    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public R error(LoginException e){
        log.error(e.getMsg());
        e.printStackTrace();
        return R.error().message(e.getMsg());
    }

}
