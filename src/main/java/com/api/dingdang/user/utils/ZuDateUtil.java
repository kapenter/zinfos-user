package com.api.dingdang.user.utils;

public class ZuDateUtil {
    // checkTime方法
    public static boolean checkTime(Long time, Integer variable){
        Long currentTimeMillis = System.currentTimeMillis()/1000;
        Long addTime = currentTimeMillis + variable;
        Long subTime = currentTimeMillis - variable;
        return addTime > time && time > subTime;
    }
}
