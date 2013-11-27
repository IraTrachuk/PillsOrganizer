package com.example.pillsorganizer2.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Trachuk
 * Date: 27.11.13
 * Time: 19:28
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String name;

    public User(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
