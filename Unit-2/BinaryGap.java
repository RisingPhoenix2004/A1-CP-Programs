
import java.util.Scanner;

/*You are given a positive integer n. 
Your task is to determine the longest distance between any two adjacent 1s in its binary representation.

Definitions:
Two 1s are considered adjacent if there are only 0’s separating them (possibly no 0’s).
The distance between two adjacent 1’s is the absolute difference between their bit positions.
If there are no two adjacent 1's, return 0.

For example, the two 1's in "1001" have a distance of 3.

Input Format:
-------------
Line-1: An integer number

Output Format:
--------------
Line-1: An integer number

Sample Input-1:
---------------
22

Sample Output-1:
----------------
2

Explanation:
------------
Binary representation of 22 is "10110".
Adjacent 1s appear at positions: (1,3) and (3,4)
Distances: 3 - 1 = 2, 4 - 3 = 1
Maximum distance is 2.

Sample Input-2:
---------------
8

Sample Output-2: 
----------------
0

Explanation:
-------------
Binary representation of 8 is "1000".
There is only one 1, so no adjacent pairs exist.
Output is 0. */
public class BinaryGap {
    static int binaryGap(int n) {
        int count=0;
        int max=Integer.MIN_VALUE;
        while(n>0){
            if((n&1)==1){
                max=Math.max(count,max);
                count=1;
            }
            else if(count>0){
                count++;
            }
            n=n>>1;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(binaryGap(n));
    }
}