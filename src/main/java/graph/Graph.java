package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huangyb
 * @date 2020/12/5
 */
public class Graph {

    private int v;

    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }


    public void bfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (Integer i : adj[c]) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                prev[i] = c;
                if (i == t) {
                    print(s, t, prev);
                    System.out.println();
                    return;
                }
                queue.add(i);
            }
        }
    }

    private boolean found = false;

    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        recurDfs(s, t, visited, prev);
        print(s, t, prev);
        System.out.println();
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (Integer i : adj[w]) {
            if (visited[i]) {
                continue;
            }
            prev[i] = w;
            recurDfs(i, t, visited, prev);
        }
    }

    private void print(int s, int t, int[] prev) {
        if (s != t && prev[t] != -1) {
            print(s, prev[t], prev);
        }
        System.out.print(t + " ");
    }


    /**
     * @return
     * 0 - 1 - 2
     * \   \   \
     * 3 - 4 - 5
     *     \ - \
     *     6 - 7
     *
     */
    public static Graph g1() {
        Graph g = new Graph(8);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(3,4);
        g.addEdge(2,5);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(5,7);
        g.addEdge(6,7);
        return g;
    }

    /**
     * @return
     * 0 - 1 - 2
     * \   \   \
     * 3 - 4 - 5
     *  \  \ - \
     *  \ - 6 - 7
     *
     */
    public static Graph g2() {
        Graph g = new Graph(8);
        g.addEdge(0,1);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(3,4);
        g.addEdge(2,5);
        g.addEdge(4,5);
        g.addEdge(4,6);
        g.addEdge(5,7);
        g.addEdge(6,7);
        g.addEdge(3,6);
        return g;
    }

    public static void main(String[] args) {
        Graph g1 = g1();
        System.out.println("===== bfs =====");
        g1.bfs(0, 7);
        System.out.println("===== bfs =====");
        System.out.println("===== dfs =====");
        g1.dfs(0, 7);
        System.out.println("===== dfs =====");
    }
}
