package ad.practice.playground.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoint {

    private static Logger logger = LoggerFactory.getLogger(KClosestPoint.class);
    public static class Pair{
        public double first;
        public double second;
        public Pair(double f, double s){
            this.first = f;
            this.second = s;
        }
    }

    public static class CustomPair{
        double dist;
        Pair pair;
        public CustomPair(double d, Pair p){
            this.dist = d;
            this.pair = p;
        }
    }
    public static void main(String[] args){

        List<Pair> ls = new ArrayList<>();
        ls.add(new Pair(0,0));
        ls.add(new Pair(5,4));
        ls.add(new Pair(3,1));
        List<Pair> ans = solve(ls, 2, 1,2);

        for (Pair p : ans){
            logger.info(p.first + ": "+  p.second);
        }
    }

    public  static List<Pair> solve(List<Pair> ls, int k, double x, double y){
        PriorityQueue<CustomPair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dist, a.dist));
        for(Pair  p : ls){
            double dist = calculateDist(p, x, y);
            pq.offer(new CustomPair(dist, p));
            if (pq.size() > k)
                pq.poll();
        }

      List<Pair> ans  = new ArrayList<>();
        while (! pq.isEmpty()){
            ans.add(pq.poll().pair);
        }
        return ans;
    }

    private static double calculateDist(Pair p, double x, double y) {
        return Math.sqrt(Math.pow(Math.abs(x - p.first), 2) + Math.pow(Math.abs(y - p.second), 2));
    }
}

//problem statement :
/*
Given a list of points, a central point, and an integer k, find the nearest k points from the central point.
For example, given the list of points [(0, 0), (5, 4), (3, 1)], the central point (1, 2), and k = 2, return [(0, 0), (3, 1)].
*/
