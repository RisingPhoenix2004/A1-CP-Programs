/*Imagine you're the chief curator at a renowned museum that houses a rare collection 
of ancient artifacts. These artifacts are arranged in a special display that 
follows a strict rule: any artifact positioned to the left of another has a lower 
value, and any artifact on the right has a higher value. 

Your task is to transform this display into what is known as a "Greater Artifact 
Display." In this new arrangement, each artifact’s new value will be its original 
value plus the sum of the values of all artifacts that are more valuable than it.

Sample Input-1:
---------------
4 2 6 1 3 5 7

Sample Output-1:
----------------
22 27 13 28 25 18 7

Explanation:
-------------
Input structure 
       4
      / \
     2   6
    / \ / \
   1  3 5  7

Output structure:
        22
      /   \
     27   13
    / \   / \
   28 25 18  7

Reverse updates:
- Artifact 7: 7
- Artifact 6: 6 + 7 = 13
- Artifact 5: 5 + 13 = 18
- Artifact 4: 4 + 18 = 22
- Artifact 3: 3 + 22 = 25
- Artifact 2: 2 + 25 = 27
- Artifact 1: 1 + 27 = 28
 */
import java.util.*;

class Node {
    int val;
    Node left, right;
    
    public Node(int val) {
        this.val = val;
        left = right = null;
    }
}

class GreaterArtifactDisplay{
    private static int total = 0; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Node root = build(arr);
        Sum(root);
        Inorder(root);
        System.out.println();
        LevelOrder(root);
    }
    
    public static Node build(int[] arr) {
        if (arr.length == 0 || arr[0] <= -1) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(arr[0]);
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            if (i < arr.length && arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
    
    public static void Sum(Node root) {
        if (root == null) return;
        Sum(root.right);
        total += root.val;
        root.val = total;
        Sum(root.left);
    }
    
    public static void Inorder(Node root) {
        if (root == null) return;
        Inorder(root.left);
        System.out.print(root.val + " ");
        Inorder(root.right);
    }
    
    public static void LevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }
}
