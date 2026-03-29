package sims.tests;

import sims.world.HomeUpgrade;
import sims.actions.Activity;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class HomeUpgradeTest {

    private HomeUpgrade testUpgrade;
    private Activity testActivity;

    @Before
    public void setUp() {
        testActivity = new Activity("Cook", 45, "Fun", 15);
        testUpgrade = new HomeUpgrade("Kitchen", "Stove", 500, testActivity);
    }

    /**
     * Tests the HomeUpgrade constructor and getters.
     * Verifies that the HomeUpgrade is initialized correctly with the provided details.
     */
    @Test
    public void testConstructor() {
        assertEquals("Kitchen", testUpgrade.getLocation());
        assertEquals("Stove", testUpgrade.getName());
        assertEquals(500, testUpgrade.getPrice());
        assertEquals(testActivity, testUpgrade.getActivity());
        assertFalse(testUpgrade.getUpgrade());
    }

    /**
     * Tests the getUpgrade method.
     * Verifies that the upgrade state is correctly returned.
     */
    @Test
    public void testGetUpgrade() {
        assertFalse(testUpgrade.getUpgrade());
    }

    /**
     * Tests the getName method.
     * Verifies that the upgrade name is correctly returned.
     */
    @Test
    public void testGetName() {
        assertEquals("Stove", testUpgrade.getName());
    }

    /**
     * Tests the getPrice method.
     * Verifies that the upgrade price is correctly returned.
     */
    @Test
    public void testGetPrice() {
        assertEquals(500, testUpgrade.getPrice());
    }

    /**
     * Tests the purchaseUpgrade method.
     * Verifies that purchasing the upgrade changes its state to purchased.
     */
    @Test
    public void testPurchaseUpgrade() {
        assertFalse(testUpgrade.getUpgrade());
        testUpgrade.purchaseUpgrade();
        assertTrue(testUpgrade.getUpgrade());
    }

    /**
    * Tests the getLocation method.
    * Verifies that the upgrade location is correctly returned.
    */
    @Test
    public void testGetLocation() {
        assertEquals("Kitchen", testUpgrade.getLocation());
    }

    /**
    * Tests the getActivity method.
    * Verifies that the associated activity is correctly returned.
    */
    @Test
    public void testGetActivity() {
        assertEquals(testActivity, testUpgrade.getActivity());
    }

    /**
    * Tests multiple purchase calls.
    * Verifies that calling purchaseUpgrade multiple times does not change the state after the first purchase.
    */
    @Test
    public void testMultiplePurchaseCalls() {
        assertFalse(testUpgrade.getUpgrade());

        testUpgrade.purchaseUpgrade();
        assertTrue(testUpgrade.getUpgrade());

        // Calling purchase again should not change state
        testUpgrade.purchaseUpgrade();
        assertTrue(testUpgrade.getUpgrade());
    }
}