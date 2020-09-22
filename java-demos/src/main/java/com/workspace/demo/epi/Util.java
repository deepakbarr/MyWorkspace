package com.workspace.demo.epi;

public class Util {

    public static void printArray(int[] args) {
        for (int arg : args) {
            System.out.print(arg + ",");
        }
        System.out.println("\n\n");
    }

    public static void printArray(int[] args, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(args[i] + ",");
        }
        System.out.println("\n\n");
    }
}
