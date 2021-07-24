package org.atak.sorting;

public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {10, 16, 8, 12, 15, 6, 3, 9, 5};
    QuickSort q = new QuickSort();
    q.sort(arr, 0, arr.length - 1);

    for (int a : arr) {
      System.out.print(a + " ");
    }
  }

  public void sort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    int pivot = arr[(left + right) / 2];
    int index = partition(arr, left, right, pivot);
    sort(arr, left, (index - 1));
    sort(arr, index, right);
  }

  private int partition(int[] arr, int left, int right, int pivot) {
    while (left <= right) {
      while (arr[left] < pivot) {
        left++;
      }

      while (arr[right] > pivot) {
        right--;
      }

      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }

    return left;
  }

  private void swap(int[] arr, int left, int right) {
    int l = arr[left];
    int r = arr[right];
    arr[left] = r;
    arr[right] = l;
  }
}
