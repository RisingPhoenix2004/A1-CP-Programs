/*Imagine you're the master chef in a renowned kitchen, tasked with preparing a 
spectacular dinner consisting of numDishes unique dishes, labeled from 
0 to numDishes - 1. However, the recipes have dependencies—certain dishes can 
only be prepared after completing others. You’re given a list called dependecies, 
where each element dependencies[i] = [Xi, Yi] means that you must finish 
preparing dish Yi before starting dish Xi.

For instance, the pair [2, 1] implies that to create dish 2, 
dish 1 must be prepared first.

Return the ordering of dishes that a chef should take to finish all dishes.
	- the result set should follow the given order of conditions.
	- If it is impossible to complete all dishes, return an empty set.


Input Format:
-------------
Line-1: An integer numDishes, number of Dishes.
Line-2: An integer m, number of dependencies.
Next m lines: Two space separated integers, Xi and Yi.

Output Format:
--------------
Return a list of integers, the ordering of dishes that a chef should finish.

Sample Input-1:
---------------
4
3
1 2
3 0
0 1

Sample Output-1:
----------------
[2, 1, 0, 3]

Explanation: There are 4 dishes. Since dish 1 requires dish 2, dish 3 requires 
dish 0 and dish 0 requires dish 1, you can prepare dishes in the order 2 1 0 3.


Sample Input-2:
---------------
2
2
1 0
0 1

Sample Output-1:
----------------
[]

Explanation: There are 2 dishes, but dish 1 depends on dish 0 and dish 0 depends 
on dish 1. This circular dependency makes it impossible to prepare all dishes.

Constraints:
------------
- 1 <= numDishes <= 2000  
- 0 <= m <= 5000  
- dependencies[i].length == 2  
- 0 <= Xi, Yi < numDishes  
- All the dependency pairs are unique.
 */

 import java.util.*;

 public class MasterChef {
	 public static List<Integer> findOrder(int numDishes, int[][] dependencies) {
		 List<Integer> order = new ArrayList<>();
		 Map<Integer, List<Integer>> adjList = new HashMap<>();
		 int[] inDegree = new int[numDishes];
		 
		 // Build adjacency list and in-degree array
		 for (int[] dep : dependencies) {
			 int dish = dep[0], prerequisite = dep[1];
			 adjList.putIfAbsent(prerequisite, new ArrayList<>());
			 adjList.get(prerequisite).add(dish);
			 inDegree[dish]++;
		 }
		 
		 // Topological Sorting using Kahn's Algorithm (BFS)
		 Queue<Integer> queue = new LinkedList<>();
		 for (int i = 0; i < numDishes; i++) {
			 if (inDegree[i] == 0) queue.offer(i);
		 }
		 
		 while (!queue.isEmpty()) {
			 int curr = queue.poll();
			 order.add(curr);
			 if (adjList.containsKey(curr)) {
				 for (int next : adjList.get(curr)) {
					 inDegree[next]--;
					 if (inDegree[next] == 0) queue.offer(next);
				 }
			 }
		 }
		 
		 return order.size() == numDishes ? order : new ArrayList<>();
	 }
 
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int numDishes = scanner.nextInt();
		 int m = scanner.nextInt();
		 int[][] dependencies = new int[m][2];
		 
		 for (int i = 0; i < m; i++) {
			 dependencies[i][0] = scanner.nextInt();
			 dependencies[i][1] = scanner.nextInt();
		 }
		 
		 List<Integer> result = findOrder(numDishes, dependencies);
		 System.out.println(result);
		 scanner.close();
	 }
 }
 