/*
 * You are given an array books, where each element represents the time (in minutes) required to read a book. 
You are also given an integer k, which represents the total available reading time in minutes.

Your task is to determine the maximum number of books that can be read within the given time k 
while ensuring that the sum of reading times does not exceed k.

You must find the longest contiguous subarray where the sum of elements is less than or equal to k, 
and return its length.

Input Format:
-------------
Line-1: An integer 'n' representing the number of books.
Line-2: 'n' space-separated integers representing the time (in minutes) required to read each book.
Line-3: An integer 'k', the available reading time in minutes.

Output Format:
--------------
Line-1: An integer representing the maximum number of books that can be read within 'k' minutes.

Sample Input-1:
---------------
8
1 1 2 1 1 1 4 2
8

Sample Output-1:
----------------
6

Explanation:
------------
We must find the longest subarray where the sum is ≤ 8.
Possible valid subarrays: [1, 1, 2, 1, 1, 1], [1, 2, 1, 1, 1], [2, 1, 1, 1], etc.
The longest valid subarray has a length of 6.

Sample Input-2:
---------------
7
2 3 1 2 4 3 1
5

Sample Output-2:
----------------
3

Explanation:
-------------
Possible valid subarrays: [2, 3], [3, 1, 2], [1, 2, 1], [2, 3], etc.
The longest valid subarray has a length of 3.



 */