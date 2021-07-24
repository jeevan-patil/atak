package org.atak.arrays;

import java.util.HashMap;
import java.util.Map;

public class ReverseToMakeEqual {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 2};
    int[] b = {1, 4, 3, 2, 3};

    ReverseToMakeEqual r = new ReverseToMakeEqual();
    System.out.println(r.areTheyEqual(a, b));
  }

  boolean areTheyEqual(int[] array_a, int[] array_b) {
    if (array_a.length != array_b.length) {
      return false;
    }

    Map<Integer, Integer> mapping = new HashMap<>();

    for (int a : array_a) {
      mapping.put(a, mapping.getOrDefault(a, 1) + 1);
    }

    for (int b : array_b) {
      if (!mapping.containsKey(b)) {
        return false;
      }

      if (mapping.get(b) == 1) {
        mapping.remove(b);
      } else {
        mapping.put(b, mapping.get(b) - 1);
      }
    }

    return mapping.isEmpty();
  }
}
