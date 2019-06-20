package com.yl;

import com.yl.utils.MD5Util;

public class MD5Test {


    // 测试主函数
    public static void main(String args[]) {
        // 原文
//        String plaintext = "123456";
//        //  plaintext = "123456";
//        System.out.println("原始：" + plaintext);
//        System.out.println("普通MD5后：" + MD5Util.MD5(plaintext));
//
//        // 获取加盐后的MD5值
//        String ciphertext=MD5Util.generate(plaintext);
//        System.out.println("加盐后MD5：" + ciphertext);
        System.out.println("是否是同一字符串:" + MD5Util.verify("333", "17747366615e51c610102418646392e5276e56535357396b"));
        /**
         * 其中某次DingSai字符串的MD5值
         */
//        String[] tempSalt = { "e65c17a24f79f10708606041f53b37c9c975b3ae53b9e159", "66db82d9da2e35c95416471a147d12e46925d38e1185c043", "61a718e4c15d914504a41d95230087a51816632183732b5a" };
//
//        for (String temp : tempSalt) {
//            System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, temp));
//        }
    }
}
