package com.cx.entity;

public class Film {
    private int id;
    private String ukName;//电影名
    private String nickName;//导演
    private String tinyImg;//图片地址
    private int attackPower;//人数
    private int handHard;//评分

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUkName() {
        return ukName;
    }

    public void setUkName(String ukName) {
        this.ukName = ukName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTinyImg() {
        return tinyImg;
    }

    public void setTinyImg(String tinyImg) {
        this.tinyImg = tinyImg;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHandHard() {
        return handHard;
    }

    public void setHandHard(int handHard) {
        this.handHard = handHard;
    }
}
