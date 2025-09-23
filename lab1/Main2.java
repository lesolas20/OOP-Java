import java.util.Arrays;

public class Main2 {
  public static double dRound(double x, int n) {
    // Return `x` rounded to `n` decimal places
    return Math.round(x * Math.pow(10, n)) / Math.pow(10, n);
  }

  public static double dRandom(double min, double max, double step) {
    // Return a pseudorandom number in range between `min` and `max`
    return dRound(((int)(Math.random() * (((max - min) / step) + 1)) * step) + min, 3);
  }

  public static long factorial(int number) {
    long result = 1;

    for (int factor = 2; factor <= number; factor++) {
      result *= factor;
    }

    return result;
  }

  public static double calculate(double[][] array) {
    // Calculate factorial of number of positive elements located on the
    // perimeter of the array

    int counter = 0;

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        // If the element located on the perimeter
        if (i == 0 || j == 0 || i == (array.length - 1) || j == (array[i].length - 1)) {
          if (array[i][j] > 0) {
            counter += 1;
          }
        }
      }
    }

    return factorial(counter);
  }

  public static void main(String[] args) {
    int m = 10;
    int n = 10;

    double A[][] = new double[m][n];

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[i].length; j++) {
        A[i][j] = dRandom(-5, 5, 1);
      }
    }

    System.out.println(Arrays.deepToString(A));

    System.out.println(calculate(A));

  }
}
