package ad.practice.playground.solution.coding_challenge_by_JohnCricket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EgyptianFraction {
    private static Logger logger = LoggerFactory.getLogger(EgyptianFraction.class);

    public static void main (String[] args){
        List<int[]> ls = new ArrayList<>();
        ls = solve(15,95,ls);
        for (int[] t: ls)logger.info(Arrays.toString(t));
    }

    public static List<int[]> solve(int x, int y, List<int[]> ls){
        if(x == 0 || y == 0) return ls;

        else if(y % x == 0){
            ls.add(new int[] {1, y/x});
            return ls;
        }
        else if( y % x != 0){
            int n = y/x+1;
            ls.add(new int[]{1,n});
            solve(n*x-y, n*y,ls);
        }
        return ls;
    }
}
