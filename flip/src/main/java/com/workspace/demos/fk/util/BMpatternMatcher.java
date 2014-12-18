package com.workspace.demos.fk.util;

/**
 * Created by deepak on 12/16/14.
 */
public class BMpatternMatcher {

    private static int[] preprocess(String pattern) {

        int[] lastPos = new int[256];
        for (int i = 0; i < pattern.length(); i++)
            lastPos[pattern.charAt(i)] = i;

        return lastPos;
    }

    public static boolean match(String pattern, String text) {

        int[] lastPos = preprocess(pattern);
        int n = text.length();
        int m = pattern.length();
        int s = 0;
        int j;

        while (s < (n - m)) {
            j = m - 1;
            while (j >= 0 && text.charAt(s + j) == pattern.charAt(j))
                j--;
            if (j < 0) {
                return true;
            } else s += Math.max(1, j - lastPos[text.charAt(s + j)]);
        }
        return false;
    }
}
