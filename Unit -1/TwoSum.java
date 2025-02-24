/*You are given a 1-indexed array of integers, numbers, sorted in non-decreasing order. 
Your task is to find two distinct numbers in the array such that their sum equals a given target.

Return their 1-based indices as an array [index1, index2], where 1 ≤ index1 < index2 ≤ numbers.length.

Constraints:
------------
-> There is exactly one valid solution.
-> You cannot use the same element twice.
-> Your solution must use only constant extra space.

Input Format:
-------------
Line-1: An integer N, representing the size of the array.
Line-2: N space-separated integers, representing the array elements.
Line-3: An integer X, representing the target sum.

Output Format:
--------------
Line-1: Print indices as an array if there exists a pair whose sum is equal to X

Sample Input-1:
---------------
4
2 7 11 15
9

Sample Output-1:
----------------
[1, 2]

Explanation:
-------------
The sum of 2 and 7 is 9.
Their 1-based indices are 1 and 2.

Sample Input-2:
---------------
3
2 3 4
6

Sample Output-2:
----------------
[1, 3]

Explanation:
------------
The sum of 2 and 4 is 6.
Their 1-based indices are 1 and 3.

Sample Input-3:
---------------
2
-1 0
-1

Sample Output-3:
----------------
[1, 2]

Explanation:
------------
The sum of -1 and 0 is -1.
Their 1-based indices are 1 and 2.


 */
import java.util.*;

class TwoSum {

    static ArrayList<Integer> findTwoSum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int sum = 0;
        int right = arr.length - 1;
        while (sum != target) {
            sum = arr[left] + arr[right];
            if (sum == target) {
                result.add(left + 1);
                result.add(right + 1);
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(findTwoSum(arr, target));
    }
}
