package ad.practice.playground.solution.bitmask;

import java.util.Scanner;

public class Tmp {
    public static void main(String[]a){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[]masks= new int[n];
        for(int k = 0; k<n; k++){
            int availability = scanner.nextInt();
            int mask = 0;
            for(int i = 0 ;i< availability;i++){
                int day = scanner.nextInt();
                mask = mask | (1<<day);
            }
            masks[k] = mask;
        }
        int maxCommonDays = 0;
        int person1 = 0;
        int person2 = 0;

        for(int i = 0;i<n;i++){
            for (int j =i+1; j<n;j++){
                int intersection = masks[i] & masks[j];
                int commonDays = countSetBits(intersection);
                if(commonDays > maxCommonDays){
                    maxCommonDays = commonDays;
                    person1 = i;
                    person2 = j;
                }
                //maxCommonDays = Math.max(maxCommonDays,commonDays);
            }
        }

        System.out.println("maxCommonDays : "+maxCommonDays + ", p1 = " + person1 +", p2 = "+person2);
    }

    public static int countSetBits(int num){
        int count = 0;
        while(num> 0){
            if(num%2 == 1){
                num--;
                count++;
            }
            else{
                num/=2;
            }
        }
        return count;
    }

}
