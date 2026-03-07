package sims.food;

import sims.needs.Needs;

public class Pizza extends Food{
    
    public Pizza(){
        super("Pizza", 50, 50, 20);
    }

    @Override
    public void Update(Needs needs){
        needs.setHunger(needs.getHunger() + hungerUpdate);
        needs.setEnergy(needs.getEnergy() + energyUpdate);
        needs.setBladder(needs.getBladder() + bladderUpdate);
        System.out.println("Sim ate a Pizza!");
    }

}
