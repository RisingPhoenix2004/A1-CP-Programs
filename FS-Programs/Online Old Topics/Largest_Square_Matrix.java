/*
 * You are a software engineer at TechNet Solutions, a company specializing in network infrastructure analysis for large-scale communication systems. The company is developing a fault-tolerant network simulation tool to identify robust communication clusters within a network grid. The network is represented as an M × N binary matrix, where each cell is either active (1) or inactive (0). 

Your task is to process the binary matrix and determine the size of the largest square submatrix of 1's, representing a robust communication cluster, while adhering to the following constraints:
1. The cluster must not include nodes on the network's perimeter (i.e., the first or last row or column of the matrix) to avoid external interference.
2. The cluster must include at least one "critical node," defined as an active node (1) surrounded by at least three inactive nodes (0's) in its four adjacent cells (up, down, left, right), as these nodes are pivotal for maintaining connectivity.
3. If multiple clusters of the same size exist, prioritize the one located closer to the bottom of the matrix (highest sum of row indices) to optimize signal propagation.

Constraints:
-------------
1. 3 ≤ M, N ≤ 1000 (to allow non-perimeter clusters).
2. Matrix elements are either 0 (inactive) or 1 (active).
3. At least one critical node exists in the matrix.

Input Format:
-------------

Line-1: Two integers: M (number of rows) and N (number of columns).
Line-2 to M: The next M lines each contain N integers (0 or 1), representing the binary network grid.

Output Format:
---------------

Line-1: An integer, The size of the largest square submatrix of 1’s is <size> other wise if no valid cluster exists print 0.

Sample Input-1:
---------------
6 6
0 0 1 0 1 1
0 1 1 1 0 0
0 0 1 1 1 1
1 1 1 0 1 1
1 0 1 1 1 1
1 1 1 1 1 0

Sample Output-1:
---------------- 
2

Explanation
------------
The network grid contains a 2 × 2 cluster of active nodes starting at position (3, 2):
1 1
1 1

Sample Input-2:
---------------
1 1
0

Sample Output-2:
---------------- 
0

 */
// Got 90 //
import java.util.*;
public class Largest_Square_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt();
        int[][] mat = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                mat[i][j] = sc.nextInt();
        int n = mat.length, m = mat[0].length;
        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 1 + Math.min(dp[i][j + 1], 
						Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}