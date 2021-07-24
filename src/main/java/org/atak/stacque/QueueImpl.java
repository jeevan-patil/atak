package org.atak.stacque;

public class QueueImpl {

  public static void main(String[] args) {
    final Queue queue = new Queue();
    queue.add(4);
    queue.add(2);
    queue.add(1);

    System.out.println(queue.isEmpty());
    System.out.println(queue.peek());
    System.out.println(queue.remove());
    System.out.println(queue);
    System.out.println(queue.remove());
    System.out.println(queue);
    System.out.println(queue.remove());
    System.out.println(queue);
  }
}
