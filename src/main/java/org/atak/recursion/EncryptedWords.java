package org.atak.recursion;

public class EncryptedWords {

  public static void main(String[] args) {
    String s = "abcxcba";
    EncryptedWords e = new EncryptedWords();
    System.out.println(e.findEncryptedWord(s));
  }

  String findEncryptedWord(String s) {
    String r = "";
    int mid = s.length() / 2;
    if (s.length() % 2 == 0) {
      mid -= 1;
    }

    r += s.substring(mid, mid + 1);

    if (mid > 0) {
      String ls = s.substring(0, mid);
      r += findEncryptedWord(ls);
    }

    if (mid < s.length() - 1) {
      String rs = s.substring(mid + 1, s.length());
      r += findEncryptedWord(rs);
    }

    return r;
  }
}
