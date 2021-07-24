package org.atak.tree;

import java.util.LinkedList;

public class PrintLeftView {

  public static void main(String[] args) {
    final Node tree = new Node(12);
    tree.left = new Node(10);
    tree.right = new Node(30);
    tree.right.left = new Node(25);
    tree.right.right = new Node(40);
    printLeftView(tree);
  }

  private static void printLeftView(Node root) {
    if (root == null) {
      return;
    }

    java.util.Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      // number of nodes at current level
      int n = queue.size();

      // Traverse all nodes of current level
      for (int i = 1; i <= n; i++) {
        Node temp = queue.poll();

        // Print the left most element at
        // the level
        if (i == 1) {
          System.out.print(temp.data + " ");
        }

        // Add left node to queue
        if (temp.left != null) {
          queue.add(temp.left);
        }

        // Add right node to queue
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
    }
  }
}
