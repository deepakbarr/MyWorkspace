package com.workspace.demo.annotation;

/**
 * Created by deepak.barr on 17/2/15.
 */
@Annotate2
public class TestAnnotations {

    @Demo
    public void method1() {
        System.out.println("Running Method 1");
    }

    @Demo(enabled = false)
    public void method2() {
        System.out.println("Running Method 2");
    }
 @Demo
    public void method3() {
        System.out.println("Running Method 3");
    }


}
