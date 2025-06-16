/*
 * You are controlling a battlefield represented by an m x n grid. 
Each cell on this grid can be one of the following:

- A reinforced barrier ('B'), blocking your laser.
- An enemy drone ('D'), your target.
- An open cell ('0'), where you can position your robot to fire.

When your robot fires its powerful laser from an open cell, 
the beam destroys all enemy drones in the same row and column 
until the beam hits a barrier ('B'). The barrier completely stops 
the laser, protecting anything behind it.

Your goal is to identify the best position (open cell) to place 
your robot so that firing the laser destroys the maximum number 
of enemy drones in a single shot. Return this maximum number.

Input format:
-------------
Line 1: Two space separated integers, represents m & n
Next M lines: each row of battlefield


Output format:
--------------
An integer, maximum number of enemy drones destroyed in a single shot.

Sample Input-1:
---------------
3 4
0 D 0 0
D 0 B D
0 D 0 0

Sample Output-1:
----------------
3

Explanation: placing robot at battlefield[1][1] destroys 3 enemy drones in a single shot.

Sample Input-2:
---------------
3 3
B B B
0 0 0
D D D

Sample Output-2:
----------------
1


Constraints:
- 1 <= m, n <= 500
- battlefield[i][j] is either 'B', 'D', or '0'.
 */
import java.util.*;
class Sol{
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = row[j].charAt(0);
            }
        }
        System.out.println(battle(m,n,arr,new int [m][n]));
    }
    private static int battle(int m, int n, char arr[][], int dp[][]){
        int amx = 0;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'B') count = 0;
                else if (arr[i][j] == 'D') count++;
                else dp[i][j] += count; 
            }
        }
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i][j] == 'B') count = 0;
                else if (arr[i][j] == 'D') count++;
                else dp[i][j] += count;
            }
        }
        
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (arr[i][j] == 'B') count = 0;
                else if (arr[i][j] == 'D') count++;
                else {
                    dp[i][j] += count;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (arr[i][j] == 'B') count = 0;
                else if (arr[i][j] == 'D') count++;
                else {
                    dp[i][j] += count;
                    amx = Math.max(amx, dp[i][j]);
                }
            }
        }
        return amx;
    }
}