package ad.practice.playground.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int [] curr = intervals[0];
        List<int[]> ans = new ArrayList<>();
        for(int i = 1; i< intervals.length; i++){
            int [] t = intervals[i];
            if(t[0] <= curr[1]){
                curr[1] = Math.max(t[1], curr[1]);
            }
            else {
                ans.add(curr);
                curr = t;
            }
        }
        ans.add(curr);
        System.out.println(Arrays.deepToString(ans.toArray()));
        return ans.toArray(new int[ans.size()][2]);
    }
}
