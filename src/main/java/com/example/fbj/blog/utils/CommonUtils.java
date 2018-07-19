package com.example.fbj.blog.utils;

import com.example.fbj.blog.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @autor Fubijie
 * @Description: This is Description
 * @date Created in 2018/07/19
 **/
public class CommonUtils {
    public static User encryptPassword(String password) {
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        User user = new User();
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                "md5",//加密算法
                password,//密码
                user.getSalt(),
                1024   //散列的次数
        ).toHex();
        user.setPassword(newPassword);
        return user;
    }
}
