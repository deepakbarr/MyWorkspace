package com.workspace.demo.ds.dp;

/**
 * Created by deepak on 11/25/14.
 */
public class StringPermutations {

    public static void main(String[] args) {

        String str = "ab";
        permutation("", str);


    }

    private static void permutation(String prefix, String str) {

        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}


//    public static ArrayList<String> permutation(String s) {
//        // The result
//        ArrayList<String> res = new ArrayList<String>();
//        // If input string's length is 1, return {s}
//        if (s.length() == 1) {
//            res.add(s);
//        } else if (s.length() > 1) {
//            int lastIndex = s.length() - 1;
//            // Find out the last character
//            String last = s.substring(lastIndex);
//            // Rest of the string
//            String rest = s.substring(0, lastIndex);
//            // Perform permutation on the rest string and
//            // merge with the last character
//            res = merge(permutation(rest), last);
//        }
//        return res;
//    }
//
//    /**
//     * @param list a result of permutation, e.g. {"ab", "ba"}
//     * @param c    the last character
//     * @return     a merged new list, e.g. {"cab", "acb" ... }
//     */
//    public static ArrayList<String> merge(ArrayList<String> list, String c) {
//        ArrayList<String> res = new ArrayList<String>();
//        // Loop through all the string in the list
//        for (String s : list) {
//            // For each string, insert the last character to all possible postions
//            // and add them to the new list
//            for (int i = 0; i <= s.length(); ++i) {
//                String ps = new StringBuffer(s).insert(i, c).toString();
//                res.add(ps);
//            }
//        }
//        return res;
//    }

//
//    Combinations
//
//    private static void comb2(String prefix, String s) {
//        System.out.println(prefix);
//        for (int i = 0; i < s.length(); i++)
//            comb2(prefix + s.charAt(i), s.substring(i + 1));
//    }
