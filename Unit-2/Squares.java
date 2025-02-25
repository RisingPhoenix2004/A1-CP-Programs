/*Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.

Input Format:
-------------
Line-1: An integer N
Line-2: N space seperated integers

Output Format:
--------------
Line-1: A list of integers

Sample Input-1:
---------------
5
-4 -1 0 3 10

Sample Output-1: 
----------------
[0, 1, 9, 16, 100]

 */
import java.util.*;
class Squares{
    static int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[]res=new int[n];
        int low=0;
        int high=n-1;
        int k=n-1;
        while(low<=high){
            
            if(Math.abs(nums[high])>Math.abs(nums[low])){
                res[k]=nums[high]*nums[high];
                high--;
            }
            
            else{
                res[k]=nums[low]*nums[low];
                low++;
            }
            k--;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[]result=sortedSquares(arr);
        System.out.println(Arrays.toString(result));
    }
}
