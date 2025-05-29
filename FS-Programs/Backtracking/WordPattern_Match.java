/*
 * Given two strings S1 and S2, find if S2 can match S1 or not.

A match that is both one-to-one (an injection) and onto (a surjection), 
i.e. a function which relates each letter in string S1 to a separate and 
distinct non-empty substring in S2, where each non-empty substring in S2
also has a corresponding letter in S1.

Return true,if S2 can match S1.
Otherwise false.

Input Format:
-------------
Line-1 -> Two strings S1 and S2

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
abab kmitngitkmitngit

Sample Output-1:
----------------
true


Sample Input-2:
---------------
aaaa kmjckmjckmjckmjc

Sample Output-2:
----------------
true

Sample Input-3:
---------------
mmnn pqrxyzpqrxyz

Sample Output-3:
----------------
false
 */

 import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(wordPatternMatch(s1, s2));
    }
    private static boolean wordPatternMatch(String pattern, String str) {
        return backtrack(pattern, str, new HashMap<>(), new HashSet<>(), 0, 0);
    }
    private static boolean backtrack(String pattern, String str, Map<Character, String> map, Set<String> used, int i, int j) {
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() || j == str.length()) return false;
        char ch = pattern.charAt(i);
        if (map.containsKey(ch)) {
            String mapped = map.get(ch);
            if (!str.startsWith(mapped, j)) return false;
            return backtrack(pattern, str, map, used, i + 1, j + mapped.length());
        }
        for (int k = j; k < str.length(); k++) {
            String sub = str.substring(j, k + 1);
            if (used.contains(sub)) continue;
            map.put(ch, sub);
            used.add(sub);
            if (backtrack(pattern, str, map, used, i + 1, k + 1)) return true;
            map.remove(ch);
            used.remove(sub);
        }
        return false;
    }
}
