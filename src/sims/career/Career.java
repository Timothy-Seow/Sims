package sims.career;

import java.util.ArrayList;
import java.util.List;

// PARENT CLASS

public abstract class Career{
    protected String title;
    protected int currentLevel = 0;
    protected double income;
    protected int energyCost;
    protected int workHours;
    protected List<String> ProgressionList;

    public Career(String title, int currentLevel, double income, int energyCost, int workHours){
        this.title = title;
        this.currentLevel = currentLevel;
        this.income = income;
        this.energyCost = energyCost;
        this.workHours = workHours;
        this.ProgressionList = new ArrayList<String>(); // this creates an empty dynamic array that stores Strings
    }


    // Getters listed below

    public String getTitle(){
        return title;
    }

    public int getCurrentLevel(){
        return currentLevel;
    }

    public double getIncome(){
        return income;
    }

    public int getEnergyCost(){
        return energyCost;
    }

    public int getWorkHours(){
        return workHours;
    }

    public List<String> getProgressionList(){
        return ProgressionList;
    }

}
