import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Grafo {
    int Vertici; // Numero di vertici
    LinkedList<Integer> adj[]; // Lista di adiacenza

    // Costruttore
    Grafo(int vertici) {
        Vertici = vertici;
        adj = new LinkedList[vertici];
        for (int i = 0; i < vertici; ++i){
            adj[i] = new LinkedList();
        }
    }

    // Aggiunge un arco da s a d
    void addEdge(int s, int d) {
        adj[s].add(d);
    }

    // BFS a partire dal nodo s
    void BFS(int s) {
        boolean visited[] = new boolean[Vertici];

        // Crea una coda per la BFS
        Queue<Integer> queue = new LinkedList<Integer>();

        // Mark il nodo corrente come visitato e aggiungilo alla coda
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue un vertice dalla coda e stampalo
            s = queue.poll();
            System.out.print(s + " ");

            // Ottieni tutti i vertici adiacenti del vertice dequed
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}