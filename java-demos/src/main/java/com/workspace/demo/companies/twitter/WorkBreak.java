package com.workspace.demo.companies.twitter;

import java.util.Arrays;
import java.util.List;

public class WorkBreak {
    static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] flag = new Boolean[s.length()];
        return wordBreakUtil(s, wordDict, flag, 0);
    }

    static boolean wordBreakUtil(String word, List<String> wordDict, Boolean[] flag, int start) {

        if (word.length() == 0) {
            flag[start] = true;
            return true;
        }

        if (flag[start] != null)
            return flag[start];

        if (wordDict.contains(word)) {
            flag[start] = true;
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            if (wordDict.contains(word.substring(0, i))
                    && wordBreakUtil(word.substring(i, word.length()), wordDict, flag, i))
                return true;

        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("workBreak = " + wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));

    }
}
