/*You are given a rectangular grid of M x N bulbs arranged on a wall. 
Each bulb can emit either blue light or red light, represented as:
-> 0 → Blue Light
-> 1 → Red Light

Allowed Operation:
-------------------
-> Choose any row or column.
-> Toggle each bulb in that row or column, i.e.:
    Change 0 → 1 (Blue to Red).
    Change 1 → 0 (Red to Blue).
Your task is to determine if it is possible to turn all bulbs into blue light (all 0s) using any number of toggle operations.

Constraints
------------
1 ≤ M, N ≤ 100
The grid contains only 0s and 1s.

Input Format:
-------------
Line 1: Two space-separated integers M and N, representing the size of the grid.
Next M lines: Each line contains N space-separated integers (either 0 or 1).

Output Format:
--------------
Print true if it is possible to turn all bulbs into 0. Otherwise, print false.

Sample Input-1:
---------------
3 3
1 0 1
0 1 0
1 0 1

Sample Output-1:
----------------
true

Explanation: 
------------
1) Toggle column 1 and column 3, the grid becomes:
0 0 0
1 1 1
0 0 0

2) Toggle row 2, the grid becomes:
0 0 0
0 0 0
0 0 0

3) Now, all bulbs emit blue light (0). Hence, output is true.

Sample Input-2:
---------------
3 3
1 0 0
0 1 0
0 0 0

Sample Output-2:
----------------
false

Explanation: 
------------
No sequence of toggle operations can make all bulbs 0.
Hence, output is false.

 */
import java.util.*;
class RowColFlips{
    static boolean isToggle(int[][]grid,int m,int n){
        for(int i=1;i<m;i++){
            int flag=-1;
            for(int j=0;j<n;j++){
                int result=grid[0][j]^grid[i][j];
                if(flag==-1){
                    flag=result;
                }
                else if(flag!=result){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int [][] grid=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(isToggle(grid,m,n));
    }
}