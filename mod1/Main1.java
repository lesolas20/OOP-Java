public class Main1 {
  public static void main(String[] args) {
    Vessel sailingVessel = new SailingVessel();
    Vessel submarine = new Submarine();

    sailingVessel.prepareToMovement();
    sailingVessel.move();

    submarine.prepareToMovement();
    submarine.move();
  }
}

interface Vessel {
  void prepareToMovement();
  void move();
}

class SailingVessel implements Vessel {
  public void prepareToMovement() {
    System.out.println("SailingVessel is preparing to move");
  }
  public void move() {
    System.out.println("SailingVessel is moving");
  }
}

class Submarine implements Vessel {
  public void prepareToMovement() {
    System.out.println("Submarine is preparing to move");
  }
  public void move() {
    System.out.println("Submarine is moving");
  }
}
