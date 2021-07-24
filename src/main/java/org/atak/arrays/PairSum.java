package org.atak.arrays;

import java.util.HashMap;
import java.util.Map;

public class PairSum {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 3};
    int sum = 6;

    System.out.println(new PairSum().numberOfWays(arr, sum));
  }

  int numberOfWays(int[] arr, int k) {
    Map<Integer, Integer> ocurrances = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int current = arr[i];
      ocurrances.put(current, ocurrances.getOrDefault(current, 0) + 1);
    }

    int total = 0;
    for (int i = 0; i < arr.length; i++) {
      int curr = arr[i];
      int diff = k - curr;

      if (ocurrances.containsKey(diff)) {
        int ocur = ocurrances.get(diff);
        total += (diff == curr ? (ocur * (ocur - 1) / 2) : ocur);
        ocurrances.remove(curr);
        ocurrances.remove(diff);
      }
    }

    return total;
  }
}
