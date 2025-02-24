/*You are given a singly linked list containing N nodes. 
Your task is to find the middle element of the linked list.

Input Format:
-------------
Line 1: An integer N, representing the number of nodes in the linked list.
Line 2: N space-separated integers representing the elements of the linked list.

Output Format:
--------------
Line-1: Print a single integer, the middle element of the linked list.

Sample Input-1:
---------------
5
1 2 3 4 5

Sample Output-1:
----------------
3


Sample Input-2:
---------------
6
1 2 3 4 5 6

Sample Output-2:
----------------
4
 */
import java.util.*;
class MiddleElementLL{
	Node head; 
	// Linked list node 
	class Node {
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
 
	// Function to print the middle element of the linked list 
	void printMiddle(){
	 
	    Node slow=head;
	    Node fast=head;
	    while( fast!=null && fast.next!=null){
            fast=fast.next.next;
	        slow=slow.next;
	    }
	    
	    System.out.print(slow.data);
	}
 
	// Inserts a new Node at front of the list. 
	public void push(int new_data){
		// 1 & 2: Allocate the Node & Put in the data
		Node new_node = new Node(new_data);
		// 3. Make next of new Node as head 
		new_node.next = head;
		// 4. Move the head to point to the new Node 
		head = new_node;
	}
 
	// This function prints the contents of the linked list starting from  the given node     
	public void printList(){
		Node tnode = head;
		while (tnode != null) {
			//System.out.print(tnode.data + "->");
			tnode = tnode.next;
		}
		System.out.println("NULL");
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String list[]=sc.nextLine().split(" ");
		int val;
		MiddleElementLL llist = new MiddleElementLL();
		for (int i = 0; i < list.length; i++) {	
			llist.push(Integer.parseInt(list[i]));
		}
		//llist.printList();
		llist.printMiddle();	
	}
} 