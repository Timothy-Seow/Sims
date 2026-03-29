package sims.tests;

import sims.world.OutsideLocation;
import sims.entity.Sim;
import sims.career.Career;
import sims.gameEngine.SimFactory;
import sims.world.Home;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class OutsideLocationTest {

    private OutsideLocation testOutsideLocation;
    private Sim testSim;
    private Home newHome;
    private Career it;

    @Before
    public void setUp() {
        testOutsideLocation = new OutsideLocation("Park", "None");

        // Create a test Sim
        newHome = SimFactory.defaultHome("test");
        it = new Career("IT", 2000);
        testSim = SimFactory.createSim("test", 0, 25, newHome, it);
    }

    /**
     * Tests the constructor of OutsideLocation.
     * Verifies that name, requirement are set correctly, and sim list is initialized empty.
     */
    @Test
    public void testConstructor() {
        assertEquals("Park", testOutsideLocation.getName());
        assertEquals("None", testOutsideLocation.getRequirement());
        assertNotNull(testOutsideLocation.getLocSimList());
        assertTrue(testOutsideLocation.getLocSimList().isEmpty());
    }

    /**
     * Tests the getRequirement method.
     * Ensures that the correct requirement is returned.
     */
    @Test
    public void testGetRequirement() {
        assertEquals("None", testOutsideLocation.getRequirement());
    }

    /**
     * Tests the moveTo method.
     * Verifies that a Sim is moved from one location to the OutsideLocation correctly.
     */
    @Test
    public void testMoveTo() {
        // Create initial location for sim
        OutsideLocation initialLocation = new OutsideLocation("Street", "Umbrella");
        testSim.setCurrentLocation(initialLocation);
        initialLocation.addSim(testSim);

        // Move sim to park
        testOutsideLocation.moveTo(testSim);

        assertEquals(testOutsideLocation, testSim.getLocation());
        assertTrue(testOutsideLocation.getLocSimList().contains(testSim));
        assertFalse(initialLocation.getLocSimList().contains(testSim));
    }

    /**
     * Tests the moveTo method when Sim is already in the location.
     * Ensures that moving a Sim already in the location works without issues.
     */
    @Test
    public void testMoveToAlreadyInLocation() {
        // Add sim to location first
        testOutsideLocation.addSim(testSim);
        testSim.setCurrentLocation(testOutsideLocation);

        // Move again - should still work
        testOutsideLocation.moveTo(testSim);

        assertEquals(testOutsideLocation, testSim.getLocation());
        assertTrue(testOutsideLocation.getLocSimList().contains(testSim));
    }

    /**
     * Tests that OutsideLocation inherits functionality from Loc.
     * Verifies inherited methods for activities and sim management work correctly.
     */
    @Test
    public void testInheritsLocFunctionality() {
        // Test inherited activity functionality
        assertNotNull(testOutsideLocation.getActivity());
        assertTrue(testOutsideLocation.getActivity().isEmpty());

        // Test sim management
        testOutsideLocation.addSim(testSim);
        assertTrue(testOutsideLocation.getLocSimList().contains(testSim));

        testOutsideLocation.removeSim(testSim);
        assertFalse(testOutsideLocation.getLocSimList().contains(testSim));
    }

    /**
     * Tests OutsideLocation with different requirements.
     * Verifies that various requirements can be set and retrieved correctly.
     */
    @Test
    public void testDifferentRequirements() {
        OutsideLocation beach = new OutsideLocation("Beach", "Sunscreen");
        OutsideLocation mountain = new OutsideLocation("Mountain", "Jacket");

        assertEquals("Sunscreen", beach.getRequirement());
        assertEquals("Jacket", mountain.getRequirement());
    }

    /**
     * Tests moving multiple Sims to the OutsideLocation.
     * Verifies that multiple Sims can be moved correctly, updating both source and destination locations.
     */
    @Test
    public void testMoveMultipleSims() {
        OutsideLocation sourceLocation = new OutsideLocation("Home", "None");

        // Create another Sim
        Home otherHome = SimFactory.defaultHome("other");
        Career artist = new Career("Art", 1500);
        Sim otherSim = SimFactory.createSim("other", 1, 30, otherHome, artist);

        // Add sims to source location
        sourceLocation.addSim(testSim);
        sourceLocation.addSim(otherSim);
        testSim.setCurrentLocation(sourceLocation);
        otherSim.setCurrentLocation(sourceLocation);

        // Move both sims to outside location
        testOutsideLocation.moveTo(testSim);
        testOutsideLocation.moveTo(otherSim);

        // Check source location is empty
        assertFalse(sourceLocation.getLocSimList().contains(testSim));
        assertFalse(sourceLocation.getLocSimList().contains(otherSim));

        // Check destination has both sims
        assertTrue(testOutsideLocation.getLocSimList().contains(testSim));
        assertTrue(testOutsideLocation.getLocSimList().contains(otherSim));
        assertEquals(testOutsideLocation, testSim.getLocation());
        assertEquals(testOutsideLocation, otherSim.getLocation());
    }

    /**
     * Tests changing the location name.
     * Verifies that the setName method updates the location name correctly.
     */
    @Test
    public void testLocationNameChange() {
        testOutsideLocation.setName("Garden");
        assertEquals("Garden", testOutsideLocation.getName());
    }
}