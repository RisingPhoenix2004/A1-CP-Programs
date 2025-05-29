/*
 * In the ancient land of Palindoria, wizards write magical spells as strings of lowercase letters. However, for a spell to be effective, each segment of the spell must read the same forward and backward.

Given a magical spell 'spell', your task is to partition it into sequences of valid magical spell segments. 

Your goal is to help the wizard discover all valid combinations of magical spell segmentations.

Sample Input-1:
---------------
aab
  
Sample Output-1:  
----------------
[[a, a, b], [aa, b]]

Sample Input-2:
--------------- 
a
  
Sample Output-2:  
----------------
[[a]]

Spell Constraints:
------------------
- The length of the spell is between 1 and 16 characters.  
- The spell contains only lowercase English letters.  

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<List<String>> res = new ArrayList<>();
        findPart(0, s, new ArrayList<>(), res);
        System.out.println(res);
    }
    private static void findPart(int index, String s, List<String> current, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (isPalindrome(sub)) {
                current.add(sub);
                findPart(i + 1, s, current, res);
                current.remove(current.size() - 1);
            }
        }
    }
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}