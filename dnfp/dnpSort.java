package dnfp;
/*Sort an array of 0s, 1s and 2s
 Difficulty Level : Medium
 Given an array A[] consisting 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
Examples: 
 Input: {0, 1, 2, 0, 1, 2}
 Output: {0, 0, 1, 1, 2, 2}
 
 Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2} 

*/


public class dnpSort{
    public static void main(String args[]){
        int a[] = {0, 1, 2, 0, 1, 2};
        System.out.println("Input array");
        for(int i :a){
            System.out.print(i);
        }
        System.out.println("");
       
        int resultByCount[] = countImpl(a);
        int resultByDNP[] = dnpSortimpl(a);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("By Count method");
        for(int i : resultByCount){
            System.out.print(i);
        }
        System.out.println("");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("By DNP method");
        for(int i : resultByDNP){
            System.out.print(i);
        }

    }

// Approach 1: count 0,1,2 and update the given array according to the number of 0,1,2 .    
    public static int[] countImpl(int a[]){
        int count0=0;
        int count1=0;
        int count2=0;
        int len = a.length;

        // counting 0,1,2
         for(int i :a){
             if(i==0) count0++;
             if(i==1)count1++;
         }
         count2 = len-(count0+count1);
        
         int i =0;
        while(count0!=0){
            a[i] =0;
            count0--;
            i++;
        }
        while(count1!=0){
            a[i] =1;
            count1--;
            i++;
        }
        while(count2!=0){
            a[i] =2;
            count2--;
            i++;
        }
return a;
    }


/*
 Approach 2:Segregate 0s and 1s in an array, and both of these problems are variation of famous Dutch national flag problem.
The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four sections: 
a[1..Lo-1] zeroes (red)
a[Lo..Mid-1] ones (white)
a[Mid..Hi] unknown
a[Hi+1..N] twos (blue)
If the ith element is 0 then swap the element to the low range, thus shrinking the unknown range.
Similarly, if the element is 1 then keep it as it is but shrink the unknown range.
If the element is 2 then swap it with an element in high range.
Algorithm: 
Keep three indices low = 1, mid = 1 and high = N and there are four ranges, 1 to low (the range containing 0), low to mid (the range containing 1), mid to high (the range containing unknown elements) and high to N (the range containing 2).
Traverse the array from start to end and mid is less than high. (Loop counter is i)
If the element is 0 then swap the element with the element at index low and update low = low + 1 and mid = mid + 1
If the element is 1 then update mid = mid + 1
If the element is 2 then swap the element with the element at index high and update high = high – 1 and update i = i – 1. As the swapped element is not processed
Print the output array.
    */
    public static int[] dnpSortimpl(int a[]){
        int low =0;
        int mid =0;
        int len = a.length;
        int high = len-1;
       while(mid<=high){
           if(a[mid]==0)
           { 
               swap(a,low,mid); 
               mid++; 
               low++;
            }
           else if(a[mid]==1) mid++;
           else{
               swap(a,mid,high);
               high--;
           }
       }
        return a;
    }
    public static void swap(int a[] , int low , int high){
            int temp ;
          temp=  a[low];
          a[low] = a[high];
          a[high] = temp;
    }
}

