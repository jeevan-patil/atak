package org.atak.problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class MagicalCandy {

  public static void main(String[] args) {
    int[] arr = {2, 1, 7, 4, 2};
    int minutes = 3;
    System.out.println(new MagicalCandy().maxCandies(arr, minutes));
  }

  int maxCandies(int[] arr, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (int i : arr) {
      queue.add(i);
    }

    int total = 0;
    for (int i = 0; i < k; i++) {
      int candy = queue.remove();
      total += candy;
      queue.add(candy / 2);
    }

    return total;
  }
}
