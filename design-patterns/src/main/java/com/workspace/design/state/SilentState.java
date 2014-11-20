package com.workspace.design.state;

/**
 * Created by deepak on 11/20/14.
 */
public class SilentState implements State {
    @Override
    public void invoke() {
        System.out.println("Silent State");
    }
}
