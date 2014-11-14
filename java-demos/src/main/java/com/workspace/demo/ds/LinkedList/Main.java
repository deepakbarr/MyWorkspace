package com.workspace.demo.ds.LinkedList;

/**
 * Created by deepak on 10/27/14.
 */
public class Main {

    //    mvn exec:java -Dexec.mainClass="com.workspace.demo.ds.LinkedList.Main"

    public static void main(String[] args) throws Exception {

        LinkedList<Integer> list = createDummyList(20);

//        LLUtil.basicOperations(list);

        LLUtil.reverseLL(list);


    }

    private static LinkedList<Integer> createDummyList(int size) {

        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 1; i <= size; i++)
            list.add(i);
        return list;

    }


}
