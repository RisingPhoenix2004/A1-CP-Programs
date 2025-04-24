/*An 8th standard student has been assigned a task as part of punishment for his mistake.

The task is, there is an input string STR(without any space) and an array of 
strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
index and ending index of every string in words[] in the input string STR.

Note: Print the pairs[s, e] in sorted order.
(i.e., sort them by their first coordinate, and in case of ties sort them by 
their second coordinate).

Input Format
------------
Line-1: string STR(without any space)
Line-2: space separated strings, words[]

Output Format
-------------
Print the pairs[s, e] in sorted order.


Sample Input-1:
---------------
thekmecandngitcolleges
kmec ngit colleges

Sample Output-1:
----------------
3 6
10 13
14 21


Sample Input-2:
---------------
xyxyx
xyx xy

Sample Output-2:
----------------
0 1
0 2
2 3
2 4

Explanation: 
------------
Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


Sample Input-3:
---------------
kmecngitkmitarecsecolleges
kmit ngit kmec cse

Sample Output-3:
----------------
0 3
4 7
8 11
15 17
 */
import java.util.*;

class Solution {
    public int[][] indexPairs(String str, String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            Trie cur = trie;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie();
                }
                cur = cur.children[c - 'a'];
            }
            cur.end = true; 
        }

        int len = str.length();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            Trie cur = trie;
            char cc = str.charAt(i);
            int j = i;

            while (cur.children[cc - 'a'] != null) {
                cur = cur.children[cc - 'a'];
                if (cur.end) {
                    list.add(new int[]{i, j});
                }
                j++;
                if (j == len) {
                    break;
                } else {
                    cc = str.charAt(j);
                }
            }
        }

        int size = list.size();
        int[][] res = new int[size][2];
        int i = 0;
        for (int[] r : list) {
            res[i] = r;
            i++;
        }
        return res;
    }
}

class Trie {
    Trie[] children;
    boolean end;

    public Trie() {
        end = false;
        children = new Trie[26];
    }
}

class IndexPairs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String words[] = sc.nextLine().split(" ");
        int res[][] = new Solution().indexPairs(str, words);
        for (int[] ans : res) {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}


// import java.util.*;
// class IndexPairs{
//     public static void main(String... args){
//         Scanner sc = new Scanner(System.in);
//         String s = sc.nextLine();
//         String[] words = sc.nextLine().split(" ");
//         ArrayList<int[]> pairs = new ArrayList<>();
//         for (String w : words){
//             int start = 0;
//             while((start = s.indexOf(w, start))!= -1){
//                 pairs.add(new int[]{start, start + w.length() - 1});
//                 start ++;
//             }
//         }
//         pairs = sortpairs1(pairs);
//         for(int [] pair : pairs){
//             System.out.println(pair[0] + " " + pair[1]);
//         }
//     }
//     private static ArrayList<int[]> sortpairs1(ArrayList<int[]> pairs){
//         pairs.sort((a,b) -> {
//             if(a[0] == b[0]){
//                 return a[1] - b[1];
//             }
//             return a[0] - b[0];
//         });
//         return pairs;
//     }
// }