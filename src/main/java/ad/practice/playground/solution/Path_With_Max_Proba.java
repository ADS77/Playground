package ad.practice.playground.solution;

import java.util.*;

public class Path_With_Max_Proba {
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node){
        double [] maxProba = new double[n];
        Arrays.fill(maxProba, 0);
        maxProba[start_node] = 1.0;
        Map<Integer, List<double[]>> graph = new HashMap<>();
        int i = 0;
        for(int[] t : edges){
            int u = t[0];
            int v = t[1];
            double proba = succProb[i++];
            if(!graph.containsKey(u)){
                graph.put(u, new ArrayList<>());
            }
            if( !graph.containsKey(v)){
                graph.put(v, new ArrayList<>());
            }
            List<double[]> ls = graph.get(u);
            ls.add(new double[]{v, proba});
            graph.put(u,ls);
            ls = graph.get(v);
            ls.add(new double[]{u, proba});
            graph.put(v, ls);

        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start_node, maxProba[start_node]});
        while (! pq.isEmpty()){
            double [] curr = pq.poll();
            int node = (int)curr[0];
            double proba = curr[1];
            if(node == end_node){
                return proba;
            }
        if(graph.containsKey(node)){
            for(double[] t : graph.get(node)){
                int neighbor = (int)t[0];
                double newProba = proba * t[1];
                if(newProba > maxProba[neighbor]){
                    maxProba[neighbor] = newProba;
                    pq.offer(new double[]{neighbor, newProba});
                }
            }
        }
        }
        return maxProba[end_node];
}


}
