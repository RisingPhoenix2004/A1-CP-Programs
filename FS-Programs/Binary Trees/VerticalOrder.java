/*
 * Imagine you are a librarian organizing books on vertical shelves in a grand library. 
The books are currently scattered across a tree-like structure, 
where each book (node) has a position determined by its shelf number (column) 
and row number (level).

Your task is to arrange the books on shelves so that:
1. Books are placed column by column from left to right.
2. Within the same column, books are arranged from top to bottom (i.e., by row).
3. If multiple books belong to the same shelf and row, they should be arranged from left to right, just as they appear in the original scattered arrangement.

Sample Input-1:
---------------
3 9 20 -1 -1 15 7

Sample Output-1:
----------------
[[9],[3,15],[20],[7]]

Explanation:
         3
       /   \
      9     20
          /    \
         15     7

Shelf 1: [9]
Shelf 2: [3, 15]
Shelf 3: [20]
Shelf 4: [7]

Sample Input-2:
---------------
3 9 8 4 0 1 7

Sample Output-2:
----------------
[[4],[9],[3,0,1],[8],[7]]

Explanation:
          3
       /     \
      9       8
    /   \   /   \
   4     0 1     7

Shelf 1: [4]
Shelf 2: [9]
Shelf 3: [3, 0, 1]
Shelf 4: [8]
Shelf 5: [7]

Library Organization Rules:
1. Each column represents a shelf from left to right.
2. Books on the same shelf are arranged from top to bottom.
3. If books share the same position, they are arranged left to right in order of appearance.
 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> columnMap = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int col = t.col;
            int row = t.row;

            columnMap
                .computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new ArrayList<>())
                .add(node.val);

            if (node.left != null) queue.offer(new Tuple(node.left, col - 1, row + 1));
            if (node.right != null) queue.offer(new Tuple(node.right, col + 1, row + 1));
        }

        for (TreeMap<Integer, List<Integer>> rows : columnMap.values()) {
            List<Integer> columnList = new ArrayList<>();
            for (List<Integer> vals : rows.values()) {
                columnList.addAll(vals);
            }
            result.add(columnList);
        }

        return result;
    }

    static class Tuple {
        TreeNode node;
        int col, row;
        Tuple(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
}

public class VerticalOrder {
    
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
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> data = new ArrayList<>();
        for(String s : input) {
            data.add(Integer.parseInt(s));
        }
        scanner.close();
        
        TreeNode root = buildTree(data);
        System.out.println(new Solution().verticalOrder(root));
    }
}
