/*
 * Given a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".

Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Input Format:
-------------
Line-1: A string, S contains only lowercase letters
Line-2: A string, abbr contains lowercase letters and digits

Output Format:
--------------
Line-1: A boolean value.
Sample Input-1:
---------------
internationalization
i12iz4n

Sample Output-1:
---------------
true

Sample Input-2:
---------------
apple
a2e

Sample Output-2:
---------------
false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1).
 */

import java.util.*;
class ValidWordAbbreviation{
    static boolean isValid(String word, String abbr){
        ArrayList<Character> nums = new ArrayList<>();
        nums.add('1');
        nums.add('2');
        nums.add('3');
        nums.add('4');
        nums.add('5');
        nums.add('6');
        nums.add('7');
        nums.add('8');
        nums.add('9');
        nums.add('0');
        int left=0;
        int right=0;
        int res=0;
        while(left<word.length() && right<abbr.length()){
            if(nums.contains(abbr.charAt(right))){
                int a= Character.getNumericValue(abbr.charAt(right));
                res=(res*10)+a;
                right++;
                // continue;
            }
            else if(res!=0){
                left+=res;
                res=0;
            }
            else if(word.charAt(left) == abbr.charAt(right)){
                left++;
                right++;
            }
            else{
                return false;
            }
            // left++;
            // right++;
        }
        if(res!=0){
                left+=res;
        }
        return left==word.length() && right==abbr.length();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String abbr=sc.next();
        System.out.println(isValid(s,abbr));
        sc.close();
    }
}