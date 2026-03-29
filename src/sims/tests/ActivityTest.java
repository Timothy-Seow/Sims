package sims.tests;

import sims.actions.Activity;
import sims.career.Career;
import sims.entity.Sim;
import sims.gameEngine.SimFactory;
import sims.world.Home;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ActivityTest {

    private Activity eatNoCost;
    private Activity ShopWithCost;
    private Sim testSim;

    @Before
    public void setUp() {
        // Create activities for testing
        eatNoCost = new Activity("Eat", 30, "Hunger", 20);
        ShopWithCost = new Activity("Shop", 60, "Fun", 10, 50.0);

        // Create a test Sim
        Home newHome = SimFactory.defaultHome("test");
        Career it = new Career("IT", 2000);
        testSim = SimFactory.createSim("test", 0, 25, newHome, it);
    }

    /**
     * Tests the constructor for an Activity with no cost.
     * Verifies that the name, duration, impacted need, value, and cost are set correctly.
     */
    @Test
    public void testConstructorNoCost() {
        assertEquals("Eat", eatNoCost.getName());
        assertEquals(30, eatNoCost.getDuration());
        assertEquals("Hunger", eatNoCost.getImpactedNeed());
        assertEquals(20, eatNoCost.getValue());
        assertEquals(0.0, eatNoCost.getCost(), 0.001);
    }

    /**
     * Tests the constructor for an Activity with a cost.
     * Verifies that the name, duration, impacted need, value, and cost are set correctly.
     */
    @Test
    public void testConstructorWithCost() {
        assertEquals("Shop", ShopWithCost.getName());
        assertEquals(60, ShopWithCost.getDuration());
        assertEquals("Fun", ShopWithCost.getImpactedNeed());
        assertEquals(10, ShopWithCost.getValue());
        assertEquals(50.0, ShopWithCost.getCost(), 0.001);
    }

    /**
     * Tests the getName method.
     * Ensures that the correct activity names are returned.
     */
    @Test
    public void testGetName() {
        assertEquals("Eat", eatNoCost.getName());
        assertEquals("Shop", ShopWithCost.getName());
    }

    /**
     * Tests the getDuration method.
     * Ensures that the correct activity durations are returned.
     */
    @Test
    public void testGetDuration() {
        assertEquals(30, eatNoCost.getDuration());
        assertEquals(60, ShopWithCost.getDuration());
    }

    /**
     * Tests the getImpactedNeed method.
     * Ensures that the correct impacted needs are returned.
     */
    @Test
    public void testGetImpactedNeed() {
        assertEquals("Hunger", eatNoCost.getImpactedNeed());
        assertEquals("Fun", ShopWithCost.getImpactedNeed());
    }

    /**
     * Tests the getValue method.
     * Ensures that the correct activity values are returned.
     */
    @Test
    public void testGetValue() {
        assertEquals(20, eatNoCost.getValue());
        assertEquals(10, ShopWithCost.getValue());
    }

    /**
     * Tests the getCost method.
     * Ensures that the correct activity costs are returned.
     */
    @Test
    public void testGetCost() {
        assertEquals(0.0, eatNoCost.getCost(), 0.001);
        assertEquals(50.0, ShopWithCost.getCost(), 0.001);
    }

    /**
     * Tests the performActivity method.
     * Verifies that performing an activity correctly updates the Sim's needs based on the activity's value and the Sim's skill level.
     */
    @Test
    public void testPerformActivity() {
        // Get Initial hunger value
        double initialHunger = testSim.getNeeds().get("Hunger").getValue();

        // Perform eating activity (should increase hunger by 25: 20 + 5 for skill level 1)
        eatNoCost.performActivity(testSim);

        // Hunger should now be 100 (80 + 25, capped at 100)
        assertEquals(Math.min(100.0, initialHunger + 25.0), testSim.getNeeds().get("Hunger").getValue(), 0.001);
    }
}