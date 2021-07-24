package org.atak.problems;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LieBetn {

  public static void main(String[] args) {
    int[] arr = {1, 4, 7, 3, 3, 5};
    LieBetn l = new LieBetn();
    System.out.println(l.solution(arr));
  }

  public int solution(int[] A) {

    int length = A.length;
    TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
    for (int i = 0; i < length; i++) {
      int val = A[i];
      map.putIfAbsent(val, new PriorityQueue<>());
      map.get(val).add(i);
    }

    Iterator<PriorityQueue<Integer>> iterator = map.values().iterator();

    PriorityQueue<Integer> queue0 = iterator.next();

    int[] previousVal = new int[queue0.size()];
    for (int i = 0; i < queue0.size(); i++) {
      previousVal[i] = queue0.poll();
    }

    int output = Integer.MAX_VALUE;
    while (iterator.hasNext()) {
      PriorityQueue<Integer> queue1 = iterator.next();
      int[] currentVal = new int[queue1.size()];
      for (int i = 0; i < queue1.size(); i++) {
        currentVal[i] = queue1.poll();
      }

      int min = Integer.MAX_VALUE;

      int ind0 = 0;
      int ind1 = 0;

      while (ind0 < previousVal.length && ind1 < currentVal.length) {
        int val0 = previousVal[ind0];
        int val1 = currentVal[ind1];

        min = Math.min(min, Math.abs(val1 - val0));
        if (val1 > val0) {
          ind0++;
        } else {
          ind1++;
        }
      }

      output = Math.min(output, min);
      previousVal = currentVal;
    }

    return output;
  }
}
