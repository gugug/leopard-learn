package com.duowan.beans.model;

import java.util.Date;


public class Gain {

    //收获ID
    private double gainId;
    //游戏ID
    private int gameId;
    //游戏名称
    private String gameName;
    //游戏区服ID
    private int serverId;
    //是否双倍收获：true|false
    private int doubleGain;
    //入口ID
    private int entryId;
    //状态：0|1，未收获|收获
    private int status;
    //收获时间
    private Date date;
    //最后操作时间
    private Date postTime;

    public void setGainId(double gainId) {
        this.gainId = gainId;
    }

    public double getGainId() {
        return gainId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getServerId() {
        return serverId;
    }

    public void setDoubleGain(int doubleGain) {
        this.doubleGain = doubleGain;
    }

    public int getDoubleGain() {
        return doubleGain;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Date getPostTime() {
        return postTime;
    }

}
