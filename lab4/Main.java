import java.util.Scanner;

public class Main {
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

    Cube cube = new Cube(A);
    RectangularCuboid cuboid = new RectangularCuboid(D, C, H);

    Cube default_cube = new Cube();
    RectangularCuboid default_cuboid = new RectangularCuboid();

    System.out.println();

    System.out.println("Volume of the cube: " + dRound(cube.getVolume(), 4));
    System.out.println("Surface area of the cube: " + dRound(cube.getSurfaceArea(), 4));
    System.out.println("Volume of the rectangular cuboid: " + dRound(cuboid.getVolume(), 4));
    System.out.println("Surface area of the rectangular cuboid: " + dRound(cuboid.getSurfaceArea(), 4));

    System.out.println();

    System.out.println("Volume of the default cube: " + dRound(default_cube.getVolume(), 4));
    System.out.println("Surface area of the default cube: " + dRound(default_cube.getSurfaceArea(), 4));
    System.out.println("Volume of the default rectangular cuboid: " + dRound(default_cuboid.getVolume(), 4));
    System.out.println("Surface area of the default rectangular cuboid: " + dRound(default_cuboid.getSurfaceArea(), 4));

    System.out.println();

    System.out.println("The cube and a default cube are equal: " + cube.equals(default_cube));
    System.out.println("The rectangular cuboid and a default rectangular cuboid are equal: " + cuboid.equals(default_cuboid));
  }
}

abstract class Solid {
  static int instanceCounter;

  public abstract double getVolume();

  public abstract double getSurfaceArea();
}

class RectangularCuboid extends Solid {
  private double D, C, H;

  {
    D = 1;
    C = 1;
    H = 1;

    ++instanceCounter;
  }

  public RectangularCuboid() {}

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

  public boolean equals(RectangularCuboid other) {
    return ((D == other.D) && (C == other.C) && (H == other.H));
  }

  public static int getInstanceCount() { return instanceCounter; };
}

class Cube extends Solid {
  private double A;

  {
    A = 1;

    ++instanceCounter;
  }

  public Cube() {}

  public Cube(double length) { this.A = length; }

  @Override
  public double getVolume() {
    return Math.pow(A, 3);
  }

  @Override
  public double getSurfaceArea() {
    return (6 * Math.pow(A, 2));
  }

  public boolean equals(Cube other) { return (A == other.A); }

  public static int getInstanceCount() { return instanceCounter; };
}
