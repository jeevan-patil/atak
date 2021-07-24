package org.atak.stacque;

import java.util.PriorityQueue;

public class KthLargestElement {

  int k = 0;
  PriorityQueue<Integer> queue = new PriorityQueue<>();

  public static void main(String[] args) {
    KthLargestElement kthLargest = new KthLargestElement(3, new int[]{4, 5, 8, 2});

    System.out.println(kthLargest.add(3));
    System.out.println(kthLargest.add(5));
    System.out.println(kthLargest.add(10));
    System.out.println(kthLargest.add(9));
    System.out.println(kthLargest.add(4));
  }

  public KthLargestElement(int k, int[] nums) {
    this.k = k;

    for (int n : nums) {
      queue.add(n);
    }

  }

  public int add(int val) {
    if (queue.size() < k) {
      queue.add(val);
    } else {
      if (queue.peek() < val) {
        queue.poll();
        queue.add(val);
      }
    }
    return queue.peek();
  }
}
