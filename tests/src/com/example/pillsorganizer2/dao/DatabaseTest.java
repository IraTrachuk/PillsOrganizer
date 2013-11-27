package com.example.pillsorganizer2.dao;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Trachuk
 * Date: 27.11.13
 * Time: 19:52
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseTest extends TestCase {

    private Database testedEntity = new Database();

    public void setUp() throws Exception {
        super.setUp();
        testedEntity.addPill(new Pill("my pill", 3));
    }

    public void tearDown() throws Exception {
        testedEntity = new Database();
    }

    public void testGetCurrentUser() throws Exception {
        User newUser = new User("Ira");
        testedEntity.setCurrentUser(newUser);

        User storedUser = testedEntity.getCurrentUser();

        assertEquals(storedUser.getName(), newUser.getName());

    }

    public void testGetSchedules() throws Exception {
        List<Schedule> schedules = testedEntity.getSchedules();
        assertFalse(schedules.isEmpty());
    }

    public void testAddPills() throws Exception {
        List<Pill> pillsOld = testedEntity.getPills();

        Pill newPill = new Pill("Pill 1", 7);
        testedEntity.addPill(newPill);

        List<Pill> pillsNew = testedEntity.getPills();

        assertEquals(pillsNew.size(), pillsOld.size()+1);

        assertEquals(pillsNew.get(pillsNew.size() -1).getPillName(), newPill.getPillName());
        assertEquals(pillsNew.get(pillsNew.size() -1).getDose(), newPill.getDose());
    }

    public void testClearPills() throws Exception {
        testedEntity.clearPills();
        List<Pill> pills = testedEntity.getPills();
        assertTrue(pills.isEmpty());
    }
}
