package org.atak.searches;

public class BillionUsers {

  double target = 1_000_000_000;

  public static void main(String[] args) {
    float[] growthRates = {1.5f};
    BillionUsers b = new BillionUsers();
    System.out.println(b.getBillionUsersDay(growthRates));
  }

  public int getBillionUsersDay(float[] growthRates) {
    int start = 1;
    int end = 2_000;

    while (start < end) {
      double total = 0;
      int mid = start + (end - start) / 2;

      // calculate mid value
      for (float growthRate : growthRates) {
        total += userOnDay(growthRate, mid);
      }

      if (total == target) {
        return mid;
      }
      if (total > target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    return start;
  }

  private double userOnDay(float rate, int day) {
    return Math.pow(rate, day);
  }
}
