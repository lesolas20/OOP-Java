import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> studentArrayList = new ArrayList<>();

    studentArrayList.add("Smith");
    studentArrayList.add("New York");
    studentArrayList.add("Johnson");
    studentArrayList.add("London");
    studentArrayList.add("Williams");
    studentArrayList.add("Paris");
    studentArrayList.add("Robertson");
    studentArrayList.add("Tokyo");
    studentArrayList.add("Jones");
    studentArrayList.add("Berlin");
    studentArrayList.add("Miller");
    studentArrayList.add("Sydney");
    studentArrayList.add("Davis");
    studentArrayList.add("Madrid");
    studentArrayList.add("Wilson");
    studentArrayList.add("Rome");
    studentArrayList.add("Moore");
    studentArrayList.add("Dubai");
    studentArrayList.add("Taylor");
    studentArrayList.add("Mumbai");

    boolean running = true;

    while (running) {
      System.out.println("1. Add element");
      System.out.println("2. Delete element");
      System.out.println("3. Search element");
      System.out.println("4. Exit");
      System.out.print("Select an option: ");

      int option = scanner.nextInt();
      int i;

      switch (option) {
      case 1:
        System.out.print("Enter surname to add: ");
        String surname = scanner.next();
        studentArrayList.add(surname);

        System.out.print("Enter birthplace to add: ");
        String birthplace = scanner.next();
        studentArrayList.add(birthplace);

        System.out.println("Added: " + surname + ", " + birthplace);
        break;

      case 2:
        System.out.print("Enter element to delete: ");
        String deleteElement = scanner.next();

        i = studentArrayList.indexOf(deleteElement);

        if (i == -1) {
          System.out.println("Element not found");
        } else {
          studentArrayList.remove(i);
          studentArrayList.remove(i);
          System.out.println("Deleted: " + deleteElement);
        }

        break;

      case 3:
        System.out.print("Enter element to search: ");
        String searchElement = scanner.next();

        i = studentArrayList.indexOf(searchElement);

        if (i == -1) {
          System.out.println("Element not found");
        } else {
          System.out.println("Found " + searchElement + " - " +
                             studentArrayList.get(i + 1));
        }
        break;

      case 4:
        running = false;
        System.out.println("Exiting...");
        break;

      default:
        System.out.println("Invalid option");
      }
    }

    scanner.close();
  }
}
