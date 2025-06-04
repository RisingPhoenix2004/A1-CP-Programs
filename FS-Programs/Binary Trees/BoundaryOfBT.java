/*
 * The Indian Army has established multiple military camps at strategic locations 
along the Line of Actual Control (LAC) in Galwan. These camps are connected in 
a hierarchical structure, with a main base camp acting as the root of the network.

To fortify national security, the Government of India has planned to deploy 
a protective S.H.I.E.L.D. that encloses all military camps forming the outer 
boundary of the network.

Structure of Military Camps:
    - Each military camp is uniquely identified by an integer ID.
    - A camp can have at most two direct connections:
        - Left connection → Represents a subordinate camp on the left.
        - Right connection → Represents a subordinate camp on the right.
    - If a military camp does not exist at a specific position, it is 
      represented by -1
	
Mission: Deploying the S.H.I.E.L.D.
Your task is to determine the list of military camp IDs forming the outer 
boundary of the military network. This boundary must be traversed in 
anti-clockwise order, starting from the main base camp (root).

The boundary consists of:
1. The main base camp (root).
2. The left boundary:
    - Starts from the root’s left child and follows the leftmost path downwards.
    - If a camp has a left connection, follow it.
    - If no left connection exists but a right connection does, follow the right connection.
    - The leftmost leaf camp is NOT included in this boundary.
3. The leaf camps (i.e., camps with no further connections), ordered from left to right.
4. The right boundary (in reverse order):
    - Starts from the root’s right child and follows the rightmost path downwards.
    - If a camp has a right connection, follow it.
    - If no right connection exists but a left connection does, follow the left connection.
    - The rightmost leaf camp is NOT included in this boundary.


Input Format:
-------------
space separated integers, military-camp IDs.

Output Format:
--------------
Print all the military-camp IDs, which are at the edge of S.H.I.E.L.D.


Sample Input-1:
---------------
5 2 4 7 9 8 1

Sample Output-1:
----------------
[5, 2, 7, 9, 8, 1, 4]


Sample Input-2:
---------------
11 2 13 4 25 6 -1 -1 -1 7 18 9 10

Sample Output-2:
----------------
[11, 2, 4, 7, 18, 9, 10, 6, 13]


Sample Input-3:
---------------
1 2 3 -1 -1 -1 5 -1 6 7

Sample Output-3:
----------------
[1, 2, 7, 6, 5, 3]


 */
import java.util.*;

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return new ArrayList<>();
        if (root.left == null && root.right == null) return Arrays.asList(root.val);

        List<Integer> boundary = new ArrayList<>();
        boundary.add(root.val);

        addLeftBoundary(root.left, boundary);
        addLeaves(root, boundary);
        addRightBoundary(root.right, boundary);

        return boundary;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> boundary) {
        while (node != null) {
            if (node.left != null || node.right != null)
                boundary.add(node.val);
            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> boundary) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (node.left != null || node.right != null)
                stack.push(node.val);
            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }
        while (!stack.isEmpty())
            boundary.add(stack.pop());
    }

    private void addLeaves(TreeNode node, List<Integer> boundary) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            boundary.add(node.val);
            return;
        }
        addLeaves(node.left, boundary);
        addLeaves(node.right, boundary);
    }
}

class TreeNode {
    Integer val;
    TreeNode left, right;

    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BoundaryOfBT {
    public static TreeNode buildTree(List<Integer> data) {
        if (data.isEmpty() || data.get(0) == -1) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data.get(0));
        queue.offer(root);

        int i = 1;
        while (i < data.size()) {
            TreeNode current = queue.poll();

            if (i < data.size() && data.get(i) != -1) {
                current.left = new TreeNode(data.get(i));
                queue.offer(current.left);
            }
            i++;

            if (i < data.size() && data.get(i) != -1) {
                current.right = new TreeNode(data.get(i));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> data = new ArrayList<>();
        for (String s : input) {
            data.add(Integer.parseInt(s));
        }
        scanner.close();
        TreeNode root = buildTree(data);
        System.out.println(new Solution().boundaryOfBinaryTree(root));
    }
}
