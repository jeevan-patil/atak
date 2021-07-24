package org.atak.arrays;

public class Partition {

  public static void main(String[] args) {
    int[] arr = {10, 16, 8, 12, 15, 6, 3, 9, 5};
    Partition p = new Partition();
    int[] o = p.partition(arr);

    for (int i : o) {
      System.out.print(i + " ");
    }
  }

  public int[] partition(final int[] arr) {
    int len = arr.length;

    int pivot = arr[0];
    for(int i = 0; i < len; i++) {
      for(int j = (len - 1); j >= 0; j--) {
        if(arr[i] > pivot) {

        }
      }
    }
    return null;
  }
}
