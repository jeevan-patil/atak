package org.atak.arrays;

import java.math.BigDecimal;

public class ShipProbability {

  public static void main(String[] args) {
    int[][] ships = {
        {0, 0, 1},
        {1, 0, 1}
    };
    ShipProbability shipProbability = new ShipProbability();
    System.out.println(shipProbability.getHitProbability(ships));
  }

  public double getHitProbability(int[][] G) {
    int columns = G[0].length;
    int rows = G.length;

    int ships = 0;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < columns; col++) {
        if (G[row][col] == 1) {
          ships++;
        }
      }
    }

    if (ships == 0) {
      return 0;
    }

    return Double.parseDouble(
        new BigDecimal(ships).divide(new BigDecimal(columns).multiply(new BigDecimal(rows))).setScale(6)
            .toString());
  }
}
