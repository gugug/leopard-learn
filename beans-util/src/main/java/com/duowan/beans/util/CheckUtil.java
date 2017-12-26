package com.duowan.beans.util;

import com.duowan.beans.exception.SignInInvalidException;
import com.duowan.leopard.util.valid.LeopardCheckUtil;

/**
 * 参数合法性检查，不合法则抛异常.
 *
 * @author 阿海
 */
public class CheckUtil extends LeopardCheckUtil {

    public static void isValidGroupId(int signinId) {
        if (!ValidUtil.isValidGroupId(signinId)) {
            throw new SignInInvalidException(signinId);
        }
    }
}
