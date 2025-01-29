package ad.practice.playground.solution.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinEffortPath {


    public static void main(String[] args){
        int [][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1}};
        System.out.println(minEffort(heights));
    }
    public static int minEffort(int [][] heights){
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] t : dist){
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            return a[0] - b[0];
        });
        pq.offer(new int[]{0, 0, 0});
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while (! pq.isEmpty()){
            int[] curr = pq.poll();
            int x = curr[1];
            int y = curr[2];
            int currDist = curr[0];
            for(int i = 0; i<4;i++){
                int newX = x+dx[i];
                int newY = y+dy[i];
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                    int newDist = Math.max(currDist,Math.abs(heights[newX][newY] - heights[x][y]));
                    if(newDist < dist[newX][newY]){
                        dist[newX][newY] = newDist;
                        pq.offer(new int[]{newDist, newX, newY});
                    }
                }
            }

        }
        return dist[n-1][m-1];
    }
}
