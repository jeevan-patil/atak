package org.atak.problems;

import java.util.Arrays;

public class AlternateCoins {

  private int HEAD = 0;
  private int TAIL = 1;

  public static void main(String[] args) {
    int[] arr = {1, 1, 0, 1, 1};
    AlternateCoins a = new AlternateCoins();
    System.out.println(a.solution(arr));
  }

  public int solution(int[] A) {
    if (A.length == 0) {
      return 0;
    }

    int[] b = Arrays.copyOf(A, A.length);
    b[0] = 1 - b[0];

    int count1 = countSwaps(A);
    int count2 = countSwaps(b);
    count2++;

    return Math.min(count1, count2);
  }

  public int countSwaps(int[] A) {
    int count = 0;
    int len = A.length;

    for (int i = 1; i < len; i++) {
      int prev = A[i - 1];
      int curr = A[i];

      if (prev == curr) {
        count++;
        A[i] = 1 - curr;
      }
    }

    return count;
  }
}
