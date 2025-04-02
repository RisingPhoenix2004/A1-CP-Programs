/*Bubloo is working with computer networks, where servers are connected 
in a hierarchical structure, represented as a Binary Tree. Each server (node) 
is uniquely identified by an integer value.

Bubloo has been assigned an important task: find the shortest communication 
path (in terms of network hops) between two specific servers in the network.

Network Structure:
------------------
The network of servers follows a binary tree topology.
Each server (node) has a unique identifier (integer).
If a server does not exist at a certain position, it is represented as '-1' (NULL).

Given the root of the network tree, and two specific server IDs (E1 & E2), 
determine the minimum number of network hops (edges) required to 
communicate between these two servers.

Input Format:
-------------
Line-1: Space separated integers, elements of the tree.
Line-2: Two Space separated integers, represents node ids.

Output Format:
--------------
Print an integer value.


Sample Input-1:
---------------
1 2 4 3 5 6 7 8 9 10 11 12
4 8

Sample Output-1:
----------------
4

Explanation:
------------
The edegs between 4 and 8 are: [4,1], [1,2], [2,3], [3,8]


Sample Input-2:
---------------
1 2 4 3 5 6 7 8 9 10 11 12
6 6

Sample Output-2:
----------------
0

Explanation:
------------
No edges between 6 and 6.
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class NetworkHops {
    public static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();
            
            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.left);
            }
            i++;
            
            if (i < nodes.length && !nodes[i].equals("-1")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    
    public static TreeNode findLCA(TreeNode root, int E1, int E2) {
        if (root == null || root.val == E1 || root.val == E2) return root;
        
        TreeNode left = findLCA(root.left, E1, E2);
        TreeNode right = findLCA(root.right, E1, E2);
        
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
    
    public static int findDistance(TreeNode root, int target, int distance) {
        if (root == null) return -1;
        if (root.val == target) return distance;
        
        int left = findDistance(root.left, target, distance + 1);
        if (left != -1) return left;
        
        return findDistance(root.right, target, distance + 1);
    }
    
    public static int shortestPath(TreeNode root, int E1, int E2) {
        TreeNode lca = findLCA(root, E1, E2);
        int d1 = findDistance(lca, E1, 0);
        int d2 = findDistance(lca, E2, 0);
        return d1 + d2;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] treeNodes = scanner.nextLine().split(" ");
        int E1 = scanner.nextInt();
        int E2 = scanner.nextInt();
        scanner.close();
        
        TreeNode root = buildTree(treeNodes);
        System.out.println(shortestPath(root, E1, E2));
    }
}
