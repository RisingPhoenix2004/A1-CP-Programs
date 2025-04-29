
/*Mr. Balu is interested in solving puzzles. 
One puzzle involves a given number of nodes and undirected paths between these nodes. 

He needs to determine whether he can exit from path loop or not. 
If at least one cycle can be formed with the given paths, then he cannot exit.

Input Format:
-------------
Line-1: Two integers n and e, n, number of nodes and e number of edges
Line-2 to e: e number of integer pairs, space separated

Output Format:
--------------
Line-1: A string, Cycle_found or No_Cycle_Found

Sample Input-1:
---------------
5 5
0 1
1 2
2 3
3 4
4 0

Sample Output-1:
----------------
Cycle_Found

Sample Input-2:
---------------
5 4
0 1
1 2
2 3
3 4

Sample Output-2:
----------------
No_Cycle_Found */
import java.util.*;

class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}

class Graph {
    List<List<Integer>> adjList = null;

    Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }
}

class DisjointSet {
    private int[] parent;

    public DisjointSet(int V) {
        parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    public int find(int u) {
        return parent[u] == u ? u : (parent[u] = find(parent[u]));
    }

    public void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        parent[y] = x;
    }
}

class Main {
    public static boolean findCycle(Graph graph, int n) {
        // Write your code here and return a boolean value
        DisjointSet ds = new DisjointSet(n);
        for (int u = 0; u < n; u++) {
            for (int v : graph.adjList.get(u)) {
                if (u < v) {
                    int x = ds.find(u);
                    int y = ds.find(v);
                    if (x == y)
                        return true;
                    ds.union(x, y);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        int e = sc.nextInt();
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            edges.add(new Edge(source, destination));
        }
        Graph graph = new Graph(edges, n);
        if (findCycle(graph, n)) {
            System.out.println("Cycle_Found");
        } else {
            System.out.println("No_Cycle_Found");
        }
    }
}
