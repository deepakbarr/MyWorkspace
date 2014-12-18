package com.workspace.demo.ds.sufftree;

/**
 * Created by deepak on 12/16/14.
 */
public class Main {

    public static void main(String[] args) {

        SuffixTree tree = new SuffixTree("banana");
        System.out.println("tree.search(\"an\") = " + tree.search("an"));
        System.out.println("tree.search(\"ana\") = " + tree.search("ana"));
        System.out.println("tree.search(\"anana\") = " + tree.search("anana"));
        System.out.println("tree.search(\"ann\") = " + tree.search("ann"));

    }
}
