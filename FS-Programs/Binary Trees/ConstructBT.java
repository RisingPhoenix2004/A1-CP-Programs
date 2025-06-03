/*
Imagine you’re decoding a secret message that outlines the hierarchical structure 
of a covert spy network. The message is a string composed of numbers and parentheses. 
Here’s how the code works:

- The string always starts with an agent’s identification number, this is the 
  leader of the network.
- After the leader’s ID, there can be zero, one, or two segments enclosed in 
  parentheses. Each segment represents the complete structure of one subordinate 
  network.
- If two subordinate networks are present, the one enclosed in the first (leftmost) 
  pair of parentheses represents the left branch, and the second (rightmost) 
  represents the right branch.

Your mission is to reconstruct the entire spy network hierarchy based on this 
coded message.

Sample Input-1:
---------------
4(2(3)(1))(6(5))

Sample Output-1: 
----------------
[4, 2, 6, 3, 1, 5]

Spy network:
        4
       / \
      2   6
     / \  /
    3   1 5

Explanation:
Agent 4 is the leader.
Agent 2 (with its own subordinates 3 and 1) is the left branch.
Agent 6 (with subordinate 5) is the right branch.

Sample Input-2:
---------------
4(2(3)(-1))(6(5)(7))

Sample Output-2:
-----------------
[4, 2, 6, 3, -1, 5, 7]

Spy network:
         4
       /   \
      2     6
     / \   / \
    3   1 5   7

Explanation:
Agent 4 leads the network.
Agent 2 with subordinates 3 and 1 forms the left branch.
Agent 6 with subordinates 5 and 7 forms the right branch.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        this.val = x;
    }
}

class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) return null;

        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = s.length();
        
        while (i < n) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.pop();
                i++;
            } else if (c == '(') {
                i++;
            } else { 
                int start = i;
                if (s.charAt(i) == '-') i++;
                while (i < n && Character.isDigit(s.charAt(i))) i++;
                int val = Integer.parseInt(s.substring(start, i));
                TreeNode node = new TreeNode(val);

                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null)
                        parent.left = node;
                    else
                        parent.right = node;
                }

                stack.push(node);
            }
        }

        return stack.isEmpty() ? null : stack.peek();
    }
}

public class ConstructBT {
    static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            result.add(curr.val);
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        if (line.isEmpty()) return;

        TreeNode root = new Solution().str2tree(line);
        System.out.println(levelOrderTraversal(root));
    }
}
