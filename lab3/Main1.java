import java.util.Scanner;

public class Main1 {
  public static double dRound(double x, int n) {
    // Return `x` rounded to `n` decimal places
    return Math.round(x * Math.pow(10, n)) / Math.pow(10, n);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter edge length of cube: ");
    double A = scanner.nextDouble();

    System.out.print("Enter length of rectangular cuboid: ");
    double D = scanner.nextDouble();

    System.out.print("Enter width of rectangular cuboid: ");
    double C = scanner.nextDouble();

    System.out.print("Enter height of rectangular cuboid: ");
    double H = scanner.nextDouble();

    Solid cube = new Cube(A);
    Solid cuboid = new RectangularCuboid(D, C, H);

    System.out.println("Volume of the cube: " + dRound(cube.getVolume(), 4));
    System.out.println("Surface area of the cube: " + dRound(cube.getSurfaceArea(), 4));
    System.out.println("Volume of the rectangular cuboid: " + dRound(cuboid.getVolume(), 4));
    System.out.println("Surface area of the rectangular cuboid: " + dRound(cuboid.getSurfaceArea(), 4));
  }
}

abstract class Solid {
  public abstract double getVolume();

  public abstract double getSurfaceArea();
}

class RectangularCuboid extends Solid {
  private double D, C, H;

  public RectangularCuboid(double length, double width, double height) {
    this.D = length;
    this.C = width;
    this.H = height;
  }

  @Override
  public double getVolume() {
    return (D * C * H);
  }

  @Override
  public double getSurfaceArea() {
    return (2 * (D * C + D * H + C * H));
  }
}

class Cube extends Solid {
  private double A;

  public Cube(double length) { this.A = length; }

  @Override
  public double getVolume() {
    return Math.pow(A, 3);
  }

  @Override
  public double getSurfaceArea() {
    return (6 * Math.pow(A, 2));
  }
}
