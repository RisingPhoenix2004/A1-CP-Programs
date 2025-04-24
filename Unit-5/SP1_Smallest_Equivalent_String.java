/*
 * Vihaar is working with strings.
 * He is given two strings A and B, and another string T,
 * where the length of A and B is same.
 * 
 * You can find the relative groups of letters from A and B,
 * using the following rule set:
 * - Equality rule: 'p' == 'p'
 * - Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
 * - Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
 * 
 * Vihaar has to form the relatively smallest string of T,
 * using the relative groups of letters.
 * 
 * For example, if A ="pqr" and B = "rst" ,
 * then we have 'p' == 'r', 'q' == 's', 'r' == 't' .
 * 
 * The relatives groups formed using above rule set are as follows:
 * [p, r, t] and [q,s] and String T ="tts", then relatively smallest string is
 * "ppq".
 * 
 * You will be given the strings A , B and T.
 * Your task is to help Vihaar to find the relatively smallest string of T.
 * 
 * 
 * Input Format:
 * -------------
 * Three space separated strings, A , B and T
 * 
 * Output Format:
 * --------------
 * Print a string, relatively smallest string of T.
 * 
 * 
 * Sample Input-1:
 * ---------------
 * kmit ngit mgit
 * 
 * Sample Output-1:
 * ----------------
 * ggit
 * 
 * Explanation:
 * ------------
 * The relative groups using A nd B are [k, n], [m, g], [i], [t] and
 * the relatively smallest string of T is "ggit"
 * 
 * 
 * Sample Input-2:
 * ---------------
 * attitude progress apriori
 * 
 * Sample Output-2:
 * ----------------
 * aaogoog
 * 
 * Explanation:
 * ------------
 * The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d,
 * s]
 * the relatively smallest string of T is "aaogoog"
 */
import java.util.*;

class SmallestString {
    private class UnionFind {
        private int[] parent;

        private UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int getAbsoluteParent(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = getAbsoluteParent(parent[i]);
            return parent[i];
        }

        private void unify(int i, int j) {
            int absoluteParentI = getAbsoluteParent(i);
            int absoluteParentJ = getAbsoluteParent(j);
            if (absoluteParentI < absoluteParentJ) {
                parent[absoluteParentJ] = absoluteParentI;
            } else {
                parent[absoluteParentI] = absoluteParentJ;
            }
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            int charS1 = s1.charAt(i) - 'a';
            int charS2 = s2.charAt(i) - 'a';
            uf.unify(charS1, charS2);
        }
        for (int i = 0; i < baseStr.length(); i++) {
            int smallestMappedChar = uf.getAbsoluteParent(baseStr.charAt(i) - 'a');
            sb.append((char) (smallestMappedChar + 'a'));
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        String T = sc.next();
        SmallestString l = new SmallestString();  // Fixed class name here
        System.out.println(l.smallestEquivalentString(A, B, T));
    }
}