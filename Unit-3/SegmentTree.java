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