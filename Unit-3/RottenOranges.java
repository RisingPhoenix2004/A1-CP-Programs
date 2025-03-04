/*You are given an m x n grid where each cell can have one of three values:
-> 0 representing an empty cell,
-> 1 representing a fresh orange, or
-> 2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1.


Input Format:
-------------
Line-1: Two integers, m and n, represents grid[] sizes
Line-2 to m: n Space separated integers, represents grid[i][j]

Output Format:
--------------
Line-1: An integer

Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation: 
-------------
The orange in the bottom left corner (row 2, column 0) is never rotten, 
because rotting only happens 4-directionally.

Sample Input-3:
---------------
1 1
0 2

Sample Output-3:
----------------
0

Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
------------
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2. */
import java.util.*;
class RottingOranges{
    public static void main(String... args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[][] arr = new int [n][m];
    for(int i =0; i<n;i++){
        for(int j = 0; j<m;j++){
            arr[i][j] = sc.nextInt();
        }
    }
    System.out.println(mins(arr,n,m));
    }
    static int mins(int[][] arr, int n, int m){
        int[][] directions = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++) 
            {
                if (arr[i][j] == 2) 
                {
                    q.add(new int[]{i, j});
                } 
                else if (arr[i][j] == 1) 
                {
                    freshOranges++;
                }
            }
        }
        int minutes = 0;
        while (!q.isEmpty() && freshOranges > 0)
        {
            int size = q.size();
            for (int i = 0; i < size; i++) 
            {
                int[] cell = q.poll();
                for (int[] dir : directions) 
                {
                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && arr[newRow][newCol] == 1) 
                    {
                        arr[newRow][newCol] = 2;
                        freshOranges--;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes : -1;
    }
}