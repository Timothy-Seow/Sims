package sims.tests;

import sims.career.Career;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class CareerTest {

    private Career defaultCareer;
    private Career parameterizedCareer;

    @Before
    public void setUp() {
        defaultCareer = new Career();
        parameterizedCareer = new Career("Technology", 5000);
    }

    /**
     * Tests the default constructor.
     * Verifies that sector is "Unemployed" and salary is 0.
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals("Unemployed", defaultCareer.getSector());
        assertEquals(0, defaultCareer.getSalary());
    }

    /**
     * Tests the parameterized constructor.
     * Verifies that sector and salary are set correctly.
     */
    @Test
    public void testParameterizedConstructor() {
        assertEquals("Technology", parameterizedCareer.getSector());
        assertEquals(5000, parameterizedCareer.getSalary());
    }

    /**
     * Tests the getLevel method.
     * Ensures that initial level is 1 for both careers.
     */
    @Test
    public void testGetLevel() {
        assertEquals(1, defaultCareer.getLevel());
        assertEquals(1, parameterizedCareer.getLevel());
    }

    /**
     * Tests the getBonus method.
     * Verifies bonus calculation based on salary and level.
     */
    @Test
    public void testGetBonus() {
        // Default career: salary 0, level 1 -> bonus = 0 * 0.01 = 0
        assertEquals(0.0, defaultCareer.getBonus(), 0.001);

        // Parameterized career: salary 5000, level 1 -> bonus = 5000 * 0.01 = 50
        assertEquals(50.0, parameterizedCareer.getBonus(), 0.001);
    }

    /**
     * Tests the earnXP method.
     * Verifies that earning XP increases level after reaching 100 XP.
     */
    @Test
    public void testEarnXP() {
        // Initial state
        assertEquals(1, parameterizedCareer.getLevel());
        // XP is private, can't directly test, but we can test through level changes

        // Earn XP 4 times (80 XP total, level still 1)
        parameterizedCareer.earnXP();
        parameterizedCareer.earnXP();
        parameterizedCareer.earnXP();
        parameterizedCareer.earnXP();
        assertEquals(1, parameterizedCareer.getLevel());

        // 5th earnXP should level up
        parameterizedCareer.earnXP();
        assertEquals(2, parameterizedCareer.getLevel());
    }

    /**
    * Tests earning XP with modulo operation.
    * Ensures that level increases correctly when XP exceeds 100 multiple times.
    */
    @Test
    public void testEarnXPModulo() {
        // Earn XP multiple times to test modulo
        for (int i = 0; i < 10; i++) {
            parameterizedCareer.earnXP();
        }
        // 10 * 20 = 200 XP
        // Level should increase by 2 (200/100 = 2), XP should be 0 (200 % 100 = 0)
        assertEquals(3, parameterizedCareer.getLevel()); // Started at 1, +2 = 3
    }

    /**
    * Tests salary and bonus increase with higher level.
    * Verifies that leveling up increases salary and affects bonus calculation.
    */     
    @Test
    public void testGetIncreasedSalaryAndBonusWithHigherLevel() {
        // Increase level to 2
        parameterizedCareer.earnXP();
        parameterizedCareer.earnXP();
        parameterizedCareer.earnXP();
        parameterizedCareer.earnXP();
        parameterizedCareer.earnXP(); // 5 earnXP calls: 5*20=100 xp, level should be 2

        assertEquals(2, parameterizedCareer.getLevel());
        assertEquals(5100, parameterizedCareer.getSalary()); // Salary should have increased by 100
        assertEquals(102.0, parameterizedCareer.getBonus(), 0.001); // 5000 * (2/100) = 100
    }

    /**
     * Tests the getSector method.
     * Ensures correct sector retrieval.
     */
    @Test
    public void testGetSector() {
        assertEquals("Unemployed", defaultCareer.getSector());
        assertEquals("Technology", parameterizedCareer.getSector());
    }

    /**
     * Tests the getSalary method.
     * Verifies correct salary retrieval.
     */
    @Test
    public void testGetSalary() {
        assertEquals(0, defaultCareer.getSalary());
        assertEquals(5000, parameterizedCareer.getSalary());
    }
    
    /**
     * Tests the setSector method.
     * Ensures that sector can be updated correctly.
     */
    @Test
    public void testSetSector() {
        defaultCareer.setSector("Food Service");
        assertEquals("Food Service", defaultCareer.getSector());
    }

    /**
     * Tests the setSalary method and bonus recalculation.
     * Verifies that salary can be updated and bonus recalculates correctly.
     */
    @Test
    public void testSetSalaryAndBonus() {
        defaultCareer.setSalary(3000);
        assertEquals(3000, defaultCareer.getSalary());
        assertEquals(30.0, defaultCareer.getBonus(), 0.001); // 3000 * 0.01 = 30
    }

    /**
     * Tests the getBonus method with zero salary.
     * Ensures that bonus is zero when salary is zero, regardless of level.
     */
    @Test
    public void testBonusCalculationWithZeroSalary() {
        defaultCareer.setSalary(0);
        assertEquals(0.0, defaultCareer.getBonus(), 0.001);
    }
}