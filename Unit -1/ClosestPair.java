/*
Two brothers are playing a game based on two sorted lists of numerical elements and a target sum.

The first brother provides:
-> Two sorted lists of integers.
-> A target sum.

The second brother's task is to find and return the closest pair of elements (one from each list) 
whose sum is closest to the given target.

Rules:
------
Each pair must consist of one element from each list.
If multiple pairs have the same closest sum, return any one valid pair.
The input lists are already sorted in ascending order.
The result must be printed as a comma-separated pair.

Input Format:
-------------
Line 1: An integer N1, representing the size of the first list.
Line 2: N1 space-separated integers, representing elements of the first sorted list.
Line 3: An integer N2, representing the size of the second list.
Line 4: N2 space-separated integers, representing elements of the second sorted list.
Line 5: An integer X, representing the target sum.

Output Format:
--------------
Line-1: Print a comma-separated pair (a, b), where a is from list_1 and b is from list_2, such that their sum is closest to the target sum.

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32

Sample Output-1:
----------------
1,30

Explanation:
------------
The closest pair to 32 is (1,30) → 1 + 30 = 31, which is the closest sum to 32.

Sample Input-2:
---------------
3
2 4 6
4
5 7 11 13
15

Sample Output-2:
----------------
2,13

Explanation:
------------
The closest pair to 15 is (2,13) → 2 + 13 = 15, which is an exact match.
 */

import java.util.*;

class ClosestPair {
    static ArrayList<Integer> closePair(int[] arr1, int[] arr2, int m, int n, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        int a = 0, b = 0;
        while (left < m && right >= 0) {
            if (Math.abs(arr1[left] + arr2[right] - target) < diff) {
                a = arr1[left];
                b = arr2[right];
                diff = Math.abs(arr1[left] + arr2[right] - target);
            }
            if (arr1[left] + arr2[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        result.add(a);
        result.add(b);
        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        for (int j = 0; j < n; j++) {
            arr2[j] = sc.nextInt();
        }
        int target = sc.nextInt();
        ArrayList<Integer> res = closePair(arr1, arr2, m, n, target);
        System.out.println(res.get(0) + " ," + res.get(1));
    }
}