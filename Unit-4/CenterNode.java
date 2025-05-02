/*In computer networks we have star topology. 
Which is like an undirected graph consisting of n switces labeled from 1 to n. 
A Start topology is a LAN where there is one center node and exactly n-1 connections 
that connect the ceter switch with every other switch.

You will be given connections where each connections[i]=[ui, vi] 
indicates that there is connection between switches ui and vi. 

Return the center node of the star topology.

Input Format:
-------------
Line-1: An integer n, number of edges
Line-2 to n: Space separated two integers, represents edge u v

Sample Output:
--------------
Line-1: An integer, a center node

Sample Input-1:
---------------
3
1 2
2 3
4 2

Sample Output-1:
----------------
2

Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
Example 2:

Sample Input-2:
---------------
4
1 2
5 1
1 3
1 4


Sample Output-2:
----------------
1
 

Constraints:
------------
-> 3 <= n <= 105
-> edges.length == n - 1
-> edges[i].length == 2
-> 1 <= ui, vi <= n
-> ui != vi
-> The given edges represent a valid star graph. */
import java.util.*;
 public class CenterNode {
    public int findCenter(int[][] edges) {
        //Write your code here and return integer, the center nod
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for (int i = 0; i < edges.length; i++) {
        //     hm.put(edges[i][0], hm.getOrDefault(edges[i][0], 0) + 1);
        //     hm.put(edges[i][1], hm.getOrDefault(edges[i][1], 0) + 1);
        // }
        // int totalEdges = edges.length;
        // for (int key : hm.keySet()) {
        //     if (hm.get(key) == totalEdges) {
        //         return key;
        //     }
        // }
        // return -1; 
        int a = edges[0][0], b = edges[0][1];
        int c = edges[1][0], d = edges[1][1];
        if (a == c || a == d) return a;
        else return b;
}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] ar = new int[n][2];
		for(int i=0;i<n;i++){
			ar[i][0]=sc.nextInt();
			ar[i][1]=sc.nextInt();
		}
		System.out.println(new CenterNode().findCenter(ar));
	}     
}