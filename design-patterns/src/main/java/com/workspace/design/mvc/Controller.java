package com.workspace.design.mvc;

/**
 * Created by deepak on 10/31/14.
 */
public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.setBalance(model.getBalance());
        view.setName(model.getName());
        view.setAcc(model.getAcc());
    }

    public void updateDetails(long acc, String name, long balance) {
        model.setAcc(acc);
        model.setName(name);
        model.setBalance(balance);
    }
}
