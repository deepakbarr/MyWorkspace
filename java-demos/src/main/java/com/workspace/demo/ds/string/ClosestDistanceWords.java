package com.workspace.demo.ds.string;

import java.util.List;

/**
 * Created by deepak on 12/1/14.
 */
public class ClosestDistanceWords {

    public int findDistance(String file, String w1, String w2) {
        String[] words = file.split(" ");

        int w1pos = -1, w2pos = -1;
        int minDist = Integer.MAX_VALUE;
        int dist;

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(w1)) {
                w1pos = i;
                if (w2pos != -1) {
                    dist = Math.abs(w2pos - w1pos);
                    if (dist < minDist)
                        minDist = dist;
                }
            } else if (words[i].equals(w2)) {
                w2pos = i;
                if (w1pos != -1) {
                    dist = Math.abs(w2pos - w1pos);
                    if (dist < minDist)
                        minDist = dist;
                }
            }

        }

        return minDist;
    }

    public static void main(String[] args) {

        String file = "this is a demo file is demo this";
        int d = new ClosestDistanceWords().findDistance(file, "file", "this");
        System.out.println("d = " + d);
    }
}
