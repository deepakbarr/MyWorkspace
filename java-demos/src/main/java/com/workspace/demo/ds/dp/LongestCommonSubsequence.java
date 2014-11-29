package com.workspace.demo.ds.dp;

/**
 * Created by deepak on 11/20/14.
 */
public class LongestCommonSubsequence {


    public int lcs(String a, String b) {

        int m = a.length(), n = b.length();
        int[][] L = new int[m+1][n+1];

        for (int i = 0; i <= m; i++)
            for (int j = 0; j <=n; j++) {

                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (a.charAt(i-1) == b.charAt(j-1)) {
                    L[i][j] = 1 + L[i - 1][j - 1];
                } else L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        return L[m][n];
    }


    public static void main(String[] args) {
        int k = new LongestCommonSubsequence().lcs("deepak", "eak");
        System.out.println("k = " + k);
    }


}
