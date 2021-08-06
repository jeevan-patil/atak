package org.atak.problems;

public class SecondMaximum {

  public static void main(String[] args) {
    final int[] arr = {5, 1, 5, 4, 2};
    System.out.println(new SecondMaximum().solution(arr));
  }

  public int solution(final int[] arr) {

    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;

    for (int num : arr) {
      if (num > max) {
        secondMax = max;
        max = num;
      } else if (num > secondMax) {
        secondMax = num;
      }
    }

    return secondMax;
  }

}
