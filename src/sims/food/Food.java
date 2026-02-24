package sims.food;

import sims.needs.Needs;

public abstract class Food {

    protected String name;
    protected int hungerUpdate;
    protected int energyUpdate;
    protected int bladderUpdate;

    public Food(String name, int hungerUpdate, int energyUpdate, int bladderUpdate){
        this.name = name;
        this.hungerUpdate = hungerUpdate;
        this.energyUpdate = energyUpdate;
        this.bladderUpdate = bladderUpdate;
    }

    public String getName(){
        return name;
    }

    public abstract void Update(Needs needs);

}
