package com.workspace.design.Singleton;

/**
 * Created by deepak on 11/4/14.
 */
public class Main {

    public static void main(String[] args) {

        SampleObject obj1=SampleObject.getInstance();
        SampleObject obj2=SampleObject.getInstance();

        System.out.println("obj1 = " + obj1.toString());
        System.out.println("obj2 = " + obj2.toString());

        System.out.println("obj1 name = " + obj1.getName());
        
        SingletonEnum obj3=SingletonEnum.INSTANCE;

        System.out.println("obj3.getName() = " + obj3.getName());

    }
}
