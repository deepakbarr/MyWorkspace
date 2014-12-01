package com.workspace.demo.ds.stack;

import com.workspace.demo.ds.LinkedList.Node;

/**
 * Created by deepak on 11/30/14.
 */
public class StackUtil {

    public static Stack sort(Stack<Integer> stack) {

        Stack<Integer> temp = new Stack<Integer>();

        while (!stack.isEmpty()) {
            int t = stack.pop();

            while (!temp.isEmpty() && temp.top() > t)
                stack.push(temp.pop());
            temp.push(t);
        }
        return temp;
    }

    public static Stack reverse(Stack<Integer> stack) {

        if (stack.isEmpty())
            return stack;

        else {
            int t = stack.pop();
            reverse(stack);
            recursivePush(stack, t);
            return stack;
        }

    }

    private static void recursivePush(Stack<Integer> stack, int t) {
        if (stack.isEmpty())
            stack.push(t);
        else {
            int temp = stack.pop();
            recursivePush(stack, t);
            stack.push(temp);
        }
    }


    public static void print(Stack<Integer> stack) {
        Node<Integer> first = stack.getTop();
        while (first != null) {
            System.out.println(first.getData());
            first = first.getNext();
        }
        System.out.println("Size = " + stack.size());
    }

    public static Stack<Integer> getDummyStack() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(5);
        stack.push(8);
        stack.push(6);

        return stack;
    }

}
