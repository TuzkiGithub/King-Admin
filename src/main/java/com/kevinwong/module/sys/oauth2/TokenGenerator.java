package com.kevinwong.module.sys.oauth2;


import com.kevinwong.core.utils.KingException;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 生成token
 *
 * @author Eastascend <EastascendWang@gmail.com>
 */
public class TokenGenerator {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new KingException("生成Token失败！", e);
        }
    }

    //test
    public static void main(String[] args){
        System.out.println("Token1:" + generateValue());
        System.out.println("Token2:" + generateValue("kevin"));
        System.out.println("Token3:" + generateValue("你好！"));
    }
}
