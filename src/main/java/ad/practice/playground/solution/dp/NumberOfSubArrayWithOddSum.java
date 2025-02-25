package ad.practice.playground.solution.dp;

public class NumberOfSubArrayWithOddSum {

    public static void main(String[]a){
        int [] A = {1,3,5,3};
        System.out.println(noOfSubArrays(A));
    }

    private static int noOfSubArrays(int[] A){
        int mod = (int) (7+Math.pow(10,9));
        int n = A.length;
        int[] oddSum = new int[n];
        int[] evenSum = new int[n];
        if(A[0]%2 == 0) evenSum[0] = 1;
        else oddSum[0] = 1;
        for(int i = 1; i <n;i++){
            if(A[i] % 2 == 1){
                oddSum[i] = (1+evenSum[i-1])%mod;
                evenSum[i] = oddSum[i-1];
            }else {
                evenSum[i] = (1+evenSum[i-1])%mod;
                oddSum[i] = oddSum[i-1];
            }
        }
        int count = 0;
        for(int t : oddSum) count += (t%mod);
        return count;
    }
}
