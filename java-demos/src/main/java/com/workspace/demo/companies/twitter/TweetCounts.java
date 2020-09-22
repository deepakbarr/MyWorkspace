package com.workspace.demo.companies.twitter;

import java.util.*;

public class TweetCounts {

    Map<String, TreeSet<Integer>> tweets = new HashMap<>();

    private void recordTweet(String tweetName, int time) {
        if (!tweets.containsKey(tweetName))
            tweets.put(tweetName, new TreeSet<>());

        tweets.get(tweetName).add(time);
    }

    private List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int timeInterval = getTimeInterval(freq);

        int num_intervals = (endTime - startTime) / timeInterval;

        if ((endTime - startTime) % timeInterval > 0)
            num_intervals++;

        Integer[] counts = new Integer[num_intervals];


        for (int l : tweets.get(tweetName)) {

            if (l >= startTime && l <= endTime) {
                int interval = (l - startTime) / timeInterval;

                counts[interval]++;
            }
        }
        return Arrays.asList(new Integer[0]);
    }


    private int getTimeInterval(String freq) {
        switch (freq) {
            case "day":
                return 24 * 3600;
            case "hour":
                return 3600;
            case "minute":
                return 60;
            default:
                throw new RuntimeException("Invalid freq " + freq);
        }
    }

    public static void main(String[] args) {


        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);

        System.out.println(tweetCounts.getTweetCountsPerFrequency("minute","tweet3", 0 , 59));


    }
}
