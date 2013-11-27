package com.example.pillsorganizer2.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Trachuk
 * Date: 27.11.13
 * Time: 19:34
 * To change this template use File | Settings | File Templates.
 */
public class Schedule {
    private String name;
    private int start;
    private int end;

    public Schedule(String name, int end, int start) {
        this.name = name;
        this.end = end;
        this.start = start;
    }

    public String getName() {
        return name;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }
}
