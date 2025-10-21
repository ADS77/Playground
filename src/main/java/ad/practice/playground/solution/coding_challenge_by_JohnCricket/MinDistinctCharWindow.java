package ad.practice.playground.solution.coding_challenge_by_JohnCricket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Scanner;
public class MinDistinctCharWindow {
    public static Logger logger = LoggerFactory.getLogger(MinDistinctCharWindow.class);
    public static void main(String[]a){

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t > 0){
            System.out.println("min window size : " + solve(scanner.nextLine()));
            t--;
        }
    }

    private static int solve(String s) {
        int ans = s.length()+1;
        int[]mapper = new int[26];// supposing string hold lowercase eng letters only
        int distinct = 0;
        for(char c : s.toLowerCase().toCharArray()){
            int index = (int) c - 'a';
            mapper[index]++;
            if(mapper[index] == 1){
                distinct ++;
            }
        }
        logger.info("distinct count :"+ distinct);
        int distinctCurr = 0;
        int left = 0;
        int right = 0;
        int[]chk = new int[26];
        while (right < s.length()){
            int index = (int) s.charAt(right) - 'a';
            logger.info("char : {}, index : {}", s.charAt(right), index);
            chk[index]++;
            if(chk[index] == 1) distinctCurr++;
            while (distinctCurr == distinct){
                ans = Math.min(ans, right-left+1);
                int tmp =(int) s.charAt(left)-'a';
                chk[tmp]--;
                if(chk[tmp] == 0) distinctCurr--;
                left++;
            }
            right++;
        }
        return ans;
    }
}
