/*
 * In the Kingdom of Arboran, the Great World Tree links numerous realms. 
Each realm may branch into two sub-realms through a Northern gate (N) or a Southern gate (S). 
The heart of the tree is Realm 1. A frontier realm is one without any outgoing gates, 
marking the edge of explored lands.

Your mission is to aid the Royal Cartographer by listing every route 
from each frontier realm back to Realm 1.

Input Format:
-------------
Line-1: Space-separated integers gives the tree in level-order, using -1 to mark a missing child.

Output Format:
--------------
Line-1: Return a list of paths, where each list is one frontier-to-root path.

Sample Input-1:
---------------
1 2 3 4 5 6 7 -1 -1 -1 -1 8 9

Sample Output-1:
----------------
[[4,2,1], [5,2,1], [8,6,3,1], [9,6,3,1], [7,3,1]]

Explanation:
------------
Given tree
        1
      /   \
     2     3
    / \   / \
   4  5  6   7
         / \
        8   9
The binary tree has five leaf-to-root paths:
4 —> 2 —> 1
5 —> 2 —> 1
8 —> 6 —> 3 —> 1
9 —> 6 —> 3 —> 1
7 —> 3 —> 1

 */
import java.util.*;

class Main {
    public static void main(String[] args) {
        // 1) Read a single line of space-separated integers (level-order, with -1 as null)
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        List<Integer> levelOrder = new ArrayList<>();
        for (String token : line.trim().split("\\s+")) {
            levelOrder.add(Integer.parseInt(token));
        }

        // 2) Delegate to Cartographer to build the tree and compute paths
        Set<List<Integer>> paths = Cartographer.chartFrontierToRootPaths(levelOrder);

        // 3) Print the result set
        System.out.println(paths);
    }
}
class Cartographer {

    // Definition of a realm node (binary tree node)
    static class Node {
        int id;
        Node north, south;
        Node(int id) { this.id = id; }
    }
    
    public static Set<List<Integer>> chartFrontierToRootPaths(List<Integer> levelOrder) {
        Node root = buildTreeFromLevelOrder(levelOrder);
        Set<List<Integer>> paths = new HashSet<>();
        backtrack(root, new ArrayList<>(), paths);
        return paths;
    }

    // Builds the binary tree from its level-order serialization.
    private static Node buildTreeFromLevelOrder(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) {
            return null;
        }
        Node root = new Node(vals.get(0));
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        int i = 1, n = vals.size();
        while (!queue.isEmpty() && i < n) {
            Node curr = queue.poll();
            // northern (left) child
            if (i < n && vals.get(i) != -1) {
                curr.north = new Node(vals.get(i));
                queue.add(curr.north);
            }
            i++;
            // southern (right) child
            if (i < n && vals.get(i) != -1) {
                curr.south = new Node(vals.get(i));
                queue.add(curr.south);
            }
            i++;
        }
        return root;
    }

    // Backtracking DFS: accumulate root→leaf, then record reversed path (leaf→root)
    private static void backtrack(Node node, List<Integer> current, Set<List<Integer>> paths) {
        if (node == null) return;

        current.add(node.id);

        // If leaf node (no children)
        if (node.north == null && node.south == null) {
            List<Integer> path = new ArrayList<>(current);
            Collections.reverse(path); // Convert to leaf-to-root
            paths.add(path);
        } else {
            backtrack(node.north, current, paths);
            backtrack(node.south, current, paths);
        }

        current.remove(current.size() - 1); // Backtrack
    }
}