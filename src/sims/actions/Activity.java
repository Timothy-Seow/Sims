package sims.actions;

import sims.entity.Sim;

import java.util.List;

public class Activity {
    private final String name;
    private final int duration;
    private final String impactedNeed;
    private final int value;
    private final double cost;

    public Activity(String name, int duration, String impactedNeed, int value){
        this.name = name;
        this.duration = duration;
        this.impactedNeed = impactedNeed;
        this.value = value;
        cost = 0;
    }


    public Activity(String name, int duration, String impactedNeed, int value, double cost){
        this.name = name;
        this.duration = duration;
        this.impactedNeed = impactedNeed;
        this.value = value;
        this.cost = cost;
    }

    public double getCost()
    {
        return cost;
    }

    public void gainXP()
    {

    }
    public String getImpactedNeed() {
        return impactedNeed;
    }

    public void performActivity(Sim sim) {
        sim.updateNeeds(impactedNeed, value);
    }

    public String getName() {
        return name;
    }

    public int getDuration () {
        return duration;
    }

    public int getValue () {
        return value;
    }
}
