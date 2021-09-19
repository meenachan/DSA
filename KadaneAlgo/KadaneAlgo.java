
/*
Largest Sum Contiguous Subarray
Difficulty Level : Medium
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum. 
*/

/*
Kadane’s Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
return max_so_far
*/
import java.util.Arrays;

public class KadaneAlgo {
    public static void main(String args[]){
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }

    public static int maxSubArraySum(int arr[]){
        
        // if the array is of negative values 
        int maxNegative = Arrays.stream(arr).max().getAsInt();
        if(maxNegative<0){
            return maxNegative;
        }
        //positive integer array
        int maxEndHere = arr[0];
        int maxSoFar = arr[0];
        for(int i=1;i<arr.length;i++){
         maxEndHere = Math.max(arr[i], maxEndHere+arr[i]);
         maxSoFar = Math.max(maxSoFar,maxEndHere);
        }
        return maxSoFar;

    }

    
}
