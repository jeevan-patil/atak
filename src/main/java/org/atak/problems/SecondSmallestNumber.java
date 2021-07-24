package org.atak.problems;

/**
 * Given sequence on integers and asked to find the second lowest integer.
 */
public class SecondSmallestNumber {

  public static void main(String[] args) {
    int[] elements = {-5, -4, 0, 2, 10, 3, -3};
    System.out.println(new SecondSmallestNumber().secondSmallestNumber(elements));
  }

  int secondSmallestNumber(final int[] elements) {
    if (elements == null || elements.length == 0) {
      return -1;
    }

    final int len = elements.length;

    int smallest = Integer.MAX_VALUE;
    int secondSmallest = Integer.MAX_VALUE;

    for (int i = 0; i < len; i++) {
      final int current = elements[i];
      if (current < smallest) {
        secondSmallest = smallest;
        smallest = current;
      } else if (current < secondSmallest) {
        secondSmallest = current;
      }
    }

    return secondSmallest;
  }
}
