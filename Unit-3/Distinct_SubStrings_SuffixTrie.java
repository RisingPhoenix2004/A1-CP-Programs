/*
A communication researcher is analyzing a trail of signal frequencies encoded as a lowercase string. 
Each character in the string represents a frequency tone recorded in a timeline.

To evaluate the diversity of communication, the researcher wants 
to count how many distinct contiguous frequency patterns (substrings) are present in the entire signal trail. 
These patterns can be of any length and must be unique.

To accomplish this, you are tasked with writing an efficient algorithm using Trie (Prefix Tree) 
based suffix structures to count all distinct substrings of the given signal trail.

Input Format:
-------------
Line-1: A lowercase string s representing the frequency trail.

Output Format:
--------------
Line-1: Print a single integer — the number of distinct substrings of the input string.

Constraints:
-------------
-> 1 ≤ |s| ≤ 10^4
-> s contains only lowercase English letters.


Sample Input-1:
---------------
abc

Sample Output-1:
----------------
6

Explanation:
------------
The substrings are: "a", "b", "c", "ab", "bc", "abc".
Total = 6 distinct substrings.


Sample Input-1:
---------------
abc

Sample Output-1:
----------------
6

Explanation:
------------
The substrings are: "a", "b", "c", "ab", "bc", "abc".
Total = 6 distinct substrings.


Sample Input-2:
---------------
aaa

Sample Output-2:
----------------
3

Explanation:
------------
Substrings: "a", "aa", "aaa" → 3 unique substrings. */

// To find the count of distinct substring of a string using trie data structure

import java.util.*;

class Suffix {
    // A Suffix Trie (A Trie of all suffixes) Node
    static class SuffixTrieNode {
        static final int MAX_CHAR = 26;
        SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];

        SuffixTrieNode() // Constructor
        {
            // Initialize all child pointers as NULL
            for (int i = 0; i < MAX_CHAR; i++)
                children[i] = null;
        }

        // A recursive function to insert a suffix of the s in
        // subtree rooted with this node
        void insertSuffix(String s) {
            // System.out.println("string " + s);
            // If string has more characters
            if (s.length() > 0) {
                // Find the first character and convert it into 0-25 range.
                char cIndex = (char) (s.charAt(0) - 'a');

                // If there is no edge for this character, add a new edge
                if (children[cIndex] == null) {
                    children[cIndex] = new SuffixTrieNode();
                }

                // Recur for next suffix
                children[cIndex].insertSuffix(s.substring(1));
            }
        }
    }

    // A Trie of all suffixes
    static class Suffix_trie {
        static final int MAX_CHAR = 26;
        SuffixTrieNode root;

        // Constructor (Builds a trie of suffies of the given text)
        Suffix_trie(String s) {
            root = new SuffixTrieNode();

            // Consider all suffixes of given string and insert them into the
            // Suffix Trie using recursive function insertSuffix() in SuffixTrieNode class
            for (int i = 0; i < s.length(); i++)
                root.insertSuffix(s.substring(i));
        }
    }

    static int countDistinctSubstring(SuffixTrieNode root) {
        // Write your code here
        if (root == null)
            return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countDistinctSubstring(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any string to construct suffix tree");
        String str = sc.nextLine();
        Suffix_trie trie = new Suffix_trie(str);
        System.out.println((countDistinctSubstring(trie.root) - 1));

    }
}
