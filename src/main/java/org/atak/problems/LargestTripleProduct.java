package org.atak.problems;

import java.util.PriorityQueue;

public class LargestTripleProduct {

  public static void main(String[] args) {
    int[] arr = {2, 4, 7, 1, 5, 3};
    LargestTripleProduct l = new LargestTripleProduct();

    for (int a : l.findMaxProduct(arr)) {
      System.out.print(a + " ");
    }
  }

  int[] findMaxProduct(int[] arr) {
    int len = arr.length;
    int[] output = new int[len];

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    output[0] = -1;
    output[1] = -1;
    queue.add(arr[0]);
    queue.add(arr[1]);

    for (int i = 2; i < len; i++) {
      queue.add(arr[i]);

      if (queue.size() > 3) {
        queue.remove();
      }

      output[i] = sum(queue);
    }
    return output;
  }

  private int sum(PriorityQueue<Integer> queue) {
    int sum = 1;
    for (int s : queue) {
      sum *= s;
    }
    return sum;
  }
}
