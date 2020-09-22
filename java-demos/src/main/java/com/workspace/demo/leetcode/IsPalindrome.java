package com.workspace.demo.leetcode;

public class IsPalindrome {

    static boolean isPalindrome(int x) {
        int d = 0;
        int v = x;

        if (v < 0)
            return false;

        while (v != 0) {
            d = d * 10;
            d = d + v % 10;
            v = v / 10;
        }
        System.out.println("d = " + d);
        return d == x;
    }

    public static void main(String[] args) {
        boolean result = isPalindrome(121);
        System.out.println("result = " + result);
    }
}
