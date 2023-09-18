package com.bhd.online.models.model;

import lombok.Getter;
import lombok.Setter;

/**
 * description: LoginException
 * author: DaTao
 * email: jixu65@sina.com
 * date 2023-09-12 11:15
 * version: 1.0
 */
@Getter
@Setter
public class LoginException extends RuntimeException{

    private String msg = "登录出错了...";

}
