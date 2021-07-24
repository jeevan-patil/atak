package org.atak.problems;

public class MaximumPossibleValue {

  int NUMBER_TO_INSERT = 5;

  public static void main(String[] args) {
    int n = -0;
    MaximumPossibleValue m = new MaximumPossibleValue();
    System.out.println(m.solution(n));
  }

  public int solution(int N) {
    if (N == 0) {
      return NUMBER_TO_INSERT * 10;
    }

    boolean negative = (N < 0);
    int absNum = Math.abs(N);

    StringBuilder num = new StringBuilder();
    String[] arr = String.valueOf(absNum).split("");

    boolean placed = false;
    for (int i = 0; i < arr.length; i++) {

      if (negative && !placed && Integer.parseInt(arr[i]) >= NUMBER_TO_INSERT) {
        num.append(NUMBER_TO_INSERT);
        placed = true;
      } else if (!negative && !placed && Integer.parseInt(arr[i]) <= NUMBER_TO_INSERT) {
        num.append(NUMBER_TO_INSERT);
        placed = true;
      }

      num.append(arr[i]);
    }

    return (negative ? -Integer.parseInt(num.toString()) : Integer.parseInt(num.toString()));
  }
}
