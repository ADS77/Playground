package ad.practice.playground.solution;

import java.util.Arrays;

public class Rotate_Image {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i < n; i++){
            for (int j = i + 1 ; j < m;j++ ){
                if(i != j){
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for (int[] ints : matrix) reverse(ints);
        System.out.println(Arrays.deepToString(matrix));
    }
    private static void reverse(int [] matrix){
        int left = 0;
        int right = matrix.length-1;
        while (left < right){
            int tmp = matrix[right];
            matrix[right] = matrix[left];
            matrix[left] = tmp;
            left++;
            right--;
        }
    }
}
