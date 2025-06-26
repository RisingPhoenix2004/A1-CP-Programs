/*
 * You are working as a scheduling coordinator at a conference center. 
Your task is to optimize room usage by merging overlapping time slots 
to avoid booking conflicts.

Input Format:
-------------
First line contains n, the number of booking intervals.
Next n lines each contain two space‐separated integers start_time and end_time.
(Times are represented in 24-hour format (e.g., 1300 for 1:00 PM).)

Output Format:
--------------
The merged list of non‐overlapping intervals in sorted order.
Each interval printed in HHMM HHMM format, zero‐padded to 4 digits.

Constraints:
------------
-> 0000 ≤ start_time < end_time ≤ 2400
-> start_time and end_time follow valid 24-hour format
-> 1 ≤ n ≤ 10^5

Sample Input:
-------------
4
0900 1030
1000 1200
1230 1315
1300 1445

Sample Output:
--------------
0900 1200
1230 1445
 */
import java.util.*;
import java.util.stream.*;

public class Sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            intervals.add(new int[]{start, end});
        }
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        for (int[] slot : merged) {
            System.out.printf("%04d %04d%n", slot[0], slot[1]);
        }
    }
}
