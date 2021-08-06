package org.atak.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example
 * 2:
 * <p>
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubstring {

  public static void main(String[] args) {
    final String s = "abcabcdbb";
    System.out.println(new LongestSubstring().lengthOfLongestSubstring(s));
  }

  public int lengthOfLongestSubstring(String string) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0, len = 0;

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      if (map.containsKey(c)) {
        if (map.get(c) >= start) {
          start = map.get(c) + 1;
        }
      }
      len = Math.max(len, i - start + 1);
      map.put(c, i);
    }

    return len;
  }
}
