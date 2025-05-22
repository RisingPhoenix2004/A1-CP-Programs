/*
 * You are provided with a sequence of integers representing various measurements. 
A position in this sequence is termed a balance point if the sum of all measurements before it equals the sum of all measurements after it. 
Your task is to identify all such balance points within the sequence.

Input Format:
--------------
Line-1: An integer N, representing the number of measurements in the sequence.
Line-2: A line with N space-separated integers, representing the measurements.

Output Format:
--------------
Line-1: Print all the balance point indices as space-separated integers. If no balance point exists, print -1.

Sample Input-1:
---------------
7
-7 1 5 2 -4 3 0

Sample Output-1:
----------------
3 6

Explanation:
------------
At index 3: Sum of elements before = -7 + 1 + 5 = -1, Sum of elements after = -4 + 3 + 0 = -1.
At index 6: Sum of elements before = -7 + 1 + 5 + 2 + (-4) + 3 = 0, Sum of elements after = 0.

Sample Input-2:
---------------
3
1 2 3

Sample Output-2:
----------------
-1

Explanation:
-------------
No index satisfies the balance point condition.

Sample Input-3:
---------------
5
2 3 5 3 2

Sample Output-3:
----------------
2

Explanation:
------------
At index 2: Sum before = 2 + 3 = 5, Sum after = 3 + 2 = 5.

Constraints:
-------------
1 ≤ N ≤ 100,000
-1,000,000 ≤ measurement[i] ≤ 1,000,000
 */
import java.util.*;
class Main{
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        int tsum = 0;
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
            tsum +=arr[i];
        }
        int lsum = 0;
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i<n;i++){
            int rsum = tsum - lsum - arr[i];
            if(lsum == rsum){
                res.append(i).append(" ");
            }
            lsum +=arr[i];
        }
        System.out.println(res.length() == 0 ? "-1" : res.toString().trim());
    }
}