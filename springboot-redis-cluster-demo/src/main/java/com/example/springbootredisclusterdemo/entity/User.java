package com.example.springbootredisclusterdemo.entity;

/**
 * @author sh on 2018/10/10
 * @version ideaIU-2017.2.5.win
 */
public class User {
    private String uuid;
    private String name;
    private String password;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
