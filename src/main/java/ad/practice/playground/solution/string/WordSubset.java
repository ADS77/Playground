package ad.practice.playground.solution.string;

import ad.practice.playground.solution.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubset {
    public static void main(String[] a){
        String[] w1 = {"amazon","apple","facebook","google","leetcode"};
        String[] w2 = {"lo", "eo"};
        System.out.println(Solution.wordSubsets(w1,w2));
    }

    static class Solution {
        public static List<String> wordSubsets(String[] w1, String[] w2) {
            Map<String, int[]> fr1 = new HashMap<>();
            int[] fr2 = new int[26];
            for(String t : w1){
                fr1.putIfAbsent(t, findFreq(t));
            }
            for(String  t : w2){
                fr2 = findFreq(t, fr2);
            }
            List<String> ans = new ArrayList<>();
            for(String s : w1){
                if(ok(s, fr1,fr2)){
                    ans.add(s);
                }
            }
            return ans;
        }
        private static boolean ok (String s, Map<String, int[]> fr1, int[] fr2){
            int[] fr = fr1.get(s);
            for(int i = 0; i < 26; i++){
                if((fr2[i] > fr[i])) return false;
            }
            return true;
        }
        private static int[] findFreq(String s, int[] globalFreq){
            int[] localFreq = new int[26];
            for(char c : s.toCharArray()){
                int index = c-'a';
                localFreq[index]++;
                globalFreq[index] = Math.max(globalFreq[index], localFreq[index]);
            }
            return globalFreq;
        }
        private static int[] findFreq(String s){
            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c-'a']++;
            }
            return freq;
        }
    }
}
