/*You are given three sorted integer arrays A[], B[], and C[], and an integer target.

Your task is to find one element from each array (A[i], B[j], and C[k]) such that the sum of these three elements is equal to target.

If there is no exact match, return the triplet with the minimum absolute difference to the target.

Input Format:
-------------
Line 1: An integer N, the size of the first array.
Line 2: N space-separated integers representing elements of array A.
Line 3: An integer M, the size of the second array.
Line 4: M space-separated integers representing elements of array B.
Line 5: An integer P, the size of the third array.
Line 6: P space-separated integers representing elements of array C.
Line 7: An integer target, the required sum.

Output Format:
--------------
Line-1: Print the triplet (A[i], B[j], C[k]) that either matches the target or has the closest sum to the target.

Constraints:
------------
Time Complexity: O(N + M + P)
Space Complexity: O(1)

Sample Input-1:
---------------
4
5 10 20 30
4
1 3 7 10
4
2 5 8 12
25

Sample Output-1:
----------------
10 3 12

Explanation:
-------------
The sum 10 + 7 + 8 = 25, which exactly matches target.


Sample Input-2:
---------------
3
1 5 10
3
3 6 9
3
4 7 8
30

Sample Output-2:
----------------
10 9 8

Explanation:
------------
The sum 10 + 9 + 8 = 27, which is the closest sum to 30 (minimum absolute difference |30 - 27| = 3). */
import java.util.*;

public class ClosestTripletSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }
        int n3 = sc.nextInt();
        int[] a3 = new int[n3];
        for (int i = 0; i < n3; i++) {
            a3[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Arrays.sort(a1);
        Arrays.sort(a2);
        Arrays.sort(a3);
        int[] a = Trips(n1, a1, n2, a2, n3, a3, k);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static int[] Trips(int n1, int[] a1, int n2, int[] a2, int n3, int[] a3, int k) {
        int x = 0;
        int y = 0;
        int z = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n1; i++) {
            int low = 0;
            int tar = k - a1[i];
            int high = n3 - 1;
            while (low < n2 && high >= 0) {
                int sum = a2[low] + a3[high];
                int diff = Math.abs(tar - sum);
                if (diff < min) {
                    min = diff;
                    z = a1[i];
                    x = a2[low];
                    y = a3[high];
                }
                if (sum > tar) {
                    high--;
                } else if (sum < tar) {
                    low++;
                } else if (sum == tar) {
                    return new int[]{a1[i], a2[low], a3[high]};
                }
            }
        }
        return new int[]{z, x, y};
    }
}
