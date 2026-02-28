package sims.actions;

import sims.entity.SimProfile;

// INTERFACE
public interface SimAction {
    void execute(SimProfile currentSim);  // any action class must have this method
}
