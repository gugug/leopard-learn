package com.duowan.beans.model;

import java.util.Date;


public class Seeded {

    //用户id
    private double yyuid;
    //游戏ID
    private String gameId;
    //游戏名称
    private String gameName;
    //游戏区服ID
    private String serverId;
    //最后操作时间
    private Date postTime;

    public void setYyuid(double yyuid) {
        this.yyuid = yyuid;
    }

    public double getYyuid() {
        return yyuid;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public Date getPostTime() {
        return postTime;
    }

}
