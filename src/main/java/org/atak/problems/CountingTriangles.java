package org.atak.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountingTriangles {

  int countDistinctTriangles(ArrayList<Sides> arr) {
    Set<String> data = new HashSet<>();

    for (Sides side : arr) {
      int[] sides = new int[]{side.a, side.b, side.c};
      Arrays.sort(sides);
      String key = Arrays.toString(sides);
      data.add(key);
    }

    return data.size();
  }

  class Sides {

    int a;
    int b;
    int c;

    Sides(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }

  public void run() {
    ArrayList<Sides> arr_1 = new ArrayList<>();
    arr_1.add(new Sides(7, 6, 5));
    arr_1.add(new Sides(5, 7, 6));
    arr_1.add(new Sides(8, 2, 9));
    arr_1.add(new Sides(2, 3, 4));
    arr_1.add(new Sides(2, 4, 3));
    int expected_1 = 3;
    int output_1 = countDistinctTriangles(arr_1);
    System.out.println("expected_1: " + expected_1 + " and output_1: " + output_1);

    ArrayList<Sides> arr_2 = new ArrayList<>();
    arr_2.add(new Sides(3, 4, 5));
    arr_2.add(new Sides(8, 8, 9));
    arr_2.add(new Sides(7, 7, 7));
    int expected_2 = 3;
    int output_2 = countDistinctTriangles(arr_2);
    System.out.println("expected_2: " + expected_2 + " and output_2: " + output_2);
  }

  public static void main(String[] args) {
    new CountingTriangles().run();
  }

}
