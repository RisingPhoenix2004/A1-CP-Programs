// Program to implement Disjoint Set Data Structure.

/*
5 = number of friends
3 = number of relationships
2 = number of friendship check
input=5
3
0 2
4 2
3 1
2
4 0
1 0
output=4 is a friend of 0
1 is not a friend of 0

*/
import java.io.*;
import java.util.*;

class DisjointUnionSets {
    int[] rank, parent;
    int n;

    public DisjointUnionSets(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    // Creates n sets with single item in each
    void makeSet() {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Returns representative of x's set
    int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return find(parent[x]);

    }

    // Unites the set that includes x and the set that includes x
    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot)
            return;
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] > rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}

class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fn = sc.nextInt();
        DisjointUnionSets dus = new DisjointUnionSets(fn);
        int rr = sc.nextInt();
        for (int i = 0; i < rr; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            dus.union(x, y);
        }
        int j = sc.nextInt();
        for (int m = 0; m < j; m++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int z = dus.find(u);
            int h = dus.find(v);
            if (z == h)
                System.out.println(u + " is a friend of " + v);
            else
                System.out.println(u + " is not a friend of " + v);
        }
    }
}
