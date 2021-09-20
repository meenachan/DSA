/*
Minimize the maximum difference between the heights
Difficulty Level : Hard
Given heights of n towers and a value k. 
We need to either increase or decrease the height of every tower by k (only once) where k > 0. 
The task is to minimize the difference
 between the heights of the longest and the shortest tower after modifications and output this difference.

*/
import java.util.Arrays;

public class minTowerHeightDiff{

    public static void main(String args[]){
                int a[] = {3, 9, 12, 16, 20};
                int k =3;
                int n = a.length;
                System.out.println("Minimum Tower height difference is: " +getMinDiff(a,n,k));
    }
  public static  int getMinDiff(int[] arr, int n, int k) {
    //   sort the array to obtain the smallest and tallest tower easily
    Arrays.sort(arr);
    //calcute the current max difference in tower heights
    int curdiff = arr[n-1]-arr[0];
    //modifing operation : incrementing the height of small towers and decrementing the heights of tall towers
    int small = arr[0]+k;
    int tall = arr[n-1]-k;
    int min , max;
    //determining the max and min heights 
    for(int i =0; i<n-1;i++){
        min = Math.min(small,arr[i+1]-k);
        max = Math.max(tall,arr[i]+k);
        if(min<0)continue;
        curdiff = Math.min(curdiff,max-min);
    }
    return curdiff ;
    
}

}