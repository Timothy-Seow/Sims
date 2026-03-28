package sims.world;

import sims.actions.Activity;
import sims.entity.Sim;

import java.util.List;

interface Location {

    List<Activity> getActivity();
    List<Sim> getLocSimList();
    void removeSim(Sim sim);
    String getName();
    void moveTo(Sim sim);

}
