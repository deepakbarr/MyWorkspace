package com.workspace.design.facade;

/**
 * Created by deepak on 11/21/14.
 */
public class ProgramFacade {

    private CPU cpu;
    private Memory memory;
    private Harddrive harddrive;


    public ProgramFacade() {
        cpu = new CPU();
        memory = new Memory();
        harddrive = new Harddrive();
    }

    public void start() {

        cpu.start();
        harddrive.read();
        memory.load();
        System.out.println("System started....");
    }
}
