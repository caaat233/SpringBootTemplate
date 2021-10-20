package com.springboottemplate.util;

import com.springboottemplate.pojo.User;

/**
 * @author 唐涛
 * @description: ThreadLocalUtil
 * @date 2021/10/20 14:55
 */
public class UserThreadLocalUtil {

    private static final ThreadLocal<User> userLocal = new ThreadLocal();

    public UserThreadLocalUtil() {
    }

    public static User getUserInfo() {
        return (User) userLocal.get();
    }

    public static void setUserInfo(User user) {
        userLocal.set(user);
    }

    public static void rmUserInfo() {
        userLocal.remove();
    }
}
