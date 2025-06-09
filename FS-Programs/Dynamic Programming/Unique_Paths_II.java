/*
 * You are navigating a spaceship through a galaxy represented as an m x n space 
map.The spaceship starts from the top-left sector (sector[0][0]) and its 
mission is to safely reach the bottom-right sector (sector[m-1][n-1]).

Each sector on the map can either be clear (0) or blocked by an 
asteroid field (1).  
The spaceship can only move right or downward at any moment.  
It cannot pass through sectors with asteroid fields.

Return the total number of distinct safe routes the spaceship can take to 
reach its destination at the bottom-right corner.


Input format:
-------------
2 space seperated integers, m & n
next m lines of representing the sector 

Output format:
--------------
An integer, the total number of distinct safe routes



Example 1:
----------
Input:
3 3
0 0 0
0 1 0
0 0 0

Output:
2

Explanation:  
There’s one asteroid field blocking the center of the 3×3 map.  
Two possible safe navigation paths:
- Move → Move → Down → Down
- Down → Down → Move → Move

Example 2:
---------
Input:
2 2
0 1
0 0

Output:
1


Constraints:
- m == sectorMap.length
- n == sectorMap[i].length
- 1 <= m, n <= 100
- sectorMap[i][j] is either 0 (clear) or 1 (asteroid field)

 */
/*
 * import java.util.*;
class Sol{
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [][] grid = new int[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j <n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int [][] dp = new int [m][n];
        for(int i = 0 ; i <m; i++){
        Arrays.fill(dp[i],-1);}
        System.out.println(unique(m-1,n-1,grid,dp));
    }
    private static int unique(int m, int n, int [][] grid, int [][] dp){
        if(m < 0 || n < 0 || grid[m][n] == 1){
            return 0;
        }
        if (m == 0 && n == 0) return 1;
        if(dp[m][n] != -1) return dp[m][n];
        dp[m][n] = unique(m-1, n, grid, dp) + unique(m,n-1,grid,dp);
        return dp[m][n];
    }
}
 */
import java.util.*;

public class Main{
    static int unique_path(int[][] grid,int m, int n){
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],0);
        }
        if(grid[0][0]==0){
            dp[0][0]=1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    if(i>0 && j>0){
                        dp[i][j]+=dp[i][j-1];
                        dp[i][j]+=dp[i-1][j];
                    }
                    else if(i>0){
                        dp[i][j]+=dp[i-1][j];
                    }
                    else if(j>0){
                        dp[i][j]+=dp[i][j-1];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m =sc.nextInt();
        int n =sc.nextInt();
        int[][] a = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(unique_path(a,m,n));
    }
}