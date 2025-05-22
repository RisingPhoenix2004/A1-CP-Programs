/*
 * GridFlow Technologies is developing a path optimization tool for data transmission in a grid-based communication network, 
represented as an N × N square matrix of integers. 
Each cell contains a numeric value, and the goal is to find the longest "snake sequence" within the grid. 
A snake sequence is a path of numbers where each subsequent number 
is located either to the right or down of the current number and differs from it by exactly + or - 1. 
The task is to compute the maximum length of such a snake sequence and outputs one valid sequence.

Constraints:
------------
1 ≤ N ≤ 100 (matrix dimension)
-1000 ≤ Matrix[i][j] ≤ 1000 (value in each cell)
At least one snake sequence exists in the matrix.

Input Format:
--------------
Line-1: An integer: N (size of the square matrix).
Line-2 to N: The next N lines each contain N integers, representing the values in the matrix.

Output Format:
---------------
Line-1: Maximum length number. If maximum length not exists then write 0.

Sample Input-1:
---------------
3
1 3 5
7 9 11
13 15 17

Sample Output-1:
----------------
0

Explanation:
-------------
No two adjacent elements differ by + or - 1.

Sample Input-2:
---------------
5
7 5 2 3 1
3 4 1 4 4
1 5 6 7 8
3 4 5 8 9
3 2 2 7 6

Sample Output-2:
----------------
7

Explanation:
----------------
The 5 × 5 matrix contains several snake sequences. One maximum length snake sequence is:
- Start at (0,1): 5
- Move down to (1,1): 4 (5-1)
- Move down to (2,1): 5 (4+1)
- Move right to (2,2): 6 (5+1)
- Move right to (2,3): 7 (6+1)
- Move right to (2,4): 8 (7+1)
- Move down to (3,4): 9 (8+1, invalid, but check down to (3,3))
- From (2,3): 7, move down to (3,3): 8 (7+1)
- Move down to (4,3): 7 (8-1)
This sequence (5 → 4 → 5 → 6 → 7 → 8 → 7) has a length of 7 and satisfies the + or - 1 constraint for each step, moving only right or down.

 */
import java.util.*;
public class Main {
    public static void findLongestSnakeSequence(int[][] matrix, int N) {
        int[][] dp = new int[N][N];
        int maxLen = 0, endRow = 0, endCol = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = 0; 
                if (i > 0 && Math.abs(matrix[i][j] - matrix[i - 1][j]) == 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j > 0 && Math.abs(matrix[i][j] - matrix[i][j - 1]) == 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }

                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    endRow = i;
                    endCol = j;
                }
            }
        }
        System.out.println(maxLen);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        findLongestSnakeSequence(matrix, N);
    }
}