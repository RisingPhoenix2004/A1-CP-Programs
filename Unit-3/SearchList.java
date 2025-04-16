/*You are working on strings, list of words are given as source and 
list of words are given as target, you need to find words from target list are present in the source list or not.
if a word is present then print true otherwise print false. 

NOTE: Use Trie Datastructure

Input Format:
-------------
Line-1: A single integer N
Line-2: List contains N space separated words of source list.
Line-3: A single integer M
Line-4: List contains contain M space separated words of target list.

Output Format:
---------------
Line-1: List contains true or false

Sample Input-1:
---------------
5
abc def ghi jkl mno
4
abc fed ghi lkj

Sample Output-1: 
----------------
[true,false,true,false]

Sample Input-2:
---------------
10
a b c d e f g h i j
5
abc d ef g j

Sample Output-2:
----------------
[false, true, false, true, true] */
import java.util.*;

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (idx < 0 || idx >= 26 || curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }
}

public class SearchList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] source = sc.nextLine().split(" ");

        int m = Integer.parseInt(sc.nextLine());
        String[] target = sc.nextLine().split(" ");

        Trie trie = new Trie();
        for (String word : source) {
            trie.insert(word);
        }

        List<Boolean> result = new ArrayList<>();
        for (String word : target) {
            result.add(trie.search(word));
        }

        System.out.println(result);
    }
}