package ad.practice.playground.solution.sliding_window;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ExabytingCodingTest {
    public static int solve(String s){
        Map<String , Integer> dictionary = dictionary();
        int n = s.length();
        int left = 0;
        int ans = 0;
        for(int i = 0; i< n && left < n;i++){
            int a = 0;
            int b = 0;
            char c = s.charAt(i);
            String operator = "";
            if(c == 'm' || c == 'p'){
                a = getNum(s.substring(left,i-1), dictionary);
                if(c == 'm') {
                    i = i + 5;
                    operator = "-";
                }
                else {
                    i += 4;
                    operator = "+";
                }
                left = i;
                for(int k = i;k < s.length();k++){
                    c = s.charAt(k);
                    if(c == 'm' || c == 'p'){
                        b = getNum(s.substring(left,k-1), dictionary);
                        if(c == 'm') k = k+5;
                        else k += 4;
                        left = k;
                        i = k;
                    }
                }
            }

        }
        return  ans;
    }

    private static int getNum(String s, Map<String , Integer> mp){
        Queue<Integer> q = new LinkedList<>();
        int right = 2;
        String t = "";
        for(int i = 0; i < s.length();i++){
            right = i+2;
            if(right < s.length()){
                t = s.substring(i, right);
                if(mp.containsKey(t)){
                    q.offer(mp.get(t));
                    i = right+1;
                }
                else {
                    right++;
                    if(right < s.length()){
                        t = s.substring(i, right);
                        if(mp.containsKey(t)){
                            q.offer(mp.get(t));
                            i = right+1;
                        }
                        else {
                            right++;
                            if(right < s.length()){
                                t = s.substring(i, right);
                                if(mp.containsKey(t)){
                                    q.offer(mp.get(t));
                                    i = right+1;
                                }
                            }
                        }
                    }
                }
            }

        }
        int ans = 0;
        while(! q.isEmpty()){
            ans = ans * 10 + q.poll();
        }
        return  ans;
    }
    private static Map<String,Integer> dictionary(){
        Map<String,Integer> mp = new HashMap<>();
        mp.put("one",1);
        mp.put("two",2);
        mp.put("three",3);
        mp.put("four",4);
        mp.put("five",5);
        mp.put("six",6);
        mp.put("seven",7);
        mp.put("eight",8);
        mp.put("nine",9);
        mp.put("zero",0);
        mp.put("minus",-1);
        mp.put("plus",-2);
        return  mp;
    }
}
