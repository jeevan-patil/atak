package org.atak.tree;

import java.util.LinkedList;

public class PrintRightView {

  public static void main(String[] args) {
    final Node tree = new Node(12);
    tree.left = new Node(10);
    tree.right = new Node(30);
    tree.right.left = new Node(25);
    tree.right.right = new Node(40);
    printRightView(tree);
  }

  private static void printRightView(Node root) {
    if (root == null) {
      return;
    }

    java.util.Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int n = queue.size();

      for (int i = 1; i <= n; i++) {
        Node node = queue.poll();

        if (i == n) {
          System.out.print(node.data + " ");
        }

        if (node.left != null) {
          queue.add(node.left);
        }

        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
  }
}
