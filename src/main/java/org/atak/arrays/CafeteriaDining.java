package org.atak.arrays;

import java.util.ArrayList;
import java.util.List;

public class CafeteriaDining {

  public static void main(String[] args) {
    long[] seated = {11, 6, 14};
    // 1 2 3 4 5 K 7 8 9 10 K 12 13 K 15
    //
    long totalSeats = 15;
    long distanceToFollow = 2;
    int alreadySeated = 3;
    CafeteriaDining c = new CafeteriaDining();
    System.out.println(
        c.getMaxAdditionalDinersCount(totalSeats, distanceToFollow, alreadySeated, seated));
  }

  public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

    List<Long> seated = new ArrayList<>();

    for (long s : S) {
      seated.add(s);
    }

    long pos = 0;
    for (long seat = 1; seat <= N; seat++) {
      System.out.println(seat + " " + inTheRestrictedArea(N, seat, K, seated));
      if (!inTheRestrictedArea(N, seat, K, seated)) {
        pos++;
        seat = seat + K;
        seated.add(seat);
      }
    }

    return pos;
  }

  private boolean inTheRestrictedArea(long total, long seat, long distance, List<Long> seated) {
    for (Long s : seated) {
      if (s == seat) {
        return true;
      }
      if (seat < s && (s - seat <= distance)) {

        return true;
      } else if (seat > s && (seat - s <= distance)) {

        return true;
      }
    }

    return false;
  }

}
