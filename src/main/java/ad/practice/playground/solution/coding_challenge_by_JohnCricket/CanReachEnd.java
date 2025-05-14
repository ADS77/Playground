package ad.practice.playground.solution.coding_challenge_by_JohnCricket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CanReachEnd {

    private static final Logger log = LoggerFactory.getLogger(CanReachEnd.class);

    public static void main(String[]a){
        int[] A = {1,3,1,0,0,1};
        //log.info(String.valueOf(canReachEnd(A)));
        StringBuffer sb = new StringBuffer("Hello");
        //StringBuilder sb = new StringBuilder("Hello");
        System.out.println(sb.capacity()); // 21
        System.out.println(sb.charAt(0)); // H
        sb.append('w');
        System.out.println(sb); // Hellow
        sb.append("orld");
        System.out.println(sb); // Helloworld
        sb.insert(5,':'); // Hello:world
        sb.reverse();
        System.out.println(sb); // dlrow:olleH
    }

    private static boolean canReachEnd(int[]nums){
        int n = nums.length;
        int maxReach = 0;
        for(int i = 0; i< n; i++){
            if(i > maxReach)return false;
            maxReach = Math.max(maxReach, i+nums[i]);
        }
        return true;
    }
}


/*
You are given an array of nonnegative integers. Let's say you start at the beginning of the array and are trying to advance to the end. You can advance at most, the number of steps that you're currently on. Determine whether you can get to the end of the array.

For example, given the array [1, 3, 1, 2, 0, 1], we can go from indices 0 -> 1 -> 3 -> 5, so return true.

Given the array [1, 2, 1, 0, 0], we can't reach the end, so return false.
*/