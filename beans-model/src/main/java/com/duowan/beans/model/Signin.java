package com.duowan.beans.model;

import java.util.Date;


public class Signin {

    //用户ID
    private double yyuid;
    //最后操作时间
    private Date postTime;
    //连续登录天数
    private int days;

    public void setYyuid(double yyuid) {
        this.yyuid = yyuid;
    }

    public double getYyuid() {
        return yyuid;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

}
