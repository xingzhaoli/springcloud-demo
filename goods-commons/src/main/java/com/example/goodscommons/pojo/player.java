package com.example.goodscommons.pojo;

public class player {
    private Integer playerId;
    private String name;
    private String sex;
    private Integer age;
    private String address;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public player(Integer playerId, String name, String sex, Integer age, String address) {
        this.playerId = playerId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
    }

    public player() {
    }
}
