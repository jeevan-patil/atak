package org.atak.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Reservations {

  public static void main(String[] args) {

    String res = "1A 2F 1C";
    String res1 = "1A 1B 1C 1D 1E 1F 1G 1H 1J 1K";
    int rows = 2;
    Reservations r = new Reservations();
    System.out.println(r.solution(rows, res));
  }

  public int solution(int N, String S) {
    if (S.trim().length() == 0) {
      return N * 2;
    }

    int charA = 65;
    int seatsInRow = 10;
    int[][] rowSeats = new int[N][seatsInRow];

    Set<Integer> aisles = new HashSet<>();
    aisles.add(67);
    aisles.add(68);
    aisles.add(71);
    aisles.add(72);

    for (int row = 0; row < N; row++) {
      for (int col = 0; col < seatsInRow; col++) {
        int r = charA + col;
        if (r >= 73) {
          r = r + 1;
        }
        rowSeats[row][col] = r;
      }
    }

    Map<Integer, Set<Integer>> rs = new HashMap<>();
    Map<Integer, Integer> rowSeatTaken = new HashMap<>();

    for (String seat : S.split(" ")) {
      int sName = seat.charAt(seat.length() - 1);
      if (sName >= 73) {
        sName = sName - 1;
      }
      int no = Integer.parseInt(seat.substring(0, seat.length() - 1));
      rowSeats[no - 1][sName - charA] = 1;

      boolean aisle = (aisles.contains(sName));
      if (rs.containsKey(no)) {
        if (aisle) {
          Set<Integer> as = rs.get(no);
          as.add(sName);
          rs.put(no, as);
        }
      } else {
        if (aisle) {
          Set<Integer> as = new HashSet<>();
          as.add(sName);
          rs.put(no, as);
        }
      }
      if (rowSeatTaken.containsKey(no)) {
        rowSeatTaken.put(no, rowSeatTaken.get(no) + 1);
      } else {
        rowSeatTaken.put(no, 1);
      }

    }

    int families = 0;
    for (int row = 0; row < N; row++) {

      int cur = row + 1;
      if (!rs.containsKey(cur) && !rowSeatTaken.containsKey(cur)) {
        families = families + 2;
        continue;
      }

      if (rs.containsKey(cur) && rs.get(cur).size() > 2) {
        continue;
      }

      int cnt = 0;
      for (int col = 1; col < seatsInRow - 1; col++) {
        int val = rowSeats[row][col];
        if (val == 1) {
          cnt = 0;
          continue;
        }

        Set<Integer> als = rs.get(val);

        if (rs.containsKey(val)) {
          cnt = 0;
          continue;
        }

        cnt++;
        if (cnt == 4) {
          families++;
          cnt = 0;
        }
      }
    }

    return families;
  }

}
