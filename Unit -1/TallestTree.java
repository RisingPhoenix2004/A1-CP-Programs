/*
 * In a forest, There are N redwoord trees in a row.
 * You are given the heights of the trees as heights[],
 * 
 * You are task is to find the longest tree arrangement as follows:
 * - Minimum size of the tree arrangement is 3.
 * - And there exist a Tree-'i' with heights[i], where 0 < i < N-1.
 * - heights[0] < heights[1] < heights[2] <...< heights[i] and
 * - heights[i] > heights[i+1] > heights[i+2] >...>heights[N-1]
 * 
 * And return the length of the longest tree arrangement.
 * If there is no such arrangement, return 0.
 * 
 * Input Format:
 * -------------
 * Line-1: An integer N, number of elements.
 * Line-2: N space separated integers, value of the elements.
 * 
 * Output Format:
 * --------------
 * Print an integer result.
 * 
 * 
 * Sample Input-1:
 * ---------------
 * 8
 * 4 2 5 7 4 2 3 6
 * 
 * Sample Output-1:
 * ----------------
 * 5
 * 
 * Explanation:
 * ------------
 * The longest tree arrangement is : 2 5 7 4 2
 * 
 * 
 * Sample Input-2:
 * ---------------
 * 4
 * 2 4 5 7
 * 
 * Sample Output-2:
 * ----------------
 * 0
 */