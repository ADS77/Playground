package ad.practice.playground.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Set_Matrix_Zero {
    private static final Logger logger = LoggerFactory.getLogger(Set_Matrix_Zero.class);

    public static int[][] setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int  r = 0 , c = 0;
        for(int i = 0; i < col; i++){
            if(matrix[0][i] == 0) r = 1;
        }
        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0) c = 1;
        }
        for(int i = 1; i< row; i++){
            for(int j = 1; j<col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        logger.info("marked : " + Arrays.deepToString(matrix));
        for(int i  = 1 ;i < row; i++){
            if(matrix[i][0] == 0){
                Arrays.fill(matrix[i], 0);
            }
        }
        logger.info("setted Row : " + Arrays.deepToString(matrix));

        for(int j  = 1 ; j < col; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < row; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        logger.info("setted col : "+ Arrays.deepToString(matrix));

        if(r == 1)Arrays.fill(matrix[0], 0);
        if(c == 1){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
        return  matrix;
    }
}
