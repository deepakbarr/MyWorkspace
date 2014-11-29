package com.workspace.demo.ds.dp;

/**
 * Created by deepak on 11/25/14.
 */
public class LongestCommonSubstring {

    private int longestCommonSubstring(String s, String t) {

        int m = s.length(), n = t.length();
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++)
            L[i][0] = 0;
        for (int j = 0; j <= n; j++)
            L[0][j] = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    L[i][j] = 1 + L[i - 1][j - 1];
                else L[i][j] = 0;

                if (L[i][j] > max)
                    max = L[i][j];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int k = new LongestCommonSubstring().longestCommonSubstring("deepak", "dak");
        System.out.println("kkk = " + k);
    }
}
