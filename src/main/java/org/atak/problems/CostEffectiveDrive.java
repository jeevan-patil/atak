package org.atak.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * This year annual company trip is being held in Byron Bay.
 * Rather than fly, you've agreed with some colleagues to drive, so you can check out the famous Big
 * Banana in Coffs Harbour, something you've always wanted to do. Your journey will require a lot of
 * fuel, so you decide to map out all petrol Stations along your route, and how much each station is
 * selling fuel at per litre.
 * <p>
 * Your goal is simple, to get to Byron Bay as cheaply as possible. As well as knowing the distances
 * between stations, and the cost of fuel, there are some other important factors to be aware of. •
 * Your car's fuel tank has a 50-litre capacity, and you can travel 1km per litre (this is constant).
 * • Your journey will start at the first petrol station and your car's fuel tank will be empty,
 * i.e. you can get the price of fuel at your starting point from prices[0].
 * • Your car should arrive at its destination with an empty tank.
 * • All petrol stations are within 50km of each other.
 *
 * Write a function calculate that takes two integer arrays of size N- distances and prices. The
 * price of fuel at station i is prices [i] and the distance to the next station is distances [i].
 * Return the lowest amount you need to spend on fuel to reach your destination.
 *
 * • Assume inputs contain only valid data.
 * • Assume input arrays are of equal length.
 * • Assume all prices are in dollars and all distances are in kilometres.
 *
 * Example: Assume the input for distances is [10, 20, 5, 20] and prices is [3, 4, 2, 3]. The correct
 * answer would be 140, as it would be cheapest to fill 30-litres at the first stop at $3 ($90 subtotal)
 * which is just enough fuel to get you to the third station, where you would refuel another 25-litres
 * at $2 ($50 subtotal) so that you arrive at the last station with an empty tank.
 */

public class CostEffectiveDrive {

  public static void main(String[] args) {
    final int[] distances = {10, 20, 5, 20};

    final int[] prices = {3, 4, 2, 3};

    System.out.println(
        "Total amount spent on the petrol is " + new CostEffectiveDrive().calculate(distances,
            prices));
  }

  public int calculate(final int[] distances, final int[] prices) {
    int totalDistance = 0;
    final Map<Integer, Integer> stationDistance = new HashMap<>();

    for (int i = 0; i < distances.length; i++) {
      totalDistance += distances[i];
      stationDistance.put(i, totalDistance);
    }

    int stationIndex = 0;
    boolean reached = false;

    while(!reached) {

    }

    System.out.println(stationDistance);
    System.out.println(totalDistance);

    return 0;
  }
}
