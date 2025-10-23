import java.util.ArrayList;
import java.util.List;

public class Main2 {
  public static void main(String[] args) {
    int rows = 5;
    int columns = 8;

    List<List<Integer>> array2d = new ArrayList<List<Integer>>(rows);
    List<Integer> smallestNumbers = new ArrayList<Integer>(columns);

    for (int i = 0; i < rows; i++) {
      array2d.add(new ArrayList<Integer>(columns));
    }

    // Fill array2d with random numbers
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        int r = (int)(Math.random() * 10);
        array2d.get(row).add(r);
      }
    }

    // Print array2d
    for (int row = 0; row < rows; row++) {
      for (int column = 0; column < columns; column++) {
        int a = array2d.get(row).get(column);
        System.out.print(a + " ");
      }
      System.out.print("\n");
    }

    // Find the smallest number in each column
    int smallest;
    int n;

    for (int column = 0; column < columns; column++) {

      smallest = array2d.get(0).get(column);
      for (int row = 1; row < rows; row++) {
        n = array2d.get(row).get(column);
        if (n < smallest) { smallest = n; }
      }
      smallestNumbers.add(smallest);
    }

    System.out.print("\n");

    for (int i = 0; i < columns; i++) {
      System.out.print(smallestNumbers.get(i) + " ");
    }
  }
}
