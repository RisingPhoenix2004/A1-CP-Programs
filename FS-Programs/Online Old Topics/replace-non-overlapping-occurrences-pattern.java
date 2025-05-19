/*
 * A text editor application allows users to perform automated corrections in documents. 
The feature scans the document and replaces every distinct instance of a specified incorrect phrase with a corrected one.
However, to avoid infinite loops and ambiguity, the editor replaces only non-overlapping occurrences of the phrase from left to right, one at a time.

Input Format:
-------------------------  
Line-1: A string `S` representing the original word
Line-2: A string `P` representing the pattern to be replaced
Line-3: A string `R` representing the replacement phrase (Special character) 

Output Format:
-------------------------
A string with all non-overlapping occurrences of `P` in `S` replaced with `R`

Example
--------
Input:
word = "ABCABCXABC";
pattern = "ABC";
ch = '@';
Explanation:
Original string:  A B C A B C X A B C
                  [ABC] [ABC]   [ABC] → all 3 are non-overlapping
Output:@ @ X @

Sample Input:
-------------------- 
ABABABAB
AB
@
Sample Output:
-----------------------
@@@@

 */
import java.util.*;
import java.util.regex.*;
class Main{
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        String r = sc.nextLine();
        if((s.isEmpty()) || (p.isEmpty())|| (r.isEmpty())) {
            System.out.println(s);
            return;
        }
        Pattern pattern = Pattern.compile(p);
        Matcher matcher = pattern.matcher(s);
        String result = matcher.replaceAll(r);
        System.out.println(result);
    }
}

/*Alternate Code */
// import java.util.*;
// public class Main{
//     public static void main(String args[]){
//         Scanner sc=new Scanner(System.in);
//         String word=sc.next();
//         String pattern=sc.next();
//         Character c=sc.next().charAt(0);
//         if(word.isEmpty() || pattern.isEmpty() || c==null){
//             System.out.println(word);
//             return;
//         }
//         int i=0,j=0;
//         StringBuilder result=new StringBuilder();
//         while(i<word.length()){
//             if(word.charAt(i)==pattern.charAt(j)){
//                 i++;
//                 j++;
//                 if(j==pattern.length()){
//                     result.append(c);
//                     j=0;
//                 }
//             }
//             else{
//                 if(j>0){
//                     i=i-j+1;
//                     result.append(word.charAt(i-1));
//                     j=0;
//                 }
            
//             else{
//                 result.append(word.charAt(i));
//                 i++;
//             }
//             }
//         }
//         if(j>0){
//             result.append(word.substring(word.length()-j));
//         }
//         System.out.println(result.toString());
//     }
// }