package org.atak.strings;

public class RotationalCipher {

  public static void main(String[] args) {
    final RotationalCipher app = new RotationalCipher();
    System.out.println(app.rotationalCipher("a", 13));
  }

  public char rotateLetter(char original, int rf) {
    rf = (rf % 26);
    char shifted = (char) (original + rf);

    if ('a' <= original && 'z' >= original && shifted > 'z') {
      return (char) (original - (26 - rf));
    } else {
      if (shifted > 'Z') {
        return (char) (original - (26 - rf));
      }
    }
    return shifted;
  }

  // 48-57
  public char rotateDigit(char original, int rf) {
    rf = (rf % 10);
    char shifted = (char) (original + rf);

    if (shifted > '9') {
      return (char) (original - (10 - rf));
    }

    return shifted;
  }

  public String rotationalCipher(String input, int rotationFactor) {
    final StringBuilder sb = new StringBuilder();
    for (char ch : input.toCharArray()) {
      if (Character.isLetter(ch)) {
        sb.append(rotateLetter(ch, rotationFactor));
      } else if (Character.isDigit(ch)) {
        sb.append(rotateDigit(ch, rotationFactor));
      } else {
        sb.append(ch);
      }
    }

    return sb.toString();
  }


  public String cipher(final String word, final int shift) {
    final int len = word.length();

    final StringBuilder s = new StringBuilder();
    for (int i = 0; i < len; i++) {
      char original = word.charAt(i);
      char c = (char) (original + shift);

      if (Character.isLetter(original)) {
        if (c > 'z') {
          s.append((char) (original - (26 - shift)));
        } else {
          s.append((char) (original + shift));
        }
      } else if (Character.isDigit(word.charAt(i))) {
        if (c > '9') {
          s.append((char) (original - (9 - shift)));
        } else {
          s.append((char) (original + shift));
        }
      } else {
        s.append(original);
      }

    }

    return s.toString();
  }

}
