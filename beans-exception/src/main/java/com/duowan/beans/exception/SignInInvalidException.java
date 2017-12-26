package com.duowan.beans.exception;

import com.duowan.leopard.core.exception.InvalidException;


public class SignInInvalidException extends InvalidException {

    private static final long serialVersionUID = 1L;

    public SignInInvalidException(Integer signinId) {
        // 中括号里面的值，可以输出到日志方便查看，在页面显示错误信息时会被Leopard自动过滤。
        super("非法登录ID[" + signinId + "].");
    }

}
