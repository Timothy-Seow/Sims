package sims.tests;

import sims.world.Home;
import sims.world.HomeLocation;
import sims.actions.Activity;
import sims.career.Career;
import sims.entity.Sim;
import sims.gameEngine.SimFactory;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.List;

public class LocTest {

    private HomeLocation homeLocation;
    private Activity testActivity;
    private Sim testSim;
    private Home home;

    @Before
    public void setUp() {
        home = new Home("Test Home");
        homeLocation = new HomeLocation("Kitchen", home);
        testActivity = new Activity("Test Activity", 30, "Hunger", 10);

        // Create a test Sim
        Home newHome = SimFactory.defaultHome("test");
        Career it = new Career("IT", 2000);
        testSim = SimFactory.createSim("test", 0, 25, newHome, it);
    }

    /**
     * Tests the HomeLocation constructor and getters.
     * Verifies that the HomeLocation is initialized correctly with the provided name and home.
     */
    @Test
    public void testLocConstructor() {
        assertEquals("Kitchen", homeLocation.getName());
        assertNotNull(homeLocation.getActivity());
        assertNotNull(homeLocation.getLocSimList());
        assertTrue(homeLocation.getActivity().isEmpty());
        assertTrue(homeLocation.getLocSimList().isEmpty());
    }

    /**
     * Tests the addActivity and getActivity methods.
     * Verifies that activities can be added to the HomeLocation and retrieved correctly.
     */
    @Test
    public void testAddAndGetActivity() {
        homeLocation.addActivity(testActivity);
        List<Activity> activities = homeLocation.getActivity();
        assertEquals(1, activities.size());
        assertEquals(testActivity, activities.get(0));
    }

    /**
     * Tests the addSim, removeSim, and getLocSimList methods.
     * Verifies that Sims can be added to the HomeLocation and retrieved correctly.
     */
    @Test
    public void testAddAndRemoveSim() {
        homeLocation.getHome().addSim(testSim);
        assertTrue(homeLocation.getHome().getLocSimList().contains(testSim));

        homeLocation.removeSim(testSim);
        assertFalse(homeLocation.getHome().getLocSimList().contains(testSim));
    }

    /**
     * Tests the getName method.
     * Verifies that the correct location name is returned.
     */
    @Test
    public void testGetName() {
        assertEquals("Kitchen", homeLocation.getName());
    }

    /**
     * Tests the setName method.
     * Verifies that the location name can be updated correctly.
     */
    @Test
    public void testSetName() {
        homeLocation.setName("Bedroom");
        assertEquals("Bedroom", homeLocation.getName());
    }

    /**
     * Tests multiple activities in a HomeLocation.
     * Verifies that multiple activities can be added and retrieved correctly.
     */
    @Test
    public void testMultipleActivities() {
        Activity activity1 = new Activity("Eat", 30, "Hunger", 20);
        Activity activity2 = new Activity("Cook", 45, "Fun", 15);

        homeLocation.addActivity(activity1);
        homeLocation.addActivity(activity2);

        List<Activity> activities = homeLocation.getActivity();
        assertEquals(2, activities.size());
        assertTrue(activities.contains(activity1));
        assertTrue(activities.contains(activity2));
    }

    /**
     * Tests multiple Sims in a HomeLocation.
     * Verifies that multiple Sims can be added and retrieved correctly.
     */
    @Test
    public void testMultipleSims() {
        // Create another Sim
        Home otherHome = SimFactory.defaultHome("other");
        Career artist = new Career("Art", 1500);
        Sim otherSim = SimFactory.createSim("other", 1, 30, otherHome, artist);

        homeLocation.getHome().addSim(testSim);
        homeLocation.getHome().addSim(otherSim);

        List<Sim> sims = homeLocation.getHome().getLocSimList();
        assertEquals(2, sims.size());
        assertTrue(sims.contains(testSim));
        assertTrue(sims.contains(otherSim));
    }
}