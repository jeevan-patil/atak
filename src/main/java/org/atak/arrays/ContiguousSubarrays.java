package org.atak.arrays;

import java.util.Stack;

public class ContiguousSubarrays {

  public static void main(String[] args) {
    int[] arr = {2, 4, 7, 1, 5, 3};
    ContiguousSubarrays c = new ContiguousSubarrays();

    for (int a : c.countSubarrays(arr)) {
      System.out.print(a + " ");
    }
  }

  int[] bf(int[] arr) {
    int[] ans = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      int current = arr[i];
      int left = i - 1;
      int right = i + 1;

      while (left >= 0 && current > arr[left]) {
        left--;
        ans[i]++;
      }

      while (right < arr.length && current > arr[right]) {
        right++;
        ans[i]++;
      }

      ans[i]++;
    }

    return ans;
  }

  //3, 4, 1, 6, 2
  int[] countSubarrays(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int[] ans = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        ans[i] += ans[stack.pop()];
      }
      stack.push(i);
      ans[i]++;
    }
    stack.clear();
    int[] temp = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        int idx = stack.pop();
        ans[i] += temp[idx];
        temp[i] += temp[idx];
      }
      stack.push(i);
      temp[i]++;
    }
    return ans;
  }
}
