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
       Map<Integer, String>findMap =  countNum();
       int t = io.nextInt();
       while (t -- > 0){
           int n = io.nextInt();
           if(findMap.get(n) != null){
               System.out.println(findMap.get(n));
           }
           else System.out.println("-1");
       }

    }
    public static Map<Integer, String> countNum(){
        Map<Integer, String> mp = new HashMap<>();
        mp.put(1,"-1");
       //mp.put(2,"66");
        StringBuilder sb = new StringBuilder();
        sb.append("66");
        Queue<StringBuilder>q = new LinkedList<>();
        q.offer(sb);
        while (! q.isEmpty()){
            StringBuilder current = q.poll();
            if(current.toString().length() > 500) break;
            long currentNum = Long.parseLong(current.toString());
            if(currentNum % 66 == 0){
                int len = current.toString().length();
                if(mp.containsKey(len)){
                    mp.put(len, String.valueOf(Math.min(currentNum,Long.parseLong(mp.get(len)))));
                }
                else
                mp.put(len, Long.toString(currentNum));
              /*  while (! q.isEmpty() && q.peek().length() == len){
                    StringBuilder currsb = q.poll();
                    Long num = Long.parseLong(currsb.toString());
                    if(num % 66 == 0 && num < currentNum){
                        mp.put(len,currsb.toString());
                        currsb.insert(0,"3");
                        q.offer(sb);
                        currsb.deleteCharAt(0);
                        currsb.insert(0,"6");
                        q.offer(currsb);
                    }
                }*/
            }
            current.insert(0,"3");
            q.offer(current);
            current.deleteCharAt(0);
            current.insert(0,"6");
            q.offer(current);
        }
        return mp;

    }
}
