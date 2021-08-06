package org.atak.problems;

/**
 * Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and
 * return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807. Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0] Output: [0] Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(9);
    l1.next = new ListNode(9);
    l1.next.next = new ListNode(9);
    l1.next.next.next = new ListNode(9);
    l1.next.next.next.next = new ListNode(9);
    l1.next.next.next.next.next = new ListNode(9);
    l1.next.next.next.next.next.next = new ListNode(9);

    ListNode l2 = new ListNode(9);
    l2.next = new ListNode(9);
    l2.next.next = new ListNode(9);
    l2.next.next.next = new ListNode(9);

    ListNode out = new AddTwoNumbers().addTwoNumbers(l1, l2);

    while (out != null) {
      System.out.print(out.val);
      out = out.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode temp = new ListNode(0);
    ListNode head = temp;

    int carry = 0;

    while (l1 != null || l2 != null || carry > 0) {

      int lVal = (l1 != null ? l1.val : 0);
      int rVal = (l2 != null ? l2.val : 0);

      int sum = lVal + rVal + carry;

      carry = (sum / 10);
      sum = sum % 10;

      temp.next = new ListNode(sum);

      l1 = (l1 != null ? l1.next : null);
      l2 = (l2 != null ? l2.next : null);

      temp = temp.next;
    }

    return head.next;
  }

  static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
