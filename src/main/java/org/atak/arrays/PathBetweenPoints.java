package org.atak.arrays;

public class PathBetweenPoints {

  public static void main(String[] args) {

    System.out.println(((int) 'A') + " - " + ((int) 'B'));

    int[][] array = {
        {0, 0, 0, -1, 0},
        {-1, 0, 0, -1, -1},
        {0, 0, 0, -1, 0},
        {-1, 0, -1, 0, -1},
        {0, 0, -1, 0, 0}
    };

    PathBetweenPoints p = new PathBetweenPoints();
    System.out.println(p.doesPathExist(array));
  }

  public boolean doesPathExist(int[][] array) {
    int columns = array[0].length;
    int rows = array.length;
    array[0][0] = 1;

    for (int row = 1; row < rows; row++) {
      if (array[row][0] != -1) {
        array[row][0] = array[row - 1][0];
      }
    }

    for (int col = 1; col < columns; col++) {
      if (array[0][col] != -1) {
        array[0][col] = array[0][col - 1];
      }
    }

    for (int row = 1; row < rows; row++) {
      for (int col = 1; col < columns; col++) {
        if (array[row][col] != -1) {
          array[row][col] = Math.max(array[row][col - 1], array[row - 1][col]);
        }
      }
    }

    return (array[rows - 1][columns - 1] == 1);
  }
}
