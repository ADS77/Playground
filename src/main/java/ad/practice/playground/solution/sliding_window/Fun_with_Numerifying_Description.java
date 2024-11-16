package ad.practice.playground.solution.sliding_window;

import java.util.*;

public class Fun_with_Numerifying_Description {
    public  int solve(String s){
        int n = s.length();
        int ans = 0;
        Map<String, Integer> dictionary = dictionary();
        Queue<Integer> q = new LinkedList<>();

        int a = 0;
        int b = 0;
        String operator = "";
        int left = 0;
        int right = 4;
        StringBuilder sb = new StringBuilder(s.substring(0,4));
        while(left + 5 <= n && right < n){
            String tmp = s.substring(left,right);
            if(dictionary.containsKey(tmp)){
                if(isNum(tmp,dictionary)){
                    q.offer(dictionary.get(tmp));
                }
                else {
                    if(isOperator(tmp,dictionary)){
                        int num = 1;
                        while (! q.isEmpty()){
                            num = num*10 + q.poll();
                        }
                    }
                    String t = testfor4(tmp, dictionary,q);
                    if (isNum(t,dictionary)){
                        q.offer(dictionary.get(t));
                    }
                    t = testfor3(tmp, dictionary,q);
                    if(isNum(t, dictionary)){
                        q.offer(dictionary.get(t));
                    }
                }
            }
            left++;
            right++;

        }
        ans +=  evaluate( a, b, operator);

        return ans ;
    }

    private String testfor4(String s, Map<String , Integer> mp, Queue<Integer> q){
        int n = s.length();
        String st1 = s.substring(0,n-2);
        String st2 = s.substring(1,n-1);
        if(mp.containsKey(st1)) return  st1;
        else if(mp.containsKey(st2)) return st2;
        return "";
    }
    private String testfor3(String s, Map<String , Integer> mp, Queue<Integer> q){
        String st1 = s.substring(0,2);
        String st2 = s.substring(1,3);
        String st3 = s.substring(2,4);
        if(mp.containsKey(st1)) return st1;
        else if(mp.containsKey(st2)) return st2;
        else if (mp.containsKey(st3)) return  st3;
        return "";
    }

   private boolean isOperator(String s,Map<String, Integer>mp){
        return mp.get(s) < 0;
   }
    private boolean isNum(String s,Map<String, Integer>mp){
        return mp.get(s) >= 0 ;
    }
    private Map<String,Integer> dictionary(){
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
    private int evaluate(int a, int b, String operator){
        return operator.equals("plus") ?  a+b : a-b;
    }

}
