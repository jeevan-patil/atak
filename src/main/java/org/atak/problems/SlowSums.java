package org.atak.problems;

import java.util.Arrays;

public class SlowSums {

  public static void main(String[] args) {
    int[] arr = {4, 2, 1, 3};
    SlowSums s = new SlowSums();
    System.out.println(s.getTotalTime(arr));
  }

  int getTotalTime(int[] arr) {
    Arrays.sort(arr);

    int len = arr.length;

    int penalty = 0;
    int last = 0;
    for (int i = (len - 1); i >= 0; i--) {
      if (i == (len - 1)) {
        last = arr[i] + arr[i - 1];
        penalty += last;
        --i;
        continue;
      }

      last = last + arr[i];
      penalty += last;
    }
    return penalty;
  }

}
