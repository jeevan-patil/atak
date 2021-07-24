package org.atak.problems;

import java.util.Arrays;

public class BalancedSplit {

  public static void main(String[] args) {
    int[] arr = {12, 7, 6, 7, 6};
    BalancedSplit b = new BalancedSplit();
    System.out.println(b.balancedSplitExists(arr));
  }

  boolean balancedSplitExists(int[] arr) {
    int leftSum = 0;
    int rightSum = 0;

    for (int a : arr) {
      leftSum += a;
    }

    Arrays.sort(arr);

    for (int i = arr.length - 1; i >= 0; i--) {
      leftSum -= arr[i];
      rightSum += arr[i];

      if (leftSum == rightSum) {
        if (arr[i - 1] < arr[i]) {
          return true;
        }
      }
    }
    return false;
  }

}
