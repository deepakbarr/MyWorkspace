package com.app.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by deepak.barr on 24/2/15.
 */
public enum QuoteManager {
    INSTANCE;
    private List<String> quoteList = new ArrayList<>();

    public String insertQuote(String quote) {
        try {
            quoteList.add(quote);
            return "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
            return "FAILED : " + e.getMessage();
        }
    }

    public String getRandomQuote() {

        int size = quoteList.size();

        if (size == 0)
            return "NO quotes !!";
        Random rand = new Random();
        int idx = rand.nextInt(size);
        return quoteList.get(idx);
    }
}
