package ad.practice.playground.solution.sorting_algo;

import java.util.Arrays;

public class InsertionSort {
    public static int [] sort(int[] A){
        for(int i =1; i<A.length;i++){
            int j = i;
            int entry = A[j];
            while(j > 0 && entry < A[j - 1]){
                // check any previous value is grater than entry.
                // if found, take entry to its correct insertion position
                // shift every element grater than entry one step right and finally insert entry to correct position
                A[j] = A[j-1];
                j--;
            }
            A[j] = entry;
        }
        System.out.println(Arrays.toString(A));
        return A;
    }
}
