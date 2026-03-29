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

    @Test
    public void testDefaultConstructor() {
        assertEquals("Unemployed", defaultCareer.getSector());
        assertEquals(0, defaultCareer.getSalary());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals("Technology", parameterizedCareer.getSector());
        assertEquals(5000, parameterizedCareer.getSalary());
    }

    @Test
    public void testGetLevel() {
        assertEquals(1, defaultCareer.getLevel());
        assertEquals(1, parameterizedCareer.getLevel());
    }

    @Test
    public void testGetBonus() {
        // Default career: salary 0, level 1 -> bonus = 0 * 0.01 = 0
        assertEquals(0.0, defaultCareer.getBonus(), 0.001);

        // Parameterized career: salary 5000, level 1 -> bonus = 5000 * 0.01 = 50
        assertEquals(50.0, parameterizedCareer.getBonus(), 0.001);
    }

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

    @Test
    public void testGetSector() {
        assertEquals("Unemployed", defaultCareer.getSector());
        assertEquals("Technology", parameterizedCareer.getSector());
    }

    @Test
    public void testGetSalary() {
        assertEquals(0, defaultCareer.getSalary());
        assertEquals(5000, parameterizedCareer.getSalary());
    }

    @Test
    public void testSetSector() {
        defaultCareer.setSector("Food Service");
        assertEquals("Food Service", defaultCareer.getSector());
    }

    @Test
    public void testSetSalaryAndBonus() {
        defaultCareer.setSalary(3000);
        assertEquals(3000, defaultCareer.getSalary());
        assertEquals(30.0, defaultCareer.getBonus(), 0.001); // 3000 * 0.01 = 30
    }

    @Test
    public void testBonusCalculationWithZeroSalary() {
        defaultCareer.setSalary(0);
        assertEquals(0.0, defaultCareer.getBonus(), 0.001);
    }
}