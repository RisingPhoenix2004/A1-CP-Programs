
//implement SuffixTree logic
import java.util.*;

class SuffixTree {
    static final int NUM_CHARS = 26;

    // SuffixTrie node
    static class SuffixTrieNode {
        SuffixTrieNode[] children = new SuffixTrieNode[NUM_CHARS];

        // isEndOfWord is true if the node represents end of a word
        boolean isEndOfWord;

        SuffixTrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < NUM_CHARS; i++)
                children[i] = null;
        }
    };

    static SuffixTrieNode root;

    // If not present, inserts word into SuffixTrie
    // If the word is prefix of SuffixTrie node, just marks leaf node
    static void insert(String word) {
        SuffixTrieNode node = root;
        int level;
        for (level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new SuffixTrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    // To check if current node is leaf node or not
    static boolean isLeafNode(SuffixTrieNode root) {
        return root.isEndOfWord == true;
    }

    // print SuffixTrie
    static void print(SuffixTrieNode root, char[] str, int level) {
        if (isLeafNode(root)) {
            for (int k = level; k < str.length; k++)
                str[k] = 0;
            System.out.println(str);
        }
        for (int i = 0; i < NUM_CHARS; i++) {
            if (root.children[i] != null) {
                str[level] = (char) (i + 'a');
                print(root.children[i], str, level + 1);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        root = new SuffixTrieNode();
        for (int i = 0; i < s.length(); i++) {
            insert(s.substring(i));
        }
        char[] ch = new char[100];
        print(root, ch, 0);
    }
}