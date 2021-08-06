package org.atak.strings;

public class RotationalCipher {

  public static void main(String[] args) {
    final RotationalCipher app = new RotationalCipher();
    System.out.println(app.rotationalCipher("x", 4));
  }

  public char rotateLetter(char original, int rf) {
    rf = (rf % 26);
    char shifted = (char) (original + rf);

    if (Character.isLowerCase(original) && shifted > 'z') {
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

}
