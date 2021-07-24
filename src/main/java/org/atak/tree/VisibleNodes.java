package org.atak.tree;

import java.io.IOException;
import java.util.LinkedList;

public class VisibleNodes {


  int visibleNodes(Node root) {
    if (root == null) {
      return 0;
    }

    int count = 0;

    java.util.Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int n = queue.size();

      for (int i = 0; i < n; i++) {
        if (i == 0) {
          count++;
        }

        Node curr = queue.poll();
        if (curr.left != null) {
          queue.add(curr.left);
        }

        if (curr.right != null) {
          queue.add(curr.right);
        }
      }
    }

    return count;
  }

  class Node {

    int data;
    Node left;
    Node right;

    Node() {
      this.data = 0;
      this.left = null;
      this.right = null;
    }

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  public void run() throws IOException {

    Node root_1 = new Node(8);
    root_1.left = new Node(3);
    root_1.right = new Node(10);
    root_1.left.left = new Node(1);
    root_1.left.right = new Node(6);
    root_1.right.right = new Node(14);
    root_1.left.right.left = new Node(4);
    root_1.left.right.right = new Node(7);
    root_1.right.right.left = new Node(13);
    int expected_1 = 4;
    int output_1 = visibleNodes(root_1);
    System.out.println("expected_1 :" + expected_1 + " and output_1 :" + output_1);

    Node root_2 = new Node(10);
    root_2.left = new Node(8);
    root_2.right = new Node(15);
    root_2.left.left = new Node(4);
    root_2.left.left.right = new Node(5);
    root_2.left.left.right.right = new Node(6);
    root_2.right.left = new Node(14);
    root_2.right.right = new Node(16);

    int expected_2 = 5;
    int output_2 = visibleNodes(root_2);
    System.out.println("expected_2 :" + expected_1 + " and output_2 :" + output_1);
  }

  public static void main(String[] args) throws IOException {
    new VisibleNodes().run();
  }
}
