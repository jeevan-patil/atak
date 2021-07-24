package org.atak.arrays;

import java.util.ArrayList;
import java.util.List;

public class Subarrays {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 5, 3, 3, 3};
    dynamic(arr);
    recursive(arr);
  }

  private static void recursive(int[] arr) {
    System.out.println("Recursive");
    recSubArray(arr, 0);
  }

  protected static void recSubArray(int[] arr, int currentIndex) {
    int l = arr.length;

    if (currentIndex == l) {
      return;
    }

    List<Integer> sub = new ArrayList<>();
    for (int i = currentIndex; i < arr.length; i++) {
      sub.add(arr[i]);
      System.out.print(sub);
    }

    recSubArray(arr, (currentIndex + 1));
  }

  private static void dynamic(int[] arr) {
    final int l = arr.length;

    System.out.println("Dynamic approach:");
    for (int i = 0; i < l; i++) {
      for (int j = i; j < l; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(arr[k] + " ");
        }
        System.out.println();
      }
    }
  }

}
