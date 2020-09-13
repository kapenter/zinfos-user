package com.api.dingdang.user.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@Slf4j
public class SignUtil {

    private static final String SIGN_FIELD = "sign";

    /**
     * 验证签名是否有效
     * @param data 待验证数据
     * @param appSecret 秘钥
     * @return 是否有效
     * @throws Exception
     */
    public static boolean isSignatureValid(Map<String, String> data, String appSecret) throws Exception {
        if (!data.containsKey(SIGN_FIELD) ) {
            return false;
        }
        String sign = data.get(SIGN_FIELD);
        return generateSignature(data, appSecret).equals(sign);
    }
    /**
     * 数据签名
     * @param data 待签名数据
     * @param appSecret 签名秘钥
     * @return 签名
     * @throws Exception
     */
    public static String generateSignature(Map<String,String> data, String appSecret) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        for (String key : keyArray) {
            if (key.equals(SIGN_FIELD)) {
                continue;
            }
            if (data.get(key).trim().length() > 0) //参数值为空，则不参与签名
                sb.append(key).append("=").append(data.get(key).trim()).append("&");
        }
        sb.append("appSecret=").append(appSecret);
        log.info("签名串：{}",sb.toString());
        return MD5(sb.toString()).toUpperCase();
    }

    /**
     * 生成MD5签名
     * @param data
     * @return signature
     * @throws Exception
     */
    private static String MD5(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

//    public static void main(String[] args) throws Exception {
//        String appSecret = "123456123456";
//         // 接口参数数据全量加密
//        // data = Https 数据
//        Map<String, String> data = new HashMap<>();
//        data.put("appId","1111");
//        data.put("userId","1011");
//        String sign = generateSignature(data, appSecret);
//        System.out.println(sign);
//        data.put("sign", sign);


//        // 全量数据接口签名验证
//        boolean result = isSignatureValid(data, appSecret);

//        // 局部数据加密
//        Map<String, String> data2 = new HashMap<>();
//        // 根据api接口约定，提取需要加密数据字段
//        sign = generateSignature(data2, appSecret);
//        //局部数据接口签名验证
//        Map<String, String> data3 = new HashMap<>();
//        // 根据api接口约定，从返回数据中提取需要验证的数据字段
//        boolean result2 = isSignatureValid(data3, appSecret);
//    }

}
