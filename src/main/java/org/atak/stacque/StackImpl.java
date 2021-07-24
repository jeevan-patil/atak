package org.atak.stacque;

public class StackImpl {

  private Node top;

  public boolean isEmpty() {
    return (top == null);
  }

  public int peek() {
    return top.data;
  }

  public void push(final int data) {
    final Node node = new Node(data);
    node.next = top;
    top = node;
  }

  public int pop() {
    final int data = top.data;
    top = top.next;
    return data;
  }
}
