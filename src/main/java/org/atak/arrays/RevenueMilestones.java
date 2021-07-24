package org.atak.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RevenueMilestones {

  public static void main(String[] args) {
    int[] revenues = {700, 800, 600, 400, 600, 700};
    int[] milestones = {3100, 2200, 800, 2100, 1000};

    int[] d = new RevenueMilestones().getMilestoneDays(revenues, milestones);
    Arrays.stream(d).forEach(n -> System.out.print(" " + n));
  }

  public int[] getMilestoneDays(int[] revenues, int[] milestones) {

    int[] days = new int[milestones.length];
    int total = 0;
    Map<Integer, Integer> revenuePerDay = new HashMap<>();
    for (int day = 1; day <= revenues.length; day++) {
      int revenue = revenues[day - 1];
      total = total + revenue;
      revenuePerDay.put(day, total);
    }

    for (int i = 0; i < milestones.length; i++) {
      int milestone = milestones[i];

      for (int day : revenuePerDay.keySet()) {
        int rev = revenuePerDay.get(day);

        if (milestone <= rev) {
          days[i] = day;
          break;
        }
      }
    }

    return days;
  }
}
