package com.cx.jdbc;

public class Hero {
    private String uk_name;
    private String nickname;
    private String ting_img;
    private int hand_hard;

    public String getUk_name() {
        return uk_name;
    }

    public void setUk_name(String uk_name) {
        this.uk_name = uk_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTing_img() {
        return ting_img;
    }

    public void setTing_img(String ting_img) {
        this.ting_img = ting_img;
    }

    public int getHand_hard() {
        return hand_hard;
    }

    public void setHand_hard(int hand_hard) {
        this.hand_hard = hand_hard;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "uk_name='" + uk_name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", ting_img='" + ting_img + '\'' +
                ", hand_hard=" + hand_hard +
                '}';
    }
}
