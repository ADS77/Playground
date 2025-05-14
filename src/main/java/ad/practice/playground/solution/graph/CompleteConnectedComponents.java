package ad.practice.playground.solution.graph;

import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

public class CompleteConnectedComponents {
    public static void main(String[]a){
        int n = 6;
        int [][] edges = {{0,1},{0,2},{1,2},{3,4}};
        System.out.println(noOfccc(n, edges));
    }

    public static int noOfccc(int n, int[][] edges){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n;i++)graph.add(new ArrayList<>());
        int[] vis = new int[n];
        for(var t : edges){
            graph.get(t[0]).add(t[1]);
            graph.get(t[1]).add(t[0]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                int [] count = new int[2];
                dfs(i,graph, vis, count);
                int v = count[0];
                int e = count[1];
                if(e == (v*(v-1))){
                    ans++;
                }
            }
        }

        return  ans;
    }

    public static void dfs(int node, List<List<Integer>> graph,int[]vis,int[]count){
        vis[node] = 1;
        count[0]++;
        count[1] += graph.get(node).size();
        for(int child : graph.get(node)){
            if(vis[child] == 0){
                dfs(child, graph, vis,count);
            }
        }

    }
}

/*
You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.
*/
