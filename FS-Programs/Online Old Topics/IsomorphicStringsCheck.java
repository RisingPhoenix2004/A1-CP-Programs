/*
 * You are given two strings. Determine whether the first string can be
 * converted to the second
 * by replacing each character with a unique character while preserving the
 * order.
 * 
 * Each character from the first string must map to one and only one character
 * in the second string and vice versa.
 * Note: Two characters in the first string cannot map to the same character in
 * the second.
 * 
 * Explanation:
 * ------------
 * Two strings are isomorphic if:
 * • Each character in the first-string maps to one unique character in the
 * second string.
 * • This mapping must be consistent throughout the string.
 * • No two different characters from the first-string map to the same character
 * in the second string.
 * 
 * 
 * Input Format:
 * -------------------
 * Line-1: two space-separated strings
 * 
 * Output Format:
 * ----------------------
 * Line-1: Boolean value True/False
 * 
 * 
 * Sample Input-1:
 * ---------------
 * ACAB XCXY
 * 
 * Sample Output:
 * ----------------------
 * True
 * 
 * Explanation:
 * ------------
 * A → X, C → C, B → Y — all mappings are unique and consistent.
 * 
 * 
 * Sample Input:
 * ---------------------
 * FOO BAR
 * 
 * Sample Output:
 * ----------------------
 * False
 * 
 */
import java.util.*;
public class IsomorphicStringsCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(areIsomorphic(s1, s2));
    }
    public static boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            char from = s1.charAt(i);
            char to = s2.charAt(i);
            if (map1.containsKey(from)) {
                if (map1.get(from) != to) return false;
            } else {
                if (mapped.contains(to)) return false;
                map1.put(from, to);
                mapped.add(to);
            }
        }
        return true;
    }
}