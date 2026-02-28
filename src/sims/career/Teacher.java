package sims.career;

// CHILD CLASS

public class Teacher extends Career {

    public Teacher(){
        super("Teacher", 0, 120, 60, 8);

        ProgressionList.add("Teaching Assistant");
        ProgressionList.add("Lecturer");
        ProgressionList.add("Associate Professor");
        ProgressionList.add("Professor");
        ProgressionList.add("Distinguished Professor");
    }
}
