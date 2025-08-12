package org.atak.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/** Interview Practice Problems These are common problems asked in coding interviews */
public class InterviewPractice {

  public static void main(String[] args) {
    InterviewPractice practice = new InterviewPractice();

    // Test Problem 1: Maximum Subarray Sum
    System.out.println("=== Problem 1: Maximum Subarray Sum ===");
    int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println("Input: " + Arrays.toString(arr1));
    System.out.println("Maximum subarray sum: " + practice.maxSubArraySum(arr1));

    // Test Problem 2: Valid Parentheses
    System.out.println("\n=== Problem 2: Valid Parentheses ===");
    String[] parentheses = {"()", "()[]{}", "(]", "([)]", "{[]}"};
    for (String s : parentheses) {
      System.out.println(s + " is valid: " + practice.isValidParentheses(s));
    }

    // Test Problem 3: Two Sum
    System.out.println("\n=== Problem 3: Two Sum ===");
    int[] arr2 = {2, 7, 11, 15};
    int target = 9;
    System.out.println("Input: " + Arrays.toString(arr2) + ", Target: " + target);
    int[] result = practice.twoSum(arr2, target);
    System.out.println("Result: [" + result[0] + ", " + result[1] + "]");

    // Test Problem 4: Reverse String
    System.out.println("\n=== Problem 4: Reverse String ===");
    char[] str = {'h', 'e', 'l', 'l', 'o'};
    System.out.println("Original: " + Arrays.toString(str));
    practice.reverseString(str);
    System.out.println("Reversed: " + Arrays.toString(str));

    // Test Problem 5: Merge Sorted Arrays
    System.out.println("\n=== Problem 5: Merge Sorted Arrays ===");
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int m = 3, n = 3;
    System.out.println("Before merge: " + Arrays.toString(nums1));
    practice.merge(nums1, m, nums2, n);
    System.out.println("After merge: " + Arrays.toString(nums1));
  }

  /**
   * Problem 1: Maximum Subarray Sum (Kadane's Algorithm) Time Complexity: O(n) Space Complexity:
   * O(1)
   */
  public int maxSubArraySum(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int maxSoFar = nums[0];
    int maxEndingHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
      maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }

    return maxSoFar;
  }

  /** Problem 2: Valid Parentheses Time Complexity: O(n) Space Complexity: O(n) */
  public boolean isValidParentheses(String s) {
    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) return false;

        char top = stack.pop();
        if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  /** Problem 3: Two Sum Time Complexity: O(n) Space Complexity: O(n) */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }

    return new int[] {-1, -1}; // No solution found
  }

  /** Problem 4: Reverse String (In-place) Time Complexity: O(n) Space Complexity: O(1) */
  public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;

    while (left < right) {
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;
      left++;
      right--;
    }
  }

  /** Problem 5: Merge Sorted Arrays Time Complexity: O(m + n) Space Complexity: O(1) */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;
    int p = m + n - 1;

    while (p1 >= 0 && p2 >= 0) {
      if (nums1[p1] > nums2[p2]) {
        nums1[p] = nums1[p1];
        p1--;
      } else {
        nums1[p] = nums2[p2];
        p2--;
      }
      p--;
    }

    // Copy remaining elements from nums2
    while (p2 >= 0) {
      nums1[p] = nums2[p2];
      p2--;
      p--;
    }
  }

  /** Problem 6: Binary Tree Level Order Traversal Time Complexity: O(n) Space Complexity: O(n) */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll();
        currentLevel.add(node.val);

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }

      result.add(currentLevel);
    }

    return result;
  }

  /**
   * Problem 7: Climbing Stairs (Dynamic Programming) Time Complexity: O(n) Space Complexity: O(1)
   */
  public int climbStairs(int n) {
    if (n <= 2) return n;

    int oneStepBefore = 2;
    int twoStepsBefore = 1;
    int allWays = 0;

    for (int i = 3; i <= n; i++) {
      allWays = oneStepBefore + twoStepsBefore;
      twoStepsBefore = oneStepBefore;
      oneStepBefore = allWays;
    }

    return allWays;
  }

  /** Problem 8: Find Missing Number Time Complexity: O(n) Space Complexity: O(1) */
  public int missingNumber(int[] nums) {
    int n = nums.length;
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;

    for (int num : nums) {
      actualSum += num;
    }

    return expectedSum - actualSum;
  }

  // TreeNode class for tree problems
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }
}
