package ad.practice.playground.solution.coding_challenge_by_JohnCricket;

public class GridPathCount {

    public static void main(String[]args){
        System.out.println(solve(5,6));
    }

    public static int solve(int n, int m){
        int[][] ways = new int[n][m];
        for(int i = 1; i< m ; i++)ways[0][i] = 1;
        for(int i = 1; i< n ;i++) ways[i][0] = 1;
        for(int i = 1; i < n; i++){
            for (int j = 1; j<m;j++){
                ways[i][j] += ways[i-1][j] + ways[i][j-1];
            }
        }
        return ways[n-1][m-1];
    }
}
/*Problem Statement :
There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and getting to the bottom-right corner.
You can only move right or down.
For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:
Right, then down
Down, then right
Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.
*/