/*You are navigating two parallel highways, each containing a series of checkpoints. Each checkpoint has a score value. 
These highways may have some common checkpoints (same score values) at certain positions.

You start your journey on either of the two highways and must collect as many checkpoint scores as possible. 
The rules are:
-> You move only in the forward direction on any highway.
-> At a common checkpoint (same value in both highways), you are allowed to switch from one highway to the other (or choose to stay).
-> You can switch highways multiple times, but only at these common checkpoints.

Your goal is to determine the maximum total score you can collect from start to finish, by choosing the optimal path and switches.

Input Format:
-------------
Line-1: An integer n, representing the number of checkpoints on Highway A.
Line-2: A line with n space-separated integers — the checkpoint scores on Highway A, in increasing order.
Line-3: An integer m, representing the number of checkpoints on Highway B.
Line-4: A line with m space-separated integers — the checkpoint scores on Highway B, in increasing order.

Output Format:
---------------
Line-1: Print a single integer — the maximum score you can collect by traversing the highways optimally.
Since the answer can be very large, return the result modulo 10^9 + 7.

Sample Input-1:
---------------
5  
2 4 5 8 10  
4  
4 6 8 9  

Sample Output-1:
----------------
30

Explanation:
-------------
Refer Hint image

Sample Input-2:
---------------
3  
1 3 5  
3  
2 3 4  

Sample Output-2:
----------------
10

Explanation:
------------
Go through 1 (A), switch at 3 to B, then pick 4 → 1 + 3 + 4 = 8
Alternatively: 2 + 3 + 5 = 10

Best score = 10


Constraints:
------------
-> 1 ≤ n, m ≤ 10^5
-> 1 ≤ checkpoint[i] ≤ 10^7
-> Checkpoints in both highways are strictly increasing */
