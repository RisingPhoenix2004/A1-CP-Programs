/*Tata motors released a new ELECTRIC CAR, 
which recharges its battery based on the vehicle movement at specific points 
along the road when vehicle passes those points at a specified speed. 
As you are the owner of that CAR, you want to get maximum benefit of that, 
and you are travelling on a road of length "N" kilometres. 

There are specific recharge points at every kilometre, 
it specifies how much percentage of battery improves when you pass those points with a specified speed. 
But you can travel with this specified speed for a continuous distance of "K" kilometres. 

With your programming skills can you determine how to maximize the benefit from this.


Input Format:
--------------
Line-1: two space-separated integers N and K, 
the length of the track and the maximum distance car can run at specified speed.
Line-2: N space-separated integers, the number of charging points within each kilometre of the road.

Output Format:
-------------
Output an integer.


Sample Input-1:
---------------
7 2
2 4 8 1 2 1 8

Sample Output-1:
----------------
12

Explanation:
Car can get maximum recharge 4+8=12 if it runs at specified speed between the 2nd and the 3rd kilometre, inclusive.

Constraints 
1≤T≤10
1≤K≤N≤100
1≤ai≤100
 */

import java.util.*;
class CarRecharge{
    static int maxRecharge(int[] arr,int n,int k){
        int maximum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        maximum=sum;
        for(int i=k;i<n;i++){
            sum=sum-arr[i-k]+arr[i];
            maximum=Math.max(maximum,sum);
        }
        return maximum;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxRecharge(arr,n,k));
    }
    
}