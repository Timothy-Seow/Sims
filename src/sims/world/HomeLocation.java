package sims.world;

import sims.actions.Activity;
import sims.entity.Sim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeLocation extends Loc{
    private List<HomeUpgrade> upgradeList = new ArrayList<>();
    private Home home;

    public HomeLocation(String locName, Home home) {
        super(locName);
        this.home = home;
    }


    public void addUpgrade(HomeUpgrade upgrade)
    {
        upgradeList.add(upgrade);
    }

    public List<HomeUpgrade> getUpgradeList() {
        return upgradeList;
    }

    public Home getHome()
    {
        return home;
    }

    public List<Sim> getLocSimList()
    {
        return home.getLocSimList();
    }

    public void removeSim(Sim sim)
    {
        for(Sim test : home.getLocSimList())
        {
            System.out.println("Home list Before : " + test.getName());
        }
        home.removeSim(sim);
        for(Sim test : home.getLocSimList())
        {
            System.out.println("Home list after : " + test.getName());
        }
    }

    @Override
    public void moveTo(Sim sim) {
        sim.setCurrentLocation(this);
        if(!home.getLocSimList().contains(sim))
        {
            home.addSim(sim);
        }
    }

    public void setHome(Home home)
    {
        this.home = home;
    }
}

