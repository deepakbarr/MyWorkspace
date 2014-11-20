package com.workspace.demo.ds.LinkedList;

/**
 * Created by deepak on 10/27/14.
 */
public class Main {

    //    mvn exec:java -Dexec.mainClass="com.workspace.demo.ds.LinkedList.Main"

    public static void main(String[] args) throws Exception {

        LinkedList<Integer> list = LLUtil.createDummyList(20);

//        LLUtil.basicOperations(list);

        LLUtil.reverseLL(list);

    }
}
