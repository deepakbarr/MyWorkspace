package com.workspace.demo.ds.stack;


import com.workspace.demo.ds.LinkedList.Node;

/**
 * Created by deepak on 11/6/14.
 */


//mvn exec:java -Dexec.mainClass="com.workspace.demo.ds.stack.Main"

public class Main {

    public static void main(String[] args) throws Exception {

        Stack<Integer> stack = StackUtil.getDummyStack();
        StackUtil.print(stack);
        stack = StackUtil.sort(stack);
        StackUtil.print(stack);
        stack=StackUtil.reverse(stack);
        StackUtil.print(stack);

        try {
            int val = stack.pop();
            System.out.println("val = " + val);

            StackUtil.print(stack);
            val = stack.pop();
            System.out.println("val = " + val);
            StackUtil.print(stack);

            int top = stack.top();
            System.out.println("top = " + top);
            StackUtil.print(stack);

            System.out.println("stack.isEmpty() = " + stack.isEmpty());

            while (true) {
                System.out.println("stack.isEmpty() = " + stack.isEmpty());
                stack.pop();
                Thread.sleep(1000);
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }


}
