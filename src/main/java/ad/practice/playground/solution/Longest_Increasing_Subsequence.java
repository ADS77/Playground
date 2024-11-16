package ad.practice.playground.solution;

public class Longest_Increasing_Subsequence {
    public  static void lengthOfLIS(int[] nums) {
        int n = nums.length;
        int diff = 0;
        int ans = 1;
        for(int i = 1;i<n;i++){
            int localAns = 1;
            for(int j = i+1; j<n;j++){
                if(nums[j] - nums[i] > diff){
                    diff = nums[j] - nums[i];
                    localAns++;
                }
            }
            ans = Math.max(localAns, ans);
        }
        System.out.println(ans);

    }
}
