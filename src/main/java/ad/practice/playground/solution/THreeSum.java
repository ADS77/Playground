package ad.practice.playground.solution;

import java.util.*;

public class THreeSum {

    public static void  main (String[]a){
        int [] A  = new int[]{0,0,0,0,0,0,0,0,};
        System.out.println(threeSum(A));
    }
    public static  List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        int n = nums.length;
        for(int i  = 0; i<n-2; i++){
            int curr = nums[i];
            int left = i+1;
            int right = n-1;
            while(left < right-1){
                if(nums[left] + nums[right] > -1*curr){
                    right--;
                }
                if(nums[left] + nums[right] < -1*curr){
                    left++;
                }
                else if (nums[left] + nums[right] == -1*curr){
                    ans.add(Arrays.asList(nums[i],nums[left], nums[right]));
                    break;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
