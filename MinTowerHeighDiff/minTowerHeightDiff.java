import java.util.Arrays;

public class minTowerHeightDiff{

    public static void main(String args[]){
                int a[] = {3, 9, 12, 16, 20};
                int k =3;
                int n = a.length;
                System.out.println("Minimum Tower height difference is: " +getMinDiff(a,n,k));
    }
  public static  int getMinDiff(int[] arr, int n, int k) {
        // code here
    Arrays.sort(arr);
    
    int curdiff = arr[n-1]-arr[0];
    int small = arr[0]+k;
    int tall = arr[n-1]-k;
    int min , max;
    for(int i =0; i<n-1;i++){
        min = Math.min(small,arr[i+1]-k);
        max = Math.max(tall,arr[i]+k);
        if(min<0)continue;
        curdiff = Math.min(curdiff,max-min);
    }
    return curdiff ;
    
}

}