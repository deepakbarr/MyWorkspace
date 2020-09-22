package com.workspace.demo.companies.twitter;

import java.util.*;

public class RandomizedSet {

    private Random rand;
    private List<Integer> list;
    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        rand = new Random();
        list = new ArrayList();
        map = new HashMap();

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int idx = map.get(val);

        int last = list.get(list.size() - 1);
        list.set(idx, last);
        list.remove(list.size() - 1);
        map.remove(val);
        map.put(last, idx);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
