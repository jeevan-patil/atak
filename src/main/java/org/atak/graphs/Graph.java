package org.atak.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

  private GraphNode root;
  private Map<Integer, GraphNode> lookup = new HashMap<>();

  public Graph(final int value) {
    this.root = new GraphNode(value);
    lookup.put(value, root);
  }

  public GraphNode getNode(final int id) {
    return lookup.get(id);
  }

  public void addEdge(final int source, final int destination) {
    if (!lookup.containsKey(destination)) {
      final GraphNode node = new GraphNode(destination);
      lookup.put(destination, node);
    }

    final GraphNode sourceNode = getNode(source);
    final GraphNode destinationNode = getNode(destination);
    sourceNode.getAdjacent().add(destinationNode);
  }

  public boolean hasPathDfs(final int source, final int destination) {
    final GraphNode sourceNode = getNode(source);
    final GraphNode destNode = getNode(destination);

    Set<Integer> visited = new HashSet<>();
    return hasPathDfs(sourceNode, destNode, visited);
  }

  public boolean hasPathBfs(final int source, final int destination) {
    final GraphNode sourceNode = getNode(source);
    final GraphNode destNode = getNode(destination);
    return hasPathBfs(sourceNode, destNode);
  }


  private boolean hasPathDfs(final GraphNode source, final GraphNode destination,
      final Set<Integer> visited) {
    if (visited.contains(source.getValue())) {
      return false;
    }

    visited.add(source.getValue());

    if (source == destination) {
      return true;
    }

    for (final GraphNode child : source.getAdjacent()) {
      if (hasPathDfs(child, destination, visited)) {
        return true;
      }
    }

    return false;
  }

  private boolean hasPathBfs(final GraphNode source, final GraphNode destination) {
    final Queue<GraphNode> nodesToVisit = new LinkedList<>();
    final Set<Integer> visited = new HashSet<>();

    nodesToVisit.add(source);

    while (!nodesToVisit.isEmpty()) {
      final GraphNode node = nodesToVisit.poll();

      if (node == destination) {
        return true;
      }

      if (visited.contains(node.getValue())) {
        continue;
      }

      visited.add(source.getValue());
      nodesToVisit.addAll(node.getAdjacent());
    }

    return false;
  }

  @Override
  public String toString() {
    return "" + lookup + "";
  }
}
