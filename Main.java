import java.util.*;

class Grafo {
    private Map<Integer, List<Integer>> adjList;

    public Grafo(int V) {
        adjList = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adjList.get(v).add(w);
    }

    public void printAllNodes() {
        for (int node : adjList.keySet()) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}

public class Main{
    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Tutti i nodi del grafo:");
        g.printAllNodes();
    }
}