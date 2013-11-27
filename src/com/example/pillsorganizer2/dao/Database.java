package com.example.pillsorganizer2.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trachuk
 * Date: 27.11.13
 * Time: 19:39
 * To change this template use File | Settings | File Templates.
 */
public class Database {
    private static Database instance = new Database();

    public static Database getInstance() {
        return instance;
    }

    private List<Schedule> Schedules = new ArrayList<Schedule>();
    private User CurrentUser = null;
    private List<Pill> Pills = new ArrayList<Pill>();

    protected Database() {
        CurrentUser = new User("USER");

        Schedules.add(new Schedule("In the morning", 8, 10));
        Schedules.add(new Schedule("In the afternoon", 12, 14));
        Schedules.add(new Schedule("In the evening", 20, 22));
    }

    public User getCurrentUser() {
        return CurrentUser;
    }

    public void setCurrentUser(User currentUser) {
        CurrentUser = currentUser;
    }

    public List<Schedule> getSchedules() {
        return Schedules;
    }

    public List<Pill> getPills() {
        return new ArrayList<Pill>(Pills);
    }

    public void addPill(Pill pill){
        Pills.add(pill);
    }

    public void clearPills(){
        Pills.clear();
    }
}
