/*Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
Line-1: An integer I

Output Format:
--------------
Line-2: Print the BBC representation of I.


Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000


Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110
 */

import java.util.*;
class EncodeNumber{
    static StringBuilder encode(int n){
        StringBuilder sb=new StringBuilder();
        int temp=n+1;
        while(temp>0){
            sb.append(temp%2);
            temp=temp/2;
        }
        sb.reverse();
        sb.deleteCharAt(0);
        return sb;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(encode(n));
    }
}