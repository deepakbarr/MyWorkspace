package com.workspace.demo.ds.string;

/**
 * Created by deepak on 12/16/14.
 */
public class BoyerMoore {

    private String text;
    private String pat;
    int[] lastPos;

    public BoyerMoore(String text, String pat) {
        this.text = text;
        this.pat = pat;
        this.lastPos = new int[256];
    }

    public void preprocess() {
        for (int i = 0; i < pat.length(); i++)
            lastPos[pat.charAt(i)] = i;
    }

    public boolean find() {

        int n = text.length();
        int m = pat.length();
        int s = 0;
        int j;

        while (s < (n - m)) {
            j = m - 1;
            while (j >= 0 && text.charAt(s + j) == pat.charAt(j))
                j--;
            if (j < 0) {
                return true;
            } else s += Math.max(1, j - lastPos[text.charAt(s + j)]);
        }
        return false;
    }

    public static void main(String[] args) {
        BoyerMoore bm = new BoyerMoore("kumardeepak", "deep");
        bm.preprocess();
        System.out.println("bm.find() = " + bm.find());
        bm = new BoyerMoore("kumardeepak", "ard");
        bm.preprocess();
        System.out.println("bm.find() = " + bm.find());
        bm = new BoyerMoore("kumardeepak", "dep");
        bm.preprocess();
        System.out.println("bm.find() = " + bm.find());
    }
}
