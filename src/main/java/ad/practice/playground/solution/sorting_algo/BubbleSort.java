package ad.practice.playground.solution.sorting_algo;

import java.util.Arrays;

public class BubbleSort {
    public static int[] sort(int[] A){
        int n = A.length;
        for(int i = 0;i<n-1;i++){
            for (int j = 0; j < n-i-1 ;j++){
               if(A[j] > A[j+1]){
                   int tmp = A[j+1];
                   A[j+1] = A[j];
                   A[j] = tmp;
               }
            }
        }
        System.out.println(Arrays.toString(A));
        return  A;
    }
}
