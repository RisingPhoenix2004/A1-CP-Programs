/*
 * You are given an array of integers. An inversion is defined as a pair of
 * indices (i, j) such that:
 * 
 * i < j, and
 * 
 * A[i] > A[j]
 * 
 * Your task is to count the total number of such inversion pairs in the array.
 * 
 * Inversions indicate how far an array is from being sorted. If the array is
 * completely sorted in ascending order, the number of inversions is 0. If it's
 * sorted in descending order, the number of inversions is at its maximum.
 * 
 * Input Format:
 * -------------
 * Line-1: An integer n — the number of elements in the array
 * Line-2: A list of n space-separated integers A[0], A[1], ..., A[n-1]
 * 
 * Output Format:
 * -------------
 * Line-1: A single integer — the total number of inversions in the array
 * 
 * Sample Input-1:
 * -------------
 * 6
 * 3 -1 0 -2 2 1
 * 
 * Sample Output-1:
 * -------------
 * 8
 * #Inversions are: (3, -1)(3, 0)(3, -2)(3, 2)(3, 1)(-1, -2)(0, -2)(2, 1)
 * 
 * Sample Input-2:
 * -------------
 * 4
 * 4 3 2 1
 * 
 * Sample Output-2:
 * -------------
 * 6
 * #Inversions: All pairs where left > right — total = 6
 * 
 * Sample Input-3:
 * -------------
 * 6
 * 1 2 3 4 5 6
 * 
 * Sample Output-3:
 * -------------
 * 0
 * 
 * Constraints:
 * -------------
 * -> 1 ≤ n ≤ 1000
 * -> -10^9 ≤ A[i] ≤ 10^9
 * -> Elements can be positive, negative, or zero
 * -> Input array may be partially or completely unsorted
 * -> Time complexity should be O(n log n)
 */
    import java.util.*;

    public class Main {
        public static int countInversions(int[] arr) {
            return mergeSort(arr, 0, arr.length - 1);
        }
        private static int mergeSort(int[] arr, int left, int right) {
            int count = 0;
            if (left < right) {
                int mid = (left + right) / 2;
                count += mergeSort(arr, left, mid);
                count += mergeSort(arr, mid + 1, right);
                count += merge(arr, left, mid, right);
            }
            return count;
        }
        private static int merge(int[] arr, int left, int mid, int right) {
            int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
            int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
            int i = 0, j = 0, k = left, count = 0, n = leftArr.length, m = rightArr.length;
            while (i < n && j < m) {
                if (leftArr[i] <= rightArr[j]) {
                    arr[k++] = leftArr[i++];
                } else {
                    arr[k++] = rightArr[j++];
                    count += (n - i); 
                }
            }
            while (i < n) arr[k++] = leftArr[i++];
            while (j < m) arr[k++] = rightArr[j++];
            return count;
        }
        public static void main(String... args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            System.out.println(countInversions(arr));
        }
    }
