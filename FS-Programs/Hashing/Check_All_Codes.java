/*
 * In the high-stakes world of interstellar espionage, 
Agent Cipher intercepts a binary message stream. 
Each possible K-bit command code (from 000…0 to 111…1) must appear in the log to validate the transmission’s integrity. 
If any K-bit pattern is missing, the message is compromised and the mission fails.

You are given:
	A binary string S (only characters '0' and '1').
	An integer K.

Determine whether every binary code of length K appears at least once as a contiguous substring in S.

Input Format:
-------------
Line 1: the binary string S.
Line 2: the integer K.

Output Format:
--------------
Print true if all 2^K binary codes of length K are present in S; otherwise print false.

Sample Input-1:
---------------
00110110
2

Sample Output-1:
----------------
true

Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.

Sample Input-2:
---------------
0110
2

Sample Output-2:
----------------
false

Explanation: The binary code "00" is of length 2 and does not exist in the array.

Sample Input-3:
---------------
0110
1

Sample Output-3:
----------------
true

Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring.
 */
import java.util.*;
class Sol{
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(ischeck(s,k));
    }
    private static boolean ischeck(String s, int k){
        HashSet<String> hs = new HashSet<>();
        if( k > s.length()) return false;
        for(int i = 0; i <= s.length() - k; i++){
            hs.add(s.substring(i,i+k));
        }
        return hs.size() == (1 << k);
    }
}