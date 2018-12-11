package com.example.springbootredissingledemo.entity;

import java.util.Date;

/**
 * @author sh 2018/12/10 11:21
 * @version ideaIU-2018.2.5.win
 */
public class Gread {
    private String uuid;
    private String name;
    private Date creatDate;

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

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}
