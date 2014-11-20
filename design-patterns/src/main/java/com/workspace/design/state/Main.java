package com.workspace.design.state;

/**
 * Created by deepak on 11/20/14.
 */
public class Main {

    public static void main(String[] args) {
        Mobile mobile = new Mobile(new SilentState());
        mobile.recieveCall();
        mobile.changeState(new VibrationState());
        mobile.recieveCall();
        mobile.changeState(new SilentState());
        mobile.recieveCall();
    }
}
