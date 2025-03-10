/*Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Segment Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input:
-------------
5 5
4 2 13 3 25
1 0 4		//sumRange
1 1 3		//sumRange
2 2 18	//update
2 4 17	//update
1 0 4		//sumRange

5 5
4 2 13 3 25
1 0 4
1 1 3
2 2 18	
2 4 17
1 0 4	

Sample Output:
--------------
47
18
44
 */

 import java.util.*;

 public class SegmentTreeTest {
 
     class SegmentTreeNode {
         int start, end;
         SegmentTreeNode left, right;
         int sum;
 
         public SegmentTreeNode(int start, int end) {
             this.start = start;
             this.end = end;
             this.left = null;
             this.right = null;
             this.sum = 0;
         }
     }
 
     SegmentTreeNode root = null;
 
     public SegmentTreeTest(int[] nums) {
         root = buildTree(nums, 0, nums.length - 1);
     }
 
     private SegmentTreeNode buildTree(int[] nums, int start, int end) {
         if (start > end) {
             return null;
         } else {
             SegmentTreeNode ret = new SegmentTreeNode(start, end);
             if (start == end) {
                 ret.sum = nums[start];
             } else {
                 int mid = (start + end) / 2;
                 ret.left = buildTree(nums, start, mid);
                 ret.right = buildTree(nums, mid + 1, end);
                 ret.sum = ret.left.sum + ret.right.sum;
             }
             return ret;
         }
     }
 
     void update(int i, int val) {
         update(root, i, val);
     }
 
     void update(SegmentTreeNode root, int pos, int val) {
         if (root.start == root.end) {
             root.sum = val;
         } else {
             int mid = (root.start + root.end) / 2;
             if (pos <= mid) {
                 update(root.left, pos, val);
             } else {
                 update(root.right, pos, val);
             }
             root.sum = root.left.sum + root.right.sum;
         }
     }
     
 
     public int sumRange(int i, int j) {
         return sumRange(root, i, j);
     }
 
     public int sumRange(SegmentTreeNode root, int start, int end) {
         if (root.start == start && root.end == end) {
             return root.sum;
         } else {
             int mid = (root.start + root.end) / 2;
             if (end <= mid) {
                 return sumRange(root.left, start, end);
             } else if (start >= mid + 1) {
                 return sumRange(root.right, start, end);
             } else {
                 return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
             }
         }
     }
 
     public static void main(String args[]) {
         Scanner scan = new Scanner(System.in);
         int n = scan.nextInt();
         int q = scan.nextInt();
         int[] nums = new int[n];
         for (int i = 0; i < n; i++) {
             nums[i] = scan.nextInt();
         }
         SegmentTreeTest st = new SegmentTreeTest(nums);
         while (q-- > 0) {
             int opt = scan.nextInt();
             if (opt == 1) {
                 int s1 = scan.nextInt();
                 int s2 = scan.nextInt();
                 System.out.println(st.sumRange(s1, s2));
             } else {
                 int ind = scan.nextInt();
                 int val = scan.nextInt();
                 st.update(ind, val);
             }
         }
     }
 }