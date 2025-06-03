/*Imagine you're an archivist in the ancient Kingdom of Numeria, tasked with 
recording the royal lineage on a sacred scroll. Every monarch is identified 
by a unique number, and the family tree unfolds in a very specific way. 
Your mission is to transcribe this dynasty using a method that adheres 
to the following customs:

Royal Inscription:  
- Each monarch’s unique number is written as their signature on the scroll.

Enclosing Descendants:  
- If a monarch has offspring, their descendants must be recorded inside parentheses 
  immediately following the monarch’s number.
    - The first-born (or primary heir) is enclosed in its own set of parentheses.
    - If there is a second-born, their number is similarly enclosed, following 
      the first-born’s parentheses.

Omitting Redundant Markings:  
- Empty pairs of parentheses are generally left off the scroll to keep the record neat.
- However, if a monarch has a second-born but first-born is no more, you must include 
  an empty pair of parentheses to clearly mark the absence of a primary heir—ensuring 
  the lineage is accurately mapped.

Your task is to create such an inscription that perfectly reflects the 
hierarchical structure of the royal lineage.

Sample Input-1:
---------------
1 2 3 4

Sample Output-1:
----------------
1(2(4))(3)

Explanation:
        1
       / \
      2   3
     /    
    4

- Monarch 1 is the founding ruler. He has two heirs: Monarch 2 (first-born) and 
  Monarch 3 (second-born).
- Monarch 2 has a single descendant, Monarch 4, recorded as his first-born.
- Since empty markings for non-existent descendants are omitted (because they 
  don't add any information), the inscription is kept concise.
- Thus, the final transcription on the sacred scroll is: "1(2(4))(3)"

Sample Input-2:
---------------
1 2 3 -1 4

Sample Output-2:
----------------
1(2()(4))(3)

Explanation:
        1
       / \
      2   3
       \
        4

- Monarch 1 is the founding ruler with two heirs: Monarch 2 and Monarch 3.
- In this dynasty, Monarch 2 first-born is no more alive but does have a younger 
  descendant, Monarch 4.
- To ensure the record accurately reflects the gap in succession for Monarch 2, 
  an empty pair of parentheses is added before representing Monarch 4. 
  This explicitly marks the absence of a first-born heir.
- Therefore, the recorded inscription becomes: "1(2()(4))(3)"

Sample Input-3:
---------------
1 2 3 4 -1 5 6 -1 7

Sample Output-3:
---------------
1(2(4()(7)))(3(5)(6))
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.toString();
    }

    void dfs(TreeNode t, StringBuilder sb) {
        if (t == null) return;

        sb.append(t.val);

        if (t.left != null || t.right != null) {
            sb.append("(");
            dfs(t.left, sb);
            sb.append(")");
        }

        if (t.right != null) {
            sb.append("(");
            dfs(t.right, sb);
            sb.append(")");
        }
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
public class BTString {
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
        String result = new Solution().tree2str(root);
        System.out.print(result);
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
