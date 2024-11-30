package ad.practice.playground.solution.graph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllBridges {
    private static final Logger logger = LoggerFactory.getLogger(FindAllBridges.class);
    static int timer = 1;

    public static void main(String [] args){
        List<List<Integer>> network = new ArrayList<>();
        network.add(Arrays.asList(0,1));
//        network.add(Arrays.asList(1,2));
//        network.add(Arrays.asList(2,0));
//        network.add(Arrays.asList(1,3));
        var res = findAllBridges(2, network);
        for (List<Integer> t : res){
            logger.info(t.toString());

        }

    }


    public static List<List<Integer>> findAllBridges(int n, List<List<Integer>> network){
       List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();
        for(int i = 0 ;i< n ; i++){
            edges.add(new ArrayList<>());
        }
        for (List<Integer> integers : network) {
            edges.get(integers.get(0)).add(integers.get(1));
            edges.get(integers.get(1)).add(integers.get(0));
        }
        boolean[] vis = new boolean[n];
        int[] firstOccurrence = new int[n];
        int[] lowest = new int[n];
        Arrays.fill(lowest, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, firstOccurrence, lowest, edges, bridges);
            }
        }
        return bridges;
    }

    private static void dfs(int node, int parent,boolean[] vis, int[] firstOccurrence, int[] lowest, List<List<Integer>> adj, List<List<Integer>> bridges ){
        vis[node] = true;
        firstOccurrence[node] = timer;
        lowest[node] = timer;
        timer++;
        List<Integer> edges = adj.get(node);
        for(int edge : edges){
            if(edge == parent)continue;
            if (! vis[edge]){
                dfs(edge, node, vis, firstOccurrence, lowest, adj, bridges);
                lowest[node] = Math.min(lowest[edge], lowest[node]);
                if(lowest[edge] > firstOccurrence[node]){
                    bridges.add(Arrays.asList(node, edge));
                }
            }
            else {
            lowest[node] = Math.min(lowest[node], lowest[edge]);
            }
        }
    }
}
