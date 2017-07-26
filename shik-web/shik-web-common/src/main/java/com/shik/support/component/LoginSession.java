package com.shik.support.component;


import com.shik.dao.model.User;

/**
 * @author gengshikun
 * @date 2016/11/25
 */
public class LoginSession {

    private static ThreadLocal<User> local = new ThreadLocal<User>();

    public static void setUser(User user) {
        local.set(user);
    }

    public static User getUser() {
        return local.get();
    }
}
