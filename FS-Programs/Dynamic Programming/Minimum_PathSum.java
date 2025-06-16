/*
 * Your playing a game, the game contains m*n grid.
Each cell in the grid represent the health points.
You can move one step either downwads or rightwards only.
Whenever you visit a cell in the grid, you will lose the 
same health points of the cell.

You will start at (0,0) cell of the grid and have to reach (m-1)*(n-1) cell.
Your task is to minimize the loss of overall health points.

Input Format:
-------------
Line-1: Two integers M and N.
Next M lines: N space separated integers, health points in each row of the grid.

Output Format:
--------------
Print an integer, minimal loss of overall health points.


Sample Input-1:
---------------
3 3
1 3 1
1 5 1
4 2 1

Sample Output-1:
----------------
7

Explanation:
------------
start at cell(0,0) =>  1→3→1→1→1 minimizes the loss of health points.


Sample Input-2:
---------------
4 4
8 6 9 3
7 6 2 1
5 5 7 9
8 9 6 2

Sample Output-2:
----------------
34

Explanation:
------------
start at cell(0,0) =>  8→6→6→2→1→9→2 minimizes the loss of health points.
 */
// import java.util.Arrays;
// import java.util.Scanner;
// class Sol{
//     public static void main(String... args){
//         Scanner sc = new Scanner(System.in);
//         int m = sc.nextInt();
//         int n = sc.nextInt();
//         int [][] grid = new int[m][n];
//         for(int i = 0; i < m ; i++){
//             for(int j = 0 ; j <n;j++){
//                 grid[i][j] = sc.nextInt();
//             }
//         }
//         int [][] dp = new int [m][n];
//         for(int i = 0 ; i <m; i++){
//         Arrays.fill(dp[i],-1);}
//         System.out.println(minpath(m-1,n-1,grid,dp));
//     }
//         private static int minpath(int i, int j, int[][] grid, int[][] dp) {
//         if (i < 0 || j < 0) return Integer.MAX_VALUE;  
//         if (i == 0 && j == 0) return grid[0][0];
//         if (dp[i][j] != -1) return dp[i][j];
//         int up = minpath(i - 1, j, grid, dp);
//         int left = minpath(i, j - 1, grid, dp);
//         dp[i][j] = grid[i][j] + Math.min(up, left);
//         return dp[i][j];
//         }
// }
import java.util.*;
class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                dp[i][j] = sc.nextInt();
            }
        }
        System.out.println(minpathsum(dp,m,n));
    }
    public static int minpathsum(int [][] dp , int m, int n){
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i==0 && j == 0){
                    continue;
                }
                else if(i>0 && j>0){
                    dp[i][j] += Math.min(dp[i-1][j],dp[i][j-1]);
                }
                else if(i>0){
                    dp[i][j] += dp[i-1][j];
                }
                else if(j>0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
}
}