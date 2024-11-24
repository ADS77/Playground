package ad.practice.playground.solution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.parseInt;

public class RunLengthEncoding {
    private static Logger logger = LoggerFactory.getLogger(RunLengthEncoding.class);

    public static void main(String[] args){
        String s = "4A3B2C1D2A";
        logger.info(decode(encode(s)));
    }

    public static String encode(String s){
        int left = 0;
        int right = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (left < n && right < n){
            if(isChar(s.charAt(right))){
                String num = "";
                for(int i = left; i< right; i++){
                    num += (s.charAt(i));
                }
                int weight = getInt(num);
                while (weight > 0){
                    sb.append(s.charAt(right));
                    weight--;
                }
                left = right +1;
            }
            right ++;
        }
        return sb.toString();
    }

    private static String decode(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        while (right < n){
            char c = s.charAt(left);
            int count = 0;
            while (right < n && s.charAt(right) == c){
                count++;
                right++;
            }
            sb.append(count).append(c);
            left = right;
        }
        return sb.toString();
    }

    private static boolean isChar(char c){
        return (c >= 'a' && c <= 'z') || (c <= 'Z' &&  c >= 'A');
    }

    private static int getInt(String s){
        int res = 0;
        int mul = 1;
        for(int i = s.length() -1 ; i>= 0 ; i--){
            char c = s.charAt(i);
            int current = (int)(s.charAt(i) - '0');
            res += (mul*current);
            mul *= 10;
        }
        return res;
    }
}
