package ad.practice.playground.solution.coding_challenge_by_JohnCricket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlashDividingRegions {
    private static Logger logger = LoggerFactory.getLogger(SlashDividingRegions.class);

    public static void main(String[] args){
        String[][] grid = {
                {"/", "", "", "", "/"},
                {"", "/", "", "/",""},
                {"", "", "/", "", ""},
                {"","", "", "/", ""},
        };
        logger.info("Regions : {}", solve(grid));
    }

    private static int solve(String[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        boolean [][] vis = new boolean[rows][cols];
        int regions = 0;
        for(int i = 0 ; i< rows; i++){
            for(int j = 0; j < cols; j++){
                String c = grid[i][j];
                if(!vis[i][j] && c.isEmpty()){
                    dfs(grid, vis, i, j);
                    regions++;
                }
            }
        }
        return regions;
    }

    private static void dfs(String[][] grid, boolean[][] vis, int i, int j) {
        vis[i][j] = true;
        int rows = grid.length;
        int cols = grid[0].length;
        int [] dx = {0,-1,0,1};
        int [] dy = {1,0,-1,0};
        for(int t = 0 ; t < 4; t++){
            int newI = i + dx[t];
            int newJ = j + dy[t];
            if(newI < rows && newI >= 0 && newJ < cols && newJ >=0 && !vis[newI][newJ] && grid[newI][newJ].isEmpty()){
                dfs(grid, vis, newI, newJ);
            }
        }
    }
}
/*
Problem Statement :
You are given a 2-d matrix where each cell consists of either /, \, or an empty space. Write an algorithm that determines into how many regions the slashes divide the space.

For example, suppose the input for a three-by-six grid is the following:

\    /
 \  /
  \/
Considering the edges of the matrix as boundaries, this divides the grid into three triangles, so you should return 3.
*/