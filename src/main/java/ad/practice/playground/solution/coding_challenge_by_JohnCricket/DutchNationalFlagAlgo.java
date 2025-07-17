package ad.practice.playground.solution.coding_challenge_by_JohnCricket;

public class DutchNationalFlagAlgo {
    public static void main(String[]args){
        int [] ans = threeWayPartitioning(new int[]{9,12,3,5,14,10,10}, 10);
        for(int t : ans) System.out.println(t);
    }
    public static int[] threeWayPartitioning(int [] arr, int pivot){
        int n = arr.length;
        int low=0,mid=0,high = n-1;
        while(mid <= high){
            if(arr[mid] < pivot){
                swap(arr, low, mid);
                mid++;
                low++;
            }
            else if(arr[mid] > pivot){
               swap(arr, mid, high);
                high--;
            }
            else {
                mid++;
            }
        }
        return arr;
    }

    private static int[] swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }

}


/*
Given a pivot x, and a list lst, partition the list into three parts.

The first part contains all elements in lst that are less than x
The second part contains all elements in lst that are equal to x
The third part contains all elements in lst that are larger than x
Ordering within a part can be arbitrary.

For example, given x = 10 and lst = [9, 12, 3, 5, 14, 10, 10], one partition may be [9, 3, 5, 10, 10, 12, 14].*/