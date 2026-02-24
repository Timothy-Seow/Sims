package sims.food;

import sims.needs.Needs;

public class Burger extends Food{

    public Burger(){
        super("Burger", 30, 40, 10);
    }

    @Override
    public void Update(Needs needs){
        needs.setHunger(needs.getHunger() + hungerUpdate);
        needs.setEnergy(needs.getEnergy() + energyUpdate);
        needs.setBladder(needs.getBladder() + bladderUpdate);
        System.out.println("Sim ate a burger!");
    }

}
