package com.workspace.demo.ds.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by deepak on 12/1/14.
 */
public class ParenthesisPermutations {

    public Set<String> parenthesisPermutations(int n) {

        Set<String> set = new HashSet<String>();

        if (n == 1) {
            set.add("()");
            return set;
        }

        Set<String> subSet = parenthesisPermutations(n - 1);

        for (String s : subSet) {
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == '(') {
                    String left = s.substring(0, i + 1);
                    String right = s.substring(i + 1);
                    set.add(left + "()" + right);
                }
            }
            set.add("()" + s);
        }
        return set;
    }

    public static void main(String[] args) {
        int n = 3;
        Set<String> permutations = new ParenthesisPermutations().parenthesisPermutations(n);
        System.out.println("permutations = " + permutations);
    }
}
