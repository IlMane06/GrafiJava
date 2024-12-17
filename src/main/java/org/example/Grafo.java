package org.example;

import java.util.*;

public class Grafo {
    private HashSet<Vertice> V; // Vertici del grafo
    private Hashtable<Integer, List<Vertice>> E; // Liste di adiacenza per gli archi

    public Grafo() {
        V = new HashSet<>();
        E = new Hashtable<>();
    }

    public void add(int i, int j) {
        Vertice v1 = new Vertice(i, "Vertice " + i);
        Vertice v2 = new Vertice(j, "Vertice " + j);

        // creazione di vertici se non esistono
        if (!V.contains(v1)) {
            V.add(v1);
            E.put(i, new ArrayList<>());
        }
        if (!V.contains(v2)) {
            V.add(v2);
            E.put(j, new ArrayList<>());
        }

        // dovrebbe aggiungere archi
        E.get(i).add(v2);
        E.get(j).add(v1);
    }

    public void print() {
        for (Map.Entry<Integer, List<Vertice>> entry : E.entrySet()) {
            System.out.print(entry.getKey() + 1 + ": ");
            for (Vertice v : entry.getValue()) {
                System.out.print(v.getId() + " ");
            }
            System.out.println();
        }
    }


    public static Grafo generateRandomGraph(int n) {
        Grafo graph = new Grafo();

        // Genera una matrice di adiacenza casuale
        Random rand = new Random();
        int[][] adjMatrix = new int[n][n];

        // Popola la matrice con valori casuali 0 o 1, senza cicli o cappi
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rand.nextInt(2) == 1) {
                    adjMatrix[i][j] = 1;
                    adjMatrix[j][i] = 1;
                }
            }
        }

        // Converte la matrice in liste di adiacenza
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjMatrix[i][j] == 1) {
                    graph.add(i, j);
                }
            }
        }

        return graph;
    }
}

