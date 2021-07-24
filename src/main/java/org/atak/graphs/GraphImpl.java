package org.atak.graphs;

public class GraphImpl {

  public static void main(String[] args) {
    final Graph graph = new Graph(3);
    graph.addEdge(3, 4);
    graph.addEdge(3, 2);
    graph.addEdge(4,5);
    graph.addEdge(5, 9);

    System.out.println(graph);

    System.out.println(graph.hasPathBfs(5, 9));
  }
}
