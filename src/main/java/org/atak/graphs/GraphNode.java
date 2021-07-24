package org.atak.graphs;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {

  private int value;
  private List<GraphNode> adjacent = new LinkedList<>();

  public GraphNode(final int value) {
    this.value = value;
  }

  public List<GraphNode> getAdjacent() {
    return adjacent;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "GraphNode{" +
        "value=" + value +
        ", adjacent=" + adjacent +
        '}';
  }
}
