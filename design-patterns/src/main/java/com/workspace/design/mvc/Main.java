package com.workspace.design.mvc;

/**
 * Created by deepak on 10/31/14.
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {

        Model model = new Model(1, "deepak", 1000);
        View view = new View();
        Thread t=new Thread(view);
        Controller controller = new Controller(model, view);
        controller.updateView();
        t.start();
        Thread.sleep(5000);
        controller.updateDetails(2, "xyz", 2000);
        controller.updateView();

    }
}
