package sims.actions;

import sims.needs.Needs;
import sims.entity.SimProfile;
import sims.food.Food;

public class EatAction implements SimAction {
    private Food food;

    public EatAction(Food food){
        this.food = food;
    }

    @Override
    public void execute(SimProfile currentSim){
        food.Update(currentSim.getNeeds());
    }

    @Override
    public String getDescription(){
        return "Eat " + food.getName();
    }
}
