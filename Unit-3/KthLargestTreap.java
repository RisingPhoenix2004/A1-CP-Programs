/*There are n football players standing in the ground, coach wants to know the 
P-th largest height of the players. Given an array of heights[] and the value of P. 
Help the coach to find the P'th largest height.

Note: You are supposed to print the P'th largest height in the sorted order of heights[].
      Not the P'th distinct height.

Input Format:
-------------
Line-1: Size of array n and P value(space separated)
Line-2: Array elements of size n.

Output Format:
--------------
Print P'th largest height.

Sample input-1:
---------------
8 2
1 2 1 3 4 5 5 5

Sample output-1:
----------------
5

Sample input-2:
---------------
6 3
2 4 3 1 2 5

Sample output-2:
----------------
3 */
import java.util.*;
class TreapNode
{
    int data;
    int priority;
    TreapNode left;
    TreapNode right;
    TreapNode(int data)
    {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.left = this.right = null;
    }
}

class KthLargest
{
    static int k;
    public static TreapNode rotateLeft(TreapNode root)
    {
        TreapNode R = root.right;
        TreapNode X = root.right.left;
        R.left = root;
        root.right = X;
        return R;
    }
    public static TreapNode rotateRight(TreapNode root)
    {
        TreapNode L = root.left;
        TreapNode Y = root.left.right;
        L.right = root;
        root.left = Y;
        return L;
    }
    
    public static TreapNode insertNode(TreapNode root, int data)
    {
        if (root == null)
        {
            return new TreapNode(data);
        }
        if (data < root.data){
            root.left = insertNode(root.left, data);
            if (root.left != null && root.left.priority > root.priority)
            {
                root = rotateRight(root);
            }
        }
        else{
            root.right = insertNode(root.right, data);
            if (root.right != null && root.right.priority > root.priority){
                root = rotateLeft(root);
            }
        }
        return root;
    }
        
    static void inorder(TreapNode root)
    {
        if (root == null){
            return;
        }
        inorder(root.left);
        k--;
        if(k==0){
            System.out.print(root.data);
            return;
        }
        inorder(root.right);
    }
// 	static void printTreap(TreapNode root)
//     {
//         if (root == null)
//             return;
//         printTreap(root.left);
//         System.out.println(root.data + " " + root.priority);
//         printTreap(root.right);
//     }
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        k=n-p+1;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreapNode root = null;
        for(int a:arr){
            root = insertNode(root,a);
        }
// 		printTreap(root);
        inorder(root);
    }
}
