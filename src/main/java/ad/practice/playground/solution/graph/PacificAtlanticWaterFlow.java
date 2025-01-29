package ad.practice.playground.solution.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args){
        int [][] h = { {1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(h));
    }

    public  static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ;i < row;i ++){
            for(int j = 0; j < col; j++){
                boolean atlantic  = isReachableAtlantic(i, j, heights, new boolean [row][col]);
                boolean pacific = isReachablePacific(i, j, heights, new boolean [row][col]);
                if(atlantic && pacific){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }

    private static boolean isReachableAtlantic(int i, int j,int[][] heights, boolean[][] vis){
        int n = heights.length;
        int m = heights[0].length;
        if(i < 0 || j < 0 || i > heights.length || j > heights[0].length) return false;
        if(vis[i][j]) return false;
        if(i == n - 1 || j == m-1) return true;
        vis[i][j] = true;
        int [] dx = {0,-1,0,1};
        int [] dy = {1,0,-1,0};
        for(int t = 0; t < 4; t++){
            int newI = i + dx[t];
            int newJ = j + dy[t];
            if(newI >= 0 && newI < n && newJ >=0 && newJ < m && !vis[newI][newJ] && heights[newI][newJ] <= heights[i][j]){
                if(isReachableAtlantic(newI, newJ, heights, vis)){
                     return  true;
                }
            }
        }
        return  false;
    }

    private static boolean isReachablePacific(int i, int j, int[][] heights, boolean[][] vis){
        int n = heights.length;
        int m = heights[0].length;
        if(i < 0 || j < 0 || i > heights.length || j > heights[0].length) return false;
        if(vis[i][j]) return false;
        if(i == 0 || j == 0) return true;
        vis[i][j] = true;
        int [] dx = {0,-1,0,1};
        int [] dy = {1,0,-1,0};
        for(int t = 0; t<4; t++){
            int newI = i + dx[t];
            int newJ = j + dy[t];
            if(newI < n && newJ < m && !vis[newI][newJ] && heights[newI][newJ] <= heights[i][j]){
                if(isReachablePacific(newI, newJ, heights, vis)){
                     return true;
                }
            }
        }
        return false;
    }
}
