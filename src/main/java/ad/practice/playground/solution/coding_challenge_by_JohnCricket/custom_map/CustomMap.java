package ad.practice.playground.solution.coding_challenge_by_JohnCricket.custom_map;

import java.util.*;

public class CustomMap {
    public static class ValueBean{
        private int time;
        private int value;

        public ValueBean(int value, int time){
            this.time = time;
            this.value = value;
        }
    }

    public static class Entry{
        List<ValueBean> valueBeans;
        private boolean isSorted;

        public Entry(){
            valueBeans = new ArrayList<>();
        }
    }

    private Map<String, Entry> mp;

    public CustomMap(){
        mp = new HashMap<>();
    }

    public void set(String key, int value,int time){
        Entry entry = mp.computeIfAbsent(key, e -> new Entry());
        entry.valueBeans.add(new ValueBean(value, time));
        entry.isSorted = false;
    }

    public Integer get(String key, int time){
        int res = 0;
        Entry entry = mp.get(key);
        if(entry == null || entry.valueBeans == null) return null;
        if(! entry.isSorted){
            entry.valueBeans.sort(Comparator.comparingInt(p -> p.time));
            entry.isSorted = true;
        }
        res = findMostRecentlyUpdatedValue(entry.valueBeans, time);
        return res != -1 ? res : null;
    }

    private int findMostRecentlyUpdatedValue(List<ValueBean> valueBeans, int time){
        int val = -1;
        int low = 0;
        int hi = valueBeans.size() - 1;
        while (low <= hi){
            int mid = low + (hi - low)/2;
            ValueBean midVal = valueBeans.get(mid);
            if(midVal.time == time) return midVal.value;
            else if (midVal.time < time){
                val = midVal.value;
                low = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return val;

    }
}

/*
Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.

It should contain the following methods:

set(key, value, time): sets key to value for t = time.
get(key, time): gets the key at t = time.
The map should work like this. If we set a key at a particular time, it will maintain that value forever or until it gets set at a later time. In other words, when we get a key at a time, it should return the value that was set for that key set at the most recent time.

Consider the following examples:

d.set(1, 1, 0) # set key 1 to value 1 at time 0
d.set(1, 2, 2) # set key 1 to value 2 at time 2
d.get(1, 1) # get key 1 at time 1 should be 1
d.get(1, 3) # get key 1 at time 3 should be 2
d.set(1, 1, 5) # set key 1 to value 1 at time 5
d.get(1, 0) # get key 1 at time 0 should be null
d.get(1, 10) # get key 1 at time 10 should be 1
d.set(1, 1, 0) # set key 1 to value 1 at time 0
d.set(1, 2, 0) # set key 1 to value 2 at time 0
d.get(1, 0) # get key 1 at time 0 should be 2
*/
