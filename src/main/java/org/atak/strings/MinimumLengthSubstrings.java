package org.atak.strings;

import java.util.HashSet;
import java.util.Set;

public class MinimumLengthSubstrings {

  public static void main(String[] args) {
    String s = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    String t = "cbccfafebccdccebdd";

    MinimumLengthSubstrings m = new MinimumLengthSubstrings();
    System.out.println(m.minLengthSubstring(s, t));
  }

  int minLengthSubstring(String s, String t) {
    int sn = s.length(), tn = t.length();
    if (sn < tn) {
      return -1;
    }

    Set<Integer> indexes = new HashSet<>();

    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();

    for (int i = 0; i < tArr.length; i++) {
      for (int j = 0; j < sArr.length; j++) {
        if (sArr[j] == tArr[i]) {
          indexes.add(j);
        }
      }
    }

    int minIndex = 0;
    int maxIndex = 0;

    for (int ind : indexes) {
      if (ind < minIndex) {
        minIndex = ind;
      } else if (ind > maxIndex) {
        maxIndex = ind;
      }
    }

    return (maxIndex - minIndex) + 1;
  }
}
