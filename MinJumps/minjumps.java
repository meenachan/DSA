/*

Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element. 
Find the minimum number of jumps to reach the end of the array (starting from the first element). 
If an element is 0, then you cannot move through that element.
Note: Return -1 if you can't reach the end of the array.




*/





public class minjumps {

    public static void main(String args[]){
        int a[] ={1, 4, 3, 2, 6, 7} ;
        int n = a.length;
        System.out.println("Min jumps to reach the end of array : "+ minJumps(a, n));

    }
    public static int minJumps(int a[], int n){
        int maxReach = a[0];
        int step= a[0];
        int jump=1;
        // array with length 1 or 0
        if(n<=1){
            return 0;
        }
        
        if(a[0]==0){
            return -1;
        }
        // traversing the array 
        for(int i =1; i<n; i++){
        
            if(i==n-1){
                return jump;
            }
            // updating max reach with the max number of steps
            maxReach = Math.max(maxReach, i+a[i]);
            step--;
            if(step==0){
                jump++;
                if(i>=maxReach){
                    return -1;
                }
                step = maxReach-i;
            }

        }
        return -1;
    }
    
}
/*

Example 1:

Input:
N = 11 
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
Output: 3 
Explanation: 
First jump from 1st element to 2nd 
element with value 3. Now, from here 
we jump to 5th element with value 9, 
and from here we will jump to last. 
Example 2:



*/