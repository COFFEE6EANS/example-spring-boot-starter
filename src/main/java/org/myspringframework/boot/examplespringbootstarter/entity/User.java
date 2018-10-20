package org.myspringframework.boot.examplespringbootstarter.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author guojianfeng.
 * @Date Created in  2018/10/19
 * @Description：
 */
public class User {
    private String username;
    private Integer age;
    @DateTimeFormat
    private Date birthday;
    private List<String> feature;
    private Boolean isBoss;
    private Phone phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getFeature() {
        return feature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }

    public Boolean getBoss() {
        return isBoss;
    }

    public void setBoss(Boolean boss) {
        isBoss = boss;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
