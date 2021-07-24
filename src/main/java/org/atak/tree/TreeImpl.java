package org.atak.tree;

public class TreeImpl {

  public static void main(String[] args) {
    final Node root = new Node(10);
    root.insert(5);
    root.insert(3);
    root.insert(15);
    root.insert(13);
    root.insert(17);
    root.insert(8);

    System.out.println(root.contains(4));
    System.out.println(root.contains(5));

    root.printInOrder();
    System.out.println();
    root.printPreOrder();
    System.out.println();
    root.printPostOrder();
  }
}
