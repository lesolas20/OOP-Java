public class Main1 {
  public static double dRound(double x, int n) {
    // Return `x` rounded to `n` decimal places
    return Math.round(x * Math.pow(10, n)) / Math.pow(10, n);
  }

  public static void tabulate1(double x_start, double x_end, double x_step) {
    for (double x = x_start; x <= x_end; x = dRound(x + x_step, 3)) {
      double y = dRound(Math.pow(((4 * Math.pow(x, 3)) + Math.pow(x, 2)), 1/4d), 4);
      System.out.println("x = " + x + ", y = " + y);
    }
  }

  public static void tabulate2(double x_start, double x_end, double x_step) {
    for (double x = x_start; x <= x_end; x = dRound(x + x_step, 3)) {
      double y;

      if (x < 0) {
        y = dRound(Math.sin(Math.cos(x)), 4);
      } else {
        y = dRound(Math.cos(Math.sin(x)), 4);
      }

      System.out.println("x = " + x + ", y = " + y);
    }
  }

  public static void main(String[] args) {
    tabulate1(0, 5, 0.5);
    System.out.println();
    tabulate2(-10, 10, 2);
  }
}
