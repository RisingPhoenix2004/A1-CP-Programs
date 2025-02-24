// AlphaCipher is a string formed from another string by rearranging its letters

// You are given a string S.
// Your task is to check, can any one of the AlphaCipher is a palindrome or not.

// Input Format:
// -------------
// A string S

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// carrace

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// code

// Sample Output-2:
// ----------------
// false
import java.util.*;
class PalindromePermutation{
    static boolean isPalindromePermutation(String s){
        int bitmask=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int diff=ch-'a';
            bitmask=bitmask ^ (1<<diff);
        }
        
        int x=bitmask & (bitmask-1);
        if(bitmask==0){
            return true;
        }
        else if( x== 0){
           return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(isPalindromePermutation(s));
    }
}