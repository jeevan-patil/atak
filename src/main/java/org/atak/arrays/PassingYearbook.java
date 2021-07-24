package org.atak.arrays;

import java.util.HashSet;
import java.util.Set;

public class PassingYearbook {

  public static void main(String[] args) {
    int[] arr = {4,3,2,5,1};
    PassingYearbook p = new PassingYearbook();

    for (int a : p.findSignatureCounts(arr)) {
      System.out.print(a + " ");
    }
  }

  int[] findSignatureCounts(int[] arr) {
    int[] res = new int[arr.length];

    Set<Integer> visited = new HashSet<>();
    for (int k : arr) {
      if (!visited.contains(k)) {
        Set<Integer> round = new HashSet<>();
        while (!visited.contains(k)) {
          round.add(k);
          visited.add(k);
          k = arr[k - 1];
        }
        for (int i : round) {
          res[i - 1] = round.size();
        }
      }
    }
    return res;
  }
}
