package com.qianlou.common.utils;

import java.util.Random;

public class SmsUtil {

    public static String generateCode(Integer length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(10);
            builder.append(rand);
        }
        return builder.toString();
    }
}
