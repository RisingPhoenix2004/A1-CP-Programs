import java.util.*;

public class MaxHeap 
{
	private int[] Heap;
	private int size;

	// Constructor to initialize an empty max heap 
	public MaxHeap(int maxsize)
	{
		size = 0;
		Heap = new int[maxsize];
	}

	// Return position of parent
	private int parent(int pos) 
	{ 
		return (pos - 1) / 2; 
	}

	// Return left child
	private int leftChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	}

	// Return right child
	private int rightChild(int pos)
	{
		return (2 * pos) + 2;
	}

	// Returning true if given node is leaf
	private boolean isLeaf(int pos)
	{
		if (pos + 1 > (size / 2) && pos <= size) 
		{
			return true;
		}
		return false;
	}

	// Swap nodes
	private void swap(int cur, int par)
	{
		int tmp;
		tmp = Heap[cur];
		Heap[cur] = Heap[par];
		Heap[par] = tmp;
	}

	// Recursive function to max heapify given subtree
	private void maxHeapify(int pos)
	{
		System.out.println("pos " + pos + " isLeaf(pos) " + isLeaf(pos)); 
		if (isLeaf(pos))
			return;
		System.out.println("maxHeapipy " + Heap[pos] + " " + Heap[leftChild(pos)] + " " +
			Heap[rightChild(pos)]);

		if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) 
		{
			if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) 
			{
				swap(pos, leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			else 
			{
				swap(pos, rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}

	// Inserts a new element to max heap
	public void insert(int element)
	{
		Heap[size] = element;

		// Traverse up and fix violated property
		int current = size;
		System.out.println("Element: " + element + " current: " + current +
			" parent(current): " + parent(current));

		while (Heap[current] > Heap[parent(current)]) 
		{
			System.out.println("current: " + current + " Heap[current]: " +
				Heap[current] + " Heap[parent(current)]: " + Heap[parent(current)]);

			swap(current, parent(current));
			current = parent(current);
		}
		size++;
	}

	// Display heap
	public void print()
	{
		for (int i = 0; i < size / 2; i++) 
		{
			System.out.print("Parent: " + Heap[i]);

			if (leftChild(i) < size) 
				System.out.print(" Left Child: " + Heap[leftChild(i)]);

			if (rightChild(i) < size) 
				System.out.print(" Right Child: " + Heap[rightChild(i)]);

			System.out.println(); 
		}
	}

	// Remove an element from max heap
	public int extractMax()
	{
		if(size > 0)
		{
			int popped = Heap[0];
			Heap[0] = Heap[--size];
			maxHeapify(0);
			return popped;
		}
		System.out.println("Heap has zero elements");
		return -1;
	}

	// 9
	// 10 30 17 3 85 20 8 25 12

	public static void main(String[] arg)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		MaxHeap maxHeap = new MaxHeap(n);
		for(int i=0; i<n; i++)
		{
			 maxHeap.insert(scan.nextInt());
		}		

		maxHeap.print();

		// Print and display the maximum value in heap
		System.out.println("The max val is " + maxHeap.extractMax());

		maxHeap.print();
		System.out.println("The max val is " + maxHeap.extractMax());
		maxHeap.print();
	}
}
