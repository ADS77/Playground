package ad.practice.playground.solution.binary_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindNthRoot {

    public static void main(String[] args){
        //System.out.println("root = " + getRoot(9654,5));
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(1,3,5));
        ls.add(Arrays.asList(2,6,9));
        ls.add(Arrays.asList(3,6,9));
        System.out.println(findMedian(ls));
    }

    public static  double getRoot(double x, int n){
        double low = 0;
        double high = 0;
        double epsilon = 0.0000001;
        if(x <= 1 && x >= 0){
            low = 0;
            high = x;
        }
        else {
            low = 1;
            high = x;
        }
        double guess = low + (high-low)/2;
        while (Math.abs(Math.pow(guess, n) - x) >= epsilon){
            if (Math.pow(guess, n) > x){
                high = guess;
            }
            else if (Math.pow(guess,n) < x){
                low = guess;
            }
            else return guess;
            guess = low + (high-low)/2;

        }
        return guess;
    }

    public static int findMedian(List<List<Integer>> A) {
        for(List<Integer> l : A){
            for(Integer t : l){
                A.get(0).add(t);
            }
            Collections.sort(A.get(0));
        }
        return A.get(0).get(A.get(0).size()/2);
    }

}
