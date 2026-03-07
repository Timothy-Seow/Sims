package sims.actions;

import sims.entity.SimProfile;

// INTERFACE
public interface SimAction {
    public void execute(SimProfile currentSim);  // any action class must have this method
    public String getDescription();  // description for display
}
