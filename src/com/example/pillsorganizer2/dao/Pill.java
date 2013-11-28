package com.example.pillsorganizer2.dao;

/**
 * Created with IntelliJ IDEA.
 * User: Trachuk
 * Date: 27.11.13
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */
public class Pill {
    private String PillName;
    private int Dose;

    public Pill(String pillName, int dose) {
        PillName = pillName;
        Dose = dose;
    }

    public String getPillName() {
        return PillName;
    }

    public int getDose() {
        return Dose;
    }

    public String toString(){
        return PillName+" ("+Dose+")";
    }
}
