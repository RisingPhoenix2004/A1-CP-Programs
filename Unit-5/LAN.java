
/*In your computer lab, network switches are connected using Ethernet cables to form a LAN. 
However, a new hardware technician inadvertently connected switches in a way that created a cycle,
resulting in a network loop. 
As a consequence, the network has become unstable. You need to identify and remove the specific cable that 
is causing the loop. 
If there are multiple cables contributing to the loop, you should remove the one that was most recently added

Sample Input-1:
---------------
3
0 1
0 2
1 2

Sample Output-1:
----------------
[1 2]

Sample Input-2:
---------------
5
0 1
1 2
2 3
0 3
0 4

Sample Output-2:
----------------
[0,3]
 

Constraints:
------------
-> n == edges.length
-> 3 <= n <= 1000
-> edges[i].length == 2
-> 1 <= ai < bi <= edges.length
-> ai != bi
-> There are no repeated edges.
-> The given graph is connected. */
import java.util.*;

class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
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

class LAN {
    public static void findCycle(List<Edge> edges, int n) {
        DisjointSet ds = new DisjointSet(n);
        Edge lastCycleEdge = null;
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int parentU = ds.find(u);
            int parentV = ds.find(v);
            if (parentU == parentV) {
                lastCycleEdge = edge;
            } else {
                ds.union(parentU, parentV);
            }
        }
        if (lastCycleEdge != null) {
            System.out.println("[" + lastCycleEdge.source + "," + lastCycleEdge.dest + "]");
        } else {
            System.out.println("[]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Edge> edges = new ArrayList<>();
        int e = sc.nextInt();
        int MaxNode = Integer.MIN_VALUE;
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            MaxNode = Math.max(source, MaxNode);
            MaxNode = Math.max(destination, MaxNode);
            edges.add(new Edge(source, destination));
        }
        findCycle(edges, MaxNode + 1);
    }
}