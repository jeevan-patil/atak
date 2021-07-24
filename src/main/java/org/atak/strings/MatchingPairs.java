package org.atak.strings;

import java.util.HashSet;
import java.util.Set;

public class MatchingPairs {

  public static void main(String[] args) {
    String s = "abcd";
    String t = "adcb";

    MatchingPairs m = new MatchingPairs();
    System.out.println(m.matchingPairs(s, t));
  }

  int matchingPairs(String s, String t) {
    if (s.length() != t.length()) {
      return -1;
    }

    int matching = 0;

    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();

    Set<String> mismatch = new HashSet<>();

    for (int i = 0; i < sChars.length; i++) {
      if (sChars[i] != tChars[i]) {
        mismatch.add(sChars[i] + "_" + tChars[i]);
      } else {
        matching++;
      }
    }

    for (String mis : mismatch) {
      String[] selements = mis.split("_");
      String com = selements[1] + "_" + selements[0];

      if (mismatch.contains(com)) {
        matching = matching + 1;
      }
    }

    if (mismatch.size() == 0) {
      matching = matching - 2;
    }

    return matching;
  }
}
