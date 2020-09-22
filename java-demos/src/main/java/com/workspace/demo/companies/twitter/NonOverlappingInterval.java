package com.workspace.demo.companies.twitter;

import java.util.LinkedList;
import java.util.List;

public class NonOverlappingInterval {

    private static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> output = new LinkedList();
        int i = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][0] < newInterval[0])
                output.add(intervals[i]);
            else break;
        }

        if (output.isEmpty() || ((LinkedList<int[]>) output).getLast()[1] < newInterval[0])
            output.add(newInterval);
        else {
            int[] last = ((LinkedList<int[]>) output).removeLast();
            if (last[1] >=newInterval[0])
                output.add(new int[]{last[0], Math.max(last[1], newInterval[1])});
        }


        while (i < intervals.length) {
            int[] last = ((LinkedList<int[]>) output).getLast();
            if (last[1] >=intervals[i][0]) {
                ((LinkedList<int[]>) output).removeLast();
                last[1] = Math.max(intervals[i][1], last[1]);
                output.add(last);
            } else output.add(intervals[i]);
            i++;

        }
        return output.toArray(new int[output.size()][2]);
    }

    /*

    Input : Set : [1, 2], [3, 5], [6, 7], [8, 10], [12, 16]
        New Interval : [4, 9]
Output : [1, 2], [3, 10], [12, 16]
     */

    public static void main(String[] args) {

//        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
//        int[] newInterval = new int[]{2, 5};


        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};

        int[][] res = insert(intervals, newInterval);

        for (int i = 0; i < res.length; i++)
            System.out.println(res[i][0] + "," + res[i][1]);
    }
}
