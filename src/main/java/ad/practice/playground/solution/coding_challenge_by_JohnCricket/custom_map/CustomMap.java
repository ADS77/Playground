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
