package org.atak.problems;

import java.util.Arrays;

public class SeatingArrangements {

  public static void main(String[] args) {
    int[] arr = {5, 10, 6, 8};
    SeatingArrangements s = new SeatingArrangements();
    System.out.println(s.minOverallAwkwardness(arr));
  }

  int minOverallAwkwardness(int[] arr) {
    Arrays.sort(arr);
    int diff = arr[1] - arr[0];

    for (int i = 2; i < arr.length; i += 2) {
      diff = Math.max(diff, arr[i] - arr[i - 2]);
    }
    for (int i = 3; i < arr.length; i += 2) {
      diff = Math.max(diff, arr[i] - arr[i - 2]);
    }

    return Math.max(diff, arr[arr.length - 1] - arr[arr.length - 2]);
  }
}
