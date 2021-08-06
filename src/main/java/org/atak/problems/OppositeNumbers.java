package org.atak.problems;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class OppositeNumbers {

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, -1, 2, -1};
    OppositeNumbers o = new OppositeNumbers();
    System.out.println(o.solution(arr));
  }

  public int solution(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    Map<Integer, Integer> pos = new TreeMap<>(Collections.reverseOrder());
    Map<Integer, Integer> neg = new TreeMap<>();

    for (int num : A) {
      if (num > 0) {
        adjust(pos, num);
      } else {
        adjust(neg, Math.abs(num));
      }
    }

    if (pos.isEmpty()) {
      return 0;
    }

    for (int pnum : pos.keySet()) {
      if (neg.containsKey(pnum)) {
        return pnum;
      }
    }

    return 0;
  }

  public void adjust(Map<Integer, Integer> map, int num) {
    map.put(num, map.getOrDefault(num, 0) + 1);
  }
}
