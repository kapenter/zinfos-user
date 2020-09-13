package com.api.dingdang.user.utils;

import java.util.UUID;

public class ZuStringUtil {

    public static String getAccessToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
