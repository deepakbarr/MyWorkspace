package com.workspace.demo.ds.stack;


import com.workspace.demo.ds.LinkedList.Node;

/**
 * Created by deepak on 11/6/14.
 */


//mvn exec:java -Dexec.mainClass="com.workspace.demo.ds.stack.Main"

public class Main {

    public static void main(String[] args) throws Exception {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        print(stack);

        try {
            Node<Integer> poppedNode = stack.pop();
            System.out.println("poppedNode.getData() = " + poppedNode.getData());
            print(stack);

            poppedNode = stack.pop();
            System.out.println("poppedNode.getData() = " + poppedNode.getData());
            print(stack);

            Node<Integer> topNode = stack.top();
            System.out.println("topNode.getData() = " + topNode.getData());
            print(stack);

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


    private static void print(Stack<Integer> stack) {

        Node<Integer> first = stack.getTop();

        while (first != null) {
            System.out.println(first.getData());
            first = first.getNext();
        }

        System.out.println("Size = " + stack.size());
    }

}
