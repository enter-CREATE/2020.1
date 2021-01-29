package com.cx.entity;

/**
 * 实体类
 * 与表对应
 */
public class Hero {
    private  int id;
    private  String ukName;
    private  String nickName;
    private  String tinyImg;
    private  int attackPower;
    private  int handHard;

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
