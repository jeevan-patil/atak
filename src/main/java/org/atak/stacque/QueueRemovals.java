package org.atak.stacque;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueRemovals {

  public static void main(String[] args) {
    int[] arr = {1, 2, 2, 3, 4, 5};
    int x = 5;
    QueueRemovals queueRemovals = new QueueRemovals();
    System.out.println(Arrays.toString(queueRemovals.findPositions(arr, x)));
  }

  int[] findPositions(int[] arr, int x) {
    int length = arr.length;
    int[] output = new int[x];

    java.util.Queue<Position> positions = new LinkedList<Position>();
    for (int i = 0; i < length; i++) {
      positions.add(new Position(i + 1, arr[i]));
    }

    int pass = 0;
    List<Position> popped = new ArrayList<>();
    for (int i = 0; i < x; i++) {

      for (int j = 0; j < x && !positions.isEmpty(); j++) {
        popped.add(positions.poll());
      }

      int max = 0;
      int maxIndex = Integer.MAX_VALUE;

      for (Position position : popped) {
        if (position.value == max) {
          maxIndex = Math.min(maxIndex, position.index);
        } else if (position.value > max) {
          max = position.value;
          maxIndex = position.index;
        }
      }

      output[pass++] = maxIndex;

      for (Position position : popped) {
        if (position.index != maxIndex) {
          Position next = new Position(position.index,
              (position.value == 0) ? position.value : position.value - 1);
          positions.add(next);
        }
      }
    }

    return output;
  }

  class Position {

    int index;
    int value;

    Position(int index, int val) {
      this.index = index;
      this.value = val;
    }

    @Override
    public String toString() {
      return "Position{" +
          "index=" + index +
          ", value=" + value +
          '}';
    }
  }
}
