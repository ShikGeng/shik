package com.shik.support.util;

import java.util.UUID;

/**
 * @author gengshikun
 * @date 2016/11/30
 */
public class UUIDUtil {

    /**
     * 获得32位UUID
     */
    public static String random32UUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String temp = str.substring(0, 8) + str.substring(6, 10)
                + str.substring(11, 15) + str.substring(16, 20)
                + str.substring(24);
        return temp.toUpperCase();
    }

    /**
     * 获得16位UUID
     */
    public static String random16UUID() {
        String key = String.valueOf(System.currentTimeMillis())
                + UUID.randomUUID().toString();
        String uuid = Md5Util.MD5(key);
        return uuid.substring(5, 21).toUpperCase(); // 16位的加密
    }
}
