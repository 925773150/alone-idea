package com.gjsm.springboot_shiro.Utils;

import java.util.Random;

/**
 * Date on 2020/09/26  下午 03:52
 */
public class SaltUtils {

    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+".toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            stringBuilder.append(aChar);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String salt = getSalt(5);
        System.out.println(salt);
    }
}
