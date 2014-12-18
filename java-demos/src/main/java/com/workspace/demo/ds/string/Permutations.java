package com.workspace.demo.ds.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by deepak on 12/1/14.
 */
public class Permutations {

    public Set<String> generatePermutations(String str) {
        Set<String> set = new HashSet<String>();

        if (str.length() == 1) {
            set.add(str);
            return set;
        }

        char first = str.charAt(0);
        Set<String> subSet = generatePermutations(str.substring(1));

        for (String s : subSet) {
            for (int i = 0; i < s.length(); i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                set.add(left + first + right);
            }
            set.add(s + first);
        }
        return set;
    }

    public static void main(String[] args) {
        String str = "rajitha";
        System.out.println(str.substring(0,0));

        Set<String> perms;

        perms = new Permutations().generatePermutations(str);
        System.out.println("perms = " + perms);
        System.out.println("perms.size() = " + perms.size());
    }
}
