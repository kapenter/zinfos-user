package com.api.dingdang.user.utils;

import java.security.MessageDigest;

public class MD5Util {
    /**
     * MD5加密
     *
     * @param str         加密字符串
     * @param is32Bit     是否32位
     * @param isUpperCase 是否大写
     * @return
     */
    public static String getMD5(String str, boolean is32Bit, boolean isUpperCase){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();

            int i;
            StringBuilder buf = new StringBuilder("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0){
                    i += 256;
                }
                if (i < 16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            if(is32Bit){
                if(isUpperCase){
                    return buf.toString().toUpperCase();//32位大写加密
                }else{
                    return buf.toString();//32位小写加密
                }
            }else{
                if(isUpperCase){
                    return buf.toString().substring(8, 24).toUpperCase();//16位大写加密
                }else{
                    return buf.toString().substring(8, 24);//16位小写加密
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * MD5加密-32位小写加密(默认)
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        return getMD5(str, true, false);
    }

    /**
     * MD5加密-32位加密，自定义大小写
     *
     * @param str
     * @return
     */
    public static String getMD5(String str, boolean isUpperCase) {
        return getMD5(str, true, isUpperCase);
    }

    /**
     * 本地测试方法
     *
     * @param args
     */
    public static void main(String args[]){
        System.out.println(MD5Util.getMD5(null));
    }

}