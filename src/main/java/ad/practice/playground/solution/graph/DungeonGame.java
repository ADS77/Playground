package ad.practice.playground.solution.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DungeonGame {

    public static void main(String[] a){
        for (String t : a){
            System.out.println(t);
        }
        int [][] g = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(findMinHealth(g));
    }


    public static int findMinHealth(int [][]dungeon){
        int n = dungeon.length;
        int m = dungeon[0].length;
        int initHealth = 0;
        int[][] health = new int[n][m];
        //for(var t : health) Arrays.fill(t, Integer.MAX_VALUE);
        health[n-1][m-1] = dungeon[n-1][m-1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0] - a[0]);
        pq.offer(new int[]{health[n-1][m-1], n-1,m-1});
        int [] dx = {-1,0};
        int [] dy = {0,-1};
        while (! pq.isEmpty()){
            int [] curr = pq.poll();
            int x = curr[1];
            int y = curr[2];
            int currHealth = curr[0];
            for(int i = 0; i < 2; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < n && newX >= 0 && newY < m && newY >= 0){
                    if(newX == n-1 && newY == m-1  ) continue;;
                    if(dungeon[newX][newY] - currHealth >= 0){
                        health[newX][newY] = 0;
                    }
                    else{
                        health[newX][newY] = currHealth + dungeon[newX][newY];
                    }
                    pq.offer(new int[]{health[newX][newY], newX, newY});
                }

            }

        }

        return 1-health[0][0];
    }
}
