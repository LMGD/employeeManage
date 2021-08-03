package com.example.springboot.util;

/**
 * @author by LMGD
 * @date 2021-07-15 16:38
 * @description
 */
public class StrUtils {

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(Object str) {
        return str != null && !"".equals(str);
    }
}
