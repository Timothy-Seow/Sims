package sims.career;

// CHILD CLASS

public class Chef extends Career {

    public Chef(){
        super("Chef", 0, 130, 50, 8);

        ProgressionList.add("Junior Chef");
        ProgressionList.add("Pantry Chef");
        ProgressionList.add("Senior Chef");
        ProgressionList.add("Sous Chef");
        ProgressionList.add("Executive Chef");
    }
}
