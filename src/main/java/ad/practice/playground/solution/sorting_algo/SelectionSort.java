package ad.practice.playground.solution.sorting_algo;

import java.util.Arrays;

public class SelectionSort {
    public  static int[] sort(int [] A){
        int min = Integer.MAX_VALUE;
        int n = A.length;
        for(int i = 0;i<A.length;i++){
            min = A[i];
            int j = i+1;
            while (j < n){
                // check exixtance of smaller element than min at right portion.
                // If exits swap them and continue for next smaller one
                if(A[j] < min){
                    int tmp = A[j];
                    A[i] = A[j];
                    A[j] = min;
                    min = tmp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(A));
        return A;
    }
}
