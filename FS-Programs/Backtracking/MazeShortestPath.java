/*
 * You are given a maze represented by a binary matrix of size R × C, where each cell contains either 1 (open) or 0 (blocked).

You must find the length of the shortest path from a given source cell to a given destination cell. 
You may move one step at a time in any of the four cardinal directions (up, down, left, right), and you may only traverse cells with value 1. 

If no valid path exists, return -1.

Input Format:
--------------
Line-1: Two space-separated integers, represents R, C
Next R lines: Each line contains C space-separated integers 0 or 1, describing one row of the maze.
Next line: Two space-separated integers, represents (sr, sc), zero-based coordinates of the source cell.
Next line: Two space-separated integers,represents (dr, dc), zero-based coordinates of the destination cell.

It is guaranteed that 0 ≤ sr, dr < R and 0 ≤ sc, dc < C, and that both the source and destination cells contain 1.

Output Format:
--------------
Line-1: A single integer, the length of the shortest path (number of steps) from the source to the destination, or -1 if no such path exists.


Sample Input-1:
---------------
10 10
1 1 1 1 1 0 0 1 1 1
0 0 1 0 1 1 0 1 0 1
0 0 1 0 1 1 1 0 0 1
1 0 1 1 1 0 1 1 0 1
0 0 0 1 0 0 0 1 0 1
1 0 1 1 1 0 0 1 1 0
0 0 0 0 1 0 0 1 0 1
0 1 1 1 1 1 1 1 0 0
1 1 1 1 1 0 0 1 1 1
0 0 1 0 0 1 1 0 0 1
0 0
5 7

Sample Output-1:
----------------
12

Explanation: 
------------
The shortest path from (0, 0) to (5, 7) has length 12. The shortest path is marked below with x.

[
	[x, x, x, x, x, 0, 0, 1, 1, 1],
	[0, 0, 1, 0, x, 1, 0, 1, 0, 1],
	[0, 0, 1, 0, x, x, x, 0, 0, 1],
	[1, 0, 1, 1, 1, 0, x, x, 0, 1],
	[0, 0, 0, 1, 0, 0, 0, x, 0, 1],
	[1, 0, 1, 1, 1, 0, 0, x, 1, 0],
	[0, 0, 0, 0, 1, 0, 0, 1, 0, 1],
	[0, 1, 1, 1, 1, 1, 1, 1, 0, 0],
	[1, 1, 1, 1, 1, 0, 0, 1, 1, 1],
	[0, 0, 1, 0, 0, 1, 1, 0, 0, 1]
]
 */
import java.util.*;
public class MazeShortestPath {
    static int minSteps = Integer.MAX_VALUE;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] maze = new int[R][C];

        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                maze[i][j] = sc.nextInt();
        int sr = sc.nextInt(), scCol = sc.nextInt();
        int dr = sc.nextInt(), dcCol = sc.nextInt();
        boolean[][] visited = new boolean[R][C];
        backtrack(maze, visited, sr, scCol, dr, dcCol, 0);
        System.out.println(minSteps == Integer.MAX_VALUE ? -1 : minSteps);
    }
    static void backtrack(int[][] maze, boolean[][] visited, int r, int c, int dr, int dc, int steps) {
        int R = maze.length, C = maze[0].length;
        if (r < 0 || c < 0 || r >= R || c >= C || maze[r][c] == 0 || visited[r][c]) return;
        if (r == dr && c == dc) {
            minSteps = Math.min(minSteps, steps);
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            backtrack(maze, visited, r + dRow[i], c + dCol[i], dr, dc, steps + 1);
        }
        visited[r][c] = false;
    }
}
