package com.usoft.suntg.utils;

import org.springframework.util.StringUtils;

/**
 * Created by ConcaSun on 2019/4/16.
 */
public class VerifyParamsUtil {

    public static void notNull(Object object, String message) throws MyBatisTestRuntimeException {
        if (null == object) {
            throw new MyBatisTestRuntimeException(message);
        }
    }

    public static void hasText(String text, String message) throws MyBatisTestRuntimeException {
        if (StringUtils.isEmpty(text)) {
            throw new MyBatisTestRuntimeException(message);
        }
    }

    public static void isTrue(boolean expression, String message) throws MyBatisTestRuntimeException {
        if (!expression) {
            throw new MyBatisTestRuntimeException(message);
        }
    }
}
