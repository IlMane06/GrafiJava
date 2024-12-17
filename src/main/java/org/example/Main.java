package org.example;
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();



        // Genera un grafo casuale con 10 vertici
        Grafo randomGrafo = Grafo.generateRandomGraph(388);
        System.out.println("Grafo casuale:");
        randomGrafo.print();
    }
}
