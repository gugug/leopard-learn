package com.duowan.beans.model;

import java.util.Date;


public class Entry {

    //入口ID
    private int entryId;
    //是否双倍收获：true|false
    private int doubleGain;
    //白碗豆数量
    private int beans;
    //霸数量
    private int bas;
    //坑数量
    private int kengs;
    //萌数量
    private int mengs;

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setDoubleGain(int doubleGain) {
        this.doubleGain = doubleGain;
    }

    public int getDoubleGain() {
        return doubleGain;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getBeans() {
        return beans;
    }

    public void setBas(int bas) {
        this.bas = bas;
    }

    public int getBas() {
        return bas;
    }

    public void setKengs(int kengs) {
        this.kengs = kengs;
    }

    public int getKengs() {
        return kengs;
    }

    public void setMengs(int mengs) {
        this.mengs = mengs;
    }

    public int getMengs() {
        return mengs;
    }

}
