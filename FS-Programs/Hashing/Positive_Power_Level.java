/*
 * Deep within the lost Archives of Numeria lies a stone tablet carved with mystical integers. 
Legend tells that these numbers—some positive, some negative—encode the "first missing level of power" that a worthy seeker must attain. 
Your quest is to decipher the tablet and discover the smallest positive power level missing from the sequence of carved integers.

Input Format:
--------------
Line 1: Integer N, the number of integers.
Line 2: N space-separated integers.

Output Format:
--------------
A single integer: the smallest missing positive power-level.

Sample Input-1:
---------------
7
2 -9 5 11 1 -10 7

Sample Output-1:
----------------
3

Explanation: Consecutive positive integers 1 and 2 are present in the array, So the first missing positive is 3

Sample Input-2:
---------------
5
4 6 5 3 8

Sample Output-2:
----------------
1

Explanation: All values are positive, but the first positive integer 1 is missing, So the output is 1
 */
import java.util.*;

public class Sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(mispos(arr));
    }

    private static int mispos(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}