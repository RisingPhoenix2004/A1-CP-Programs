/*
 * You are given a string S representing a positive integer and an integer k. Your task is to find the smallest possible number that can be formed by performing at most k swaps between any two digits of the string.
If k == 0, return the original number.
If the number is already the smallest possible permutation, return it as-is.
If the input is null or empty, return it unchanged.

A swap operation means exchanging the positions of any two digits (not necessarily adjacent). Each swap counts as one operation. The goal is to minimize the number.

Input Format:
-----------
A string S of digits (1 ≤ S.length ≤ 10)
An integer k (0 ≤ k ≤ 10) representing the number of allowed swaps.

Output Format:
------------
A string representing the smallest number possible after performing at most k swaps.

Constraints:
--------------
1 ≤ length(S) ≤ 10
0 ≤ k ≤ 10
Digits are in the range '0' to '9'
No leading zeros in input unless the number is exactly "0"
Each swap counts as 1 operation, regardless of position

Sample Input-1:
------------
934651
2

Sample Output-1:
----------------
134569

Sample Input-2:
-------------
11111
3
Sample Output-2:
--------------
11111


 */
import java.util.*;

class Test {
    static String minNumber;
    public static String findNumber(String s, int n) {
        if (s == null || s.length() == 0 || n == 0)
            return s;
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        if (s.equals(new String(sorted)))
            return s;

        minNumber = s;
        helper(s.toCharArray(), n, 0);
        return minNumber;
    }

    private static void helper(char[] arr, int k, int index) {
        if (k == 0 || index == arr.length)
            return;

        char minDigit = arr[index];
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] < minDigit) {
                minDigit = arr[i];
            }
        }

        if (minDigit != arr[index]) {
            for (int i = arr.length - 1; i > index; i--) {
                if (arr[i] == minDigit) {
                    swap(arr, index, i);
                    String curr = new String(arr);
                    if (curr.compareTo(minNumber) < 0) {
                        minNumber = curr;
                    }
                    helper(arr, k - 1, index + 1);
                    swap(arr, index, i);
                }
            }
        } else {
            helper(arr, k, index + 1);
        }
    }
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        System.out.println(findNumber(s, n));
    }
}
