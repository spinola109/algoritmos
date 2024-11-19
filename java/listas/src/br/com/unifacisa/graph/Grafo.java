package br.com.unifacisa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

    private int numVertices;
    private List<List<Integer>> adjacencyList;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            this.adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w) {
        // v = origem, w = destino
        adjacencyList.get(v).add(w);
        adjacencyList.get(w).add(v); // Grafo não direcionado
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        // Marca o nó inicial como visitado e o insere na fila
        visited[start] = true;
        queue.add(start);

        System.out.println("Busca em Largura iniciando no vértice: " + start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            // Para cada vizinho não visitado, marca como visitado e adiciona à fila
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numVertices; i++) {
            sb.append("Vértice ").append(i).append(": ");
            for (Integer neighbor : adjacencyList.get(i)) {
                sb.append(" -> ").append(neighbor);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        grafo.addEdge(0, 1);
        grafo.addEdge(0, 4);
        grafo.addEdge(1, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(1, 4);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 4);

        System.out.println(grafo.toString());

        // Executa a Busca em Largura começando do vértice 0
        grafo.bfs(0);
    }
}
