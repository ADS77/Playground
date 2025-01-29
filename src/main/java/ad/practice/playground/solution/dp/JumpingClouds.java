package ad.practice.playground.solution.dp;

import java.util.Arrays;
import java.util.List;

public class JumpingClouds {
    public static void main(String[] a){
        List<Integer> ls = Arrays.asList(0, 0, 1, 0,0 ,1 ,0);
        System.out.println(jumpingOnClouds(ls));
    }
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here

        int n = c.size();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //dp[1] = (c.get(1) == 0 ? 1 :Integer.MAX_VALUE);
        for(int i = 0; i < n-2 ; i++){
            if(c.get(i) == 0){
                if(c.get(i+1)== 0){
                    dp[i+1] = Math.min(dp[i]+1, dp[i+1]);
                }
                if(c.get(i+2) == 0){
                    dp[i+2] = Math.min(dp[i]+1, dp[i+2]);
                }
            }
        }
        return dp[n-1];

    }

}

