package com.example.springbootredissingledemo.entity;

import java.util.Date;

/**
 * @author sh 2018/12/10 11:21
 * @version ideaIU-2018.2.5.win
 */
public class User {
    private String uuid;
    private String userName;
    private Gread gread;
    private Date inputDate;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Gread getGread() {
        return gread;
    }

    public void setGread(Gread gread) {
        this.gread = gread;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }
}
