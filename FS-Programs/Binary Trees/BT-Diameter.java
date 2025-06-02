// Imagine you are designing a network of secret corridors in an ancient castle. Each chamber in the castle leads to at most two other chambers through hidden passageways,
// forming a branching layout. The castle’s "longest secret route" is defined as the maximum number of corridors you must traverse to get from one chamber to another
// (without repeating the corridor). This route may or may not pass through the main entry hall.

// Your task is to compute the length of longest secret route between two chambers which is represented by the number of corridors between them.

// Example 1
// input=
// 1 2 3 4 5 
// output=
// 3

// Structure:
//        1
//       / \
//      2   3
//     / \
//    4   5

// Explanation:
// The longest secret route from chamber 4 to chamber 3 (alternatively, fropm chamber 5 to chamber 3) along the route:








// 4
// → 2 → 1 → 3
// This path has 3 corridors (4–2, 2–1, 1–3), so the length is 3.
// \
// Exampl./e 2:
// input=
// 1 -1 2 3 4
// output=
// 2

// Structure:
//    1
//     \
//      2
//     / \
//    3   4

// Explanation:
// The longest secret route from chamber 3 to chamber 4 (alternatively, from chamber 1 to chamber 4) along the route:
// 3 → 2 → 4
// This path has 2 corridors (3–2, 2–4), so the length is 2.


// Constraints:
// The castle can have between 1 and 10,000 chambers. 
// Each chamber is assigned a value (which could be used for other purposes in the design) ranging from -100 to 100.


import java.util.*;
class Solution {
    private static int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       //WRITE YOUR CODE HERE AND RETURN DIAMETER 
       int value = traverse(root);
    //   System.out.print(diameter+" "+value);
       return diameter;
       
    }
    
    public int traverse(TreeNode root){
        if(root == null){
           return 0;
       }
       
       int left = traverse(root.left);
       int right = traverse(root.right);
       
       diameter = Math.max(diameter , left+right);
       
       return Math.max(left , right) + 1;
    }
}
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            this.val = x; 
        }
    }
public class BTDiameter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read the entire line of input
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            return;
        }
        
        // Split input into tokens and convert them to integers
        String[] tokens = line.split("\\s+");
        List<Integer> nodes = new ArrayList<>();
        for (String token : tokens) {
            nodes.add(Integer.parseInt(token));
        }
        
        // Build the binary tree from the level order representation
        TreeNode root = buildTree(nodes);
        
        // Generate the string representation
        System.out.println(new Solution().diameterOfBinaryTree(root));
        
    }
    
    static TreeNode buildTree(List<Integer> nodes) {
        if (nodes.isEmpty() || nodes.get(0) == -1) {
            return null;
        }
        
        TreeNode root = new TreeNode(nodes.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        
        while (index < nodes.size()) {
            TreeNode current = queue.poll();
            if (current == null) continue;
            
            // Process left child
            if (index < nodes.size()) {
                int leftVal = nodes.get(index++);
                if (leftVal != -1) {
                    current.left = new TreeNode(leftVal);
                    queue.offer(current.left);
                }
            }
            
            // Process right child
            if (index < nodes.size()) {
                int rightVal = nodes.get(index++);
                if (rightVal != -1) {
                    current.right = new TreeNode(rightVal);
                    queue.offer(current.right);
                }
            }
        }
        
        return root;
    }
    
}
