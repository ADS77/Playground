package ad.practice.playground.solution.string;

public class ZigzagConversion {
    public static void main(String[]a){
        String t = "PA";
        System.out.println(convert(t, 1));
    }

    public static String convert(String s, int numRows) {
        int n = s.length();
        int col = 0;
        StringBuilder ans = new StringBuilder();
        while(n > 0){
            if(n <= numRows){
                col ++;
                n--;
            }
            if (n- numRows > 0) {
                col++;
                n -= numRows;
            }
            else if(n-(numRows-2) >= 0){
                col += (numRows-2);
                n -= (numRows-2);
            }
        }
        Character[][] space = new Character[numRows][col];
        int pos = 0;
        int [] A = new int[3];
        A = movedown(0,0, numRows,s, pos, space);
        int [] B = new int[3];
        B = movediagonal(A[0]-1,A[1]+1,s,A[2], space);
        pos = B[2];
       while (pos < s.length()){
           A = movedown(B[0] -1, B[1]+1, numRows, s,B[2],space);
           B = movediagonal(A[0]-1, A[1]+1, s, A[2],space);
           pos = B[2];

       }
       for(int i = 0 ; i< numRows; i++){
           for(int j = 0 ;j < col;j++){
               if(space[i][j] != null){
                   ans.append(space[i][j]);
               }
           }
       }
       return ans.toString();

    }

    private static int[] movediagonal(int i, int j, String s, int pos, Character[][] space) {
        while (pos < s.length() && i >= 1){
            space[i][j] = s.charAt(pos++);
            i--;
            j++;
        }
        return new int[]{i+1,j-1,pos};
    }

    private static int[] movedown(int i, int j, int numRows, String s, int pos, Character[][] space) {
        while(pos < s.length() && i < numRows){
            space[i][j] = s.charAt(pos++);
            i++;
        }
        return new int[]{i-1,j,pos};
    }
}
