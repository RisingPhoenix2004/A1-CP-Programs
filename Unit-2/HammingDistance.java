// Mr.Sathya is playing with numbers he converts the decimal to binary 
// and try to find number of positions at which the corresponding
// bits are different. 
// Help sathya by giving solution to the problem 
// to find sum of bits differences between all the pairs of the 
// integers in given numbers.

// Input Format:
// --------------
// Line-1: N, Number of integers
// Line-2: N space separated list of integers

// Output Format:
// ---------------
// Line-1: A integer, Return the sum of bit differences between all the pairs of the integers.
 
// Sample Input-1:
// ---------------
// 3
// 4 14 2

// Sample Output-1: 
// ----------------
// 6

// Explanation: 
// ------------
// In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just showing the four bits relevant in this case).
// The answer will be:
// HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

// Sample Input-2: 
// ---------------- 
// 3
// 4 14 4

// Sample Output-2: 
// ----------------
// 4