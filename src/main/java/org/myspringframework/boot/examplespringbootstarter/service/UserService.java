package org.myspringframework.boot.examplespringbootstarter.service;

import org.myspringframework.boot.examplespringbootstarter.entity.User;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/10/19
 * @Description：
 */
public class UserService {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
