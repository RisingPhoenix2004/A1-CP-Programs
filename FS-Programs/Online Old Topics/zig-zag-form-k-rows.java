/*
 * A software engineer is designing a display panel that arranges characters of a given string 
in a decorative wave pattern across multiple lines. 

The panel has k horizontal rows, and characters are written in a downward and then upward zigzag fashion across these rows.
Once all characters are placed in the wave pattern, the engineer wants to read the characters row by row 
to generate the final output that will be printed on the screen.

Input Format:
---------------
Line-1: A string `S` (the message to display)
Line-2: An integer `k` representing the number of rows on the display

Sample Format:
----------------------   
A string — the message as it appears when read row-by-row from the wave pattern

Explanation
------------
We are given a string and a number k, and we want to print the string as if it's written in a zigzag across k rows.

Example 
Input: "THISPROBLEMISAWESOME", k = 4
Row0:   T      	       O       	  A           E
Row1:      H         R   L      S   W       M
Row2:          I   P   	  E   I       E   O
Row3:            S          M           S
Reading row by row:

Output: TOWHLBSMIPEAESM

Sample input: 
----------------
ZIGZAGPATTERN
3
Sample Output:
-----------------
ZATNIZGATRGPE

 */
import java.util.*;
class Main{
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(zigzag(s,k));
    }
    private static String zigzag(String s, int k){
        if(k == 1 || k >= s.length()) return s;
        StringBuilder[] rows = new StringBuilder[k];
        for(int i = 0; i <k;i++){
            rows[i] = new StringBuilder();
        }
        int currow = 0;
        boolean gdown = true;
        for(char c : s.toCharArray()){
            rows[currow].append(c);
            if(currow == 0) gdown = true;
            else if (currow == k-1) gdown = false;
            currow += gdown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows){
            res.append(row);
        }
        return res.toString();
    }
}