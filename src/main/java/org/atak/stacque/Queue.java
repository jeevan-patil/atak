package org.atak.stacque;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Queue {

  private Node head;
  private Node tail;

  public boolean isEmpty() {
    return (head == null);
  }

  public int peek() {
    return head.data;
  }

  // 1-2-4-3
  public void add(final int data) {
    final Node node = new Node(data);

    if (tail != null) {
      tail.next = node;
    }

    tail = node;

    if (head == null) {
      head = node;
    }
  }

  public int remove() {
    final int data = head.data;
    head = head.next;

    if (head == null) {
      tail = null;
    }

    return data;
  }

  @Override
  public String toString() {
    final List<Integer> elements = new LinkedList<>();
    if (head != null) {
      Node node = head;
      elements.add(node.data);
      while (Objects.nonNull(node.next)) {
        elements.add(node.next.data);
        node = node.next;
      }

      return elements.toString();
    }
    return "empty";
  }
}
