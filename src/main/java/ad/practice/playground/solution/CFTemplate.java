package ad.practice.playground.solution;

import ad.practice.playground.PlaygroundApplication;
import ad.practice.playground.handler.Handler;
import org.springframework.boot.SpringApplication;

import java.io.*;
import java.util.*;

public class CFTemplate {
    public static class FastIO{
        private BufferedReader br;
        private StringTokenizer st;
        private PrintWriter pw;
        public FastIO(){
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(new BufferedOutputStream(System.out));
        }
        public String next(){
            while (st == null || !st.hasMoreTokens()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.fillInStackTrace();
                }
            }
            return  st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public String nextLine(){
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.fillInStackTrace();
            }
            return  line;
        }

        public void print(Object obj){
            pw.print(obj);
        }

        public void println(Object obj){
            pw.println(obj);
        }

        public void close(){
            pw.close();
        }
    }

    public static void main(String[] args) {
       FastIO io = new FastIO();
       String s = "acbbcac";
       System.out.println(numberOfSubstrings(s));

    }


        public static int[] applyOperations(int[] nums) {
            int n = nums.length;
            int i = 0;
            while(i < n-1){
                if( nums[i] == nums[i+1]){
                    nums[i] *= 2;
                    nums[i+1] = 0;
                }
                i++;
            }
            int left = 0;
            int right = 0;
            while(right < n){
                if(nums[right] != 0){
                    nums[left] = nums[right];
                    left++;
                }
                right++;
            }
            for(i = left+1; i <n;i++){
                nums[i] = 0;
            }
            return nums;
        }


    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int right = 2;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = left;i <= right; i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1);
        }
        int ans = 0;

        while(right < n){
            if(isValid(mp)){
                ans += countInWindow(s.substring(left, right+1));
                ans += (n-right-1);
                char leftChar = s.charAt(left);
                mp.put(leftChar,mp.get(leftChar)-1);
                left++;

            }
            right++;
            if(right == n)break;
            char rightChar = s.charAt(right);
            mp.put(rightChar, mp.getOrDefault(rightChar,0)+1);
        }
        return ans;

    }

    private static int countInWindow(String s){
        int count = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(int i = s.length()-1; i >=0; i--){
            char c = s.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
            if(isValid(mp)){
                count++;
                count+=i;
                break;
            }
        }
        return count;
    }

    private static boolean isValid(Map<Character, Integer> mp){
        return (mp.containsKey('a') && mp.containsKey('b') && mp.containsKey('c'));
    }

}
