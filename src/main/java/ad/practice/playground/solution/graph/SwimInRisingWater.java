package ad.practice.playground.solution.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater{

    public static void main(String[]a){
        int [][] grid ={{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(swimInWater(grid));
    }

    public static int swimInWater(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int [][] dist = new int[n][m];
        for(var t : dist) Arrays.fill(t, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        //dist[0][0] = 0;
        pq.offer(new int[]{grid[0][0],0,0});
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while (! pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[1];
            int y = curr[2];
            int d = curr[0];
            for(int i = 0; i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                  int newD = Math.max(d, grid[newX][newY]);
                  if (newD < dist[newX][newY]){
                      dist[newX][newY] = newD;
                      pq.offer(new int[]{newD, newX, newY});
                  }
                }
            }

        }
        return dist[n-1][m-1] == Integer.MAX_VALUE ? 0 : dist[n-1][m-1];
    }
}

/*You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

 */