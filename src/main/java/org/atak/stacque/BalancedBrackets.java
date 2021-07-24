package org.atak.stacque;

import java.util.Stack;

public class BalancedBrackets {

  char[][] braces = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

  public static void main(String[] args) {
    String s = "{{[[(())]]}}";
    BalancedBrackets b = new BalancedBrackets();
    System.out.println(b.isBalanced(s));
  }

  boolean isBalanced(String s) {

    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (isOpenBracket(c)) {
        stack.push(c);
      } else {
        if (stack.isEmpty() || !matches(stack.pop(), c)) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }


  public boolean isOpenBracket(char c) {
    for (char[] arr : braces) {
      if (arr[0] == c) {
        return true;
      }
    }

    return false;
  }

  public boolean matches(char openBracket, char closingBracket) {
    for (char[] arr : braces) {
      if (arr[0] == openBracket) {
        return (arr[1] == closingBracket);
      }
    }

    return false;
  }

}
