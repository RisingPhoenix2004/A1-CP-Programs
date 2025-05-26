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
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}
public class Cartographer {
    public static TreeNode buildTree(List<Integer> levelOrder) {
        if (levelOrder == null || levelOrder.isEmpty() || levelOrder.get(0) == -1) return null;
        TreeNode root = new TreeNode(levelOrder.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < levelOrder.size()) {
            TreeNode current = queue.poll();

            if (i < levelOrder.size() && levelOrder.get(i) != -1) {
                current.left = new TreeNode(levelOrder.get(i));
                queue.offer(current.left);
            }
            i++;

            if (i < levelOrder.size() && levelOrder.get(i) != -1) {
                current.right = new TreeNode(levelOrder.get(i));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
    public static List<List<Integer>> frontierToRootPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, result);
        return result;
    }
    private static void dfs(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            List<Integer> leafToRoot = new ArrayList<>(path);
            Collections.reverse(leafToRoot);
            result.add(leafToRoot);
        }
        dfs(node.left, path, result);
        dfs(node.right, path, result);
        path.remove(path.size() - 1); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(" ");
        List<Integer> input = new ArrayList<>();
        for (String part : parts) {
            input.add(Integer.parseInt(part));
        }
        TreeNode root = buildTree(input);
        List<List<Integer>> paths = frontierToRootPaths(root);
        System.out.println(paths);
    }
}
