/*
 * Given a string s, reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael
 */
import java.util.*;
class ReverseVowels{
    static String reverseVowels(char[] arr){
        ArrayList<Character> vowels= new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int left=0;
        int right=arr.length-1;
        while(left<right){
            if(vowels.contains(arr[left]) && vowels.contains(arr[right])){
                char temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
            else if(vowels.contains(arr[left]) && !vowels.contains(arr[right])){
                right--;
            }
            else{
                left++;
            }
        }
        String s = new String(arr);
        
        return s;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        System.out.println(reverseVowels(arr));
        
    }  
}