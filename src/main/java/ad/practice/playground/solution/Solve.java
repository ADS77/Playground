package ad.practice.playground.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Solve {
    private static Logger logger = LoggerFactory.getLogger(Solve.class);
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;
        Map<String, Integer> mp = new HashMap<>();
        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i< wordLength;i++){
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> found = new HashMap<>();
            while(right + wordLength <= s.length()){
                String currentWord = s.substring(right, right+wordLength);
                right += wordLength;
                if(mp.containsKey(currentWord)){
                    found.put(currentWord,found.getOrDefault(currentWord,0)+1);
                    count++;

                    while (found.get(currentWord) > mp.get(currentWord)){
                        String leftWord = s.substring(left, left +wordLength);
                        found.put(leftWord, found.get(leftWord)-1);
                        left += wordLength;
                        count--;
                    }
                    if(count == totalWords){
                        result.add(left);
                    }
                }
                else {
                    found.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }


    public static String minWindow(String s, String t){
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: t.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> seen = new HashMap<>();
        int count = 0;
        int[] ans = {-1,0,0};
        while (right < s.length()){
            char c = s.charAt(right);
            seen.put(c,seen.getOrDefault(c,0)+1);
            if(mp.containsKey(c) && Objects.equals(mp.get(c), seen.get(c))){
                count++;
            }
            while (left <= right && count == mp.size()){
                c = s.charAt(left);
                if(ans[0] == -1 || ans[0] > right-left+1){
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }
                seen.put(c,seen.get(c)-1);
                if(mp.containsKey(c) && seen.get(c) < mp.get(c)){
                    count--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }


}
