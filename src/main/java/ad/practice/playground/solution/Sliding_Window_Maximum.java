package ad.practice.playground.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Sliding_Window_Maximum {
    public static  int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int ansi = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i<n;i++){
            if(! dq.isEmpty() && dq.peekLast() == i-k){
                dq.pollLast();
            }
            while(! dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i >= k-1){
                ans[ansi++] = nums[dq.peekFirst()];
            }

        }
        return  ans;
    }
}
