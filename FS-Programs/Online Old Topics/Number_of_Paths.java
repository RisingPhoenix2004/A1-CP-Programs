
/*
 * /*
 * You are a software developer at AdventureTech, a company that designs
 * algorithmic solutions for interactive treasure hunt games.
 * The game is set on an M × N grid representing a maze, where each cell has a
 * non-negative cost associated with it, indicating the energy (in points)
 * required to traverse that cell.
 * Players must navigate from the starting point at cell (0, 0) to the treasure
 * located at cell (M-1, N-1) while expending exactly a given amount of energy.
 * Due to the maze's structure, players can only move one step right (to (i,
 * j+1)) or one step down (to (i+1, j)) from any cell.
 * Your task is to create a Java application that calculates the number of
 * distinct paths a player can take from the start to the treasure while
 * achieving the exact target energy cost, using a dynamic programming approach.
 * 
 * Your task is to process the maze grid (M × N integer matrix) and count the
 * number of paths from cell (0, 0) to cell (M-1, N-1) that have a total cost
 * equal to a given target value.
 * Movements are restricted to right or down steps only, and the solution must
 * use dynamic programming to compute the result efficiently.
 * 
 * 
 * Input Format:
 * -------------
 * Line-1: Three integers: M (number of rows), N (number of columns), and C
 * (target energy cost).
 * Line-2 to M: The next M lines each contain N non-negative integers,
 * representing the energy cost of traversing each cell in the maze.
 * 
 * Output Format:
 * --------------
 * Line-1: An integer, number of paths, If no valid paths exists print 0
 * 
 * Constraints
 * ------------
 * 1 ≤ M, N ≤ 100
 * 0 ≤ Matrix[i][j] ≤ 100 (energy cost of each cell)
 * 0 ≤ C ≤ 10^4 (target energy cost)
 * 
 * Sample Input-1:
 * ---------------
 * 4 4 25
 * 1 3 4 2
 * 2 3 3 4
 * 3 2 1 3
 * 4 1 2 5
 * 
 * Sample Output-1:
 * ----------------
 * 2
 * 
 * Explanation:
 * -------------
 * The 4 × 4 maze grid represents energy costs, and the target energy cost is
 * 25. Two paths from (0, 0) to (3, 3) have a total cost of 25:
 * Path 1: (0,0) → (0,1) → (0,2) → (1,2) → (2,2) → (3,2) → (3,3)
 * Costs: 1 + 3 + 4 + 3 + 1 + 3 = 25
 * 
 * Path 2: (0,0) → (0,1) → (1,1) → (2,1) → (2,2) → (3,2) → (3,3)
 * Costs: 1 + 3 + 3 + 2 + 1 + 3 = 25
 * 
 * 
 * Thus, the output is Number of paths with cost 25 is 2.
 * 
 * Sample Input-2:
 * ---------------
 * 2 2 7
 * 1 2
 * 2 2
 * 
 * Sample Output-2:
 * ----------------
 * 0
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int C = sc.nextInt();
        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();
        int[][][] dp = new int[M][N][C + 1];
        if (grid[0][0] <= C) {
            dp[0][0][grid[0][0]] = 1;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int c = 0; c <= C; c++) {
                    if (i == 0 && j == 0)
                        continue;
                    int cost = grid[i][j];
                    if (c - cost < 0)
                        continue;

                    if (i > 0)
                        dp[i][j][c] += dp[i - 1][j][c - cost];
                    if (j > 0)
                        dp[i][j][c] += dp[i][j - 1][c - cost];
                }
            }
        }
        System.out.println(dp[M - 1][N - 1][C]);
    }
}