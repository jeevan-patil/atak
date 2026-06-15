package org.atak.intview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Anagram {

  public static void main(String[] args) {
    Anagram anagram = new Anagram();
    System.out.println(anagram.isAnagram("listen", "silent"));
    System.out.println(anagram.isAnagramHashMapBased("listen#A", "sil#entA"));
  }

  private boolean isAnagram(String a, String b) {
    if (Objects.isNull(a) || Objects.isNull(b) || a.length() != b.length()) return false;

    int[] count = new int[26];
    for (int i = 0; i < a.length(); i++) {
      count[a.charAt(i) - 'a']++;
      count[b.charAt(i) - 'a']--;
    }

    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) return false;
    }

    return true;
  }

  private boolean isAnagramHashMapBased(String a, String b) {
    if (Objects.isNull(a) || Objects.isNull(b) || a.length() != b.length()) return false;

    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < a.length(); i++) {
      Character aKey = a.charAt(i);
      map.put(aKey, map.getOrDefault(aKey, 0) + 1);
    }

    for (int i = 0; i < a.length(); i++) {
      Character bKey = b.charAt(i);
      if (map.containsKey(bKey)) {
        map.put(bKey, map.get(bKey) - 1);

        if (map.get(bKey) == 0) {
          map.remove(bKey);
        }
      }
    }

    return map.isEmpty();
  }
}
