package sims.entity;

import sims.needs.Needs;
import sims.career.Teacher;

public class Sim2 extends SimProfile{

    // CHILD CLASS
    public Sim2(){
        super("Timothy", new Teacher(), new Needs(80,50,40,45,30,35));
        // internal states can be modified via setters to how much yall want
    }

}
