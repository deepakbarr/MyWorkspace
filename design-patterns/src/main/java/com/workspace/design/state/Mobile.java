package com.workspace.design.state;

/**
 * Created by deepak on 11/20/14.
 */
public class Mobile {

    State state;

    public Mobile(State state) {
        this.state = state;
    }

    public void changeState(State newState) {
        this.state = newState;
    }

    public void recieveCall() {
        state.invoke();
    }

}
