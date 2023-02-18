package org.atak.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 */
public class BuildingWithOceanView {

  public static void main(String[] args) {
    final int[] buildings = {4, 2, 3, 1};
    int[] buildingsWithView = new BuildingWithOceanView().buildingsWithView(buildings);

    for (int building : buildingsWithView) {
      System.out.print(building + " ");
    }
  }

  private int[] buildingsWithView(final int[] heights) {
    List<Integer> withView = new ArrayList<>();

    int number = heights.length;
    int maxHeight = heights[number - 1];
    withView.add(number - 1);

    for (int i = number - 2; i >= 0; i--) {
      if (heights[i] > maxHeight) {
        withView.add(i);
        maxHeight = heights[i];
      }
    }

    Collections.reverse(withView);
    return withView.stream().mapToInt(i -> i).toArray();
  }
}
