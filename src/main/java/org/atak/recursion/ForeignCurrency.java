package org.atak.recursion;

public class ForeignCurrency {

  public static void main(String[] args) {
    int[] m = {4, 17, 29};
    ForeignCurrency f = new ForeignCurrency();
    System.out.println(f.canGetExactChange(75, m));
  }

  boolean canGetExactChange(int targetMoney, int[] denominations) {
    if (targetMoney < 0) {
      return false;
    }
    if (targetMoney == 0) {
      return true;
    }
    for (int denomination : denominations) {
      if (canGetExactChange(targetMoney - denomination, denominations)) {
        return true;
      }
    }
    return false;
  }

}
