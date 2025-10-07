import java.util.HashMap;

public class Main {
  public static void main(String[] args) {

    HashMap<String, String> studentMap = new HashMap<>();

    studentMap.put("Smith", "New York");
    studentMap.put("Johnson", "London");
    studentMap.put("Williams", "Paris");
    studentMap.put("Robertson", "Tokyo");
    studentMap.put("Jones", "Berlin");
    studentMap.put("Miller", "Sydney");
    studentMap.put("Davis", "Madrid");
    studentMap.put("Wilson", "Rome");
    studentMap.put("Moore", "Dubai");
    studentMap.put("Taylor", "Mumbai");
    studentMap.put("Smith", "Toronto");

    System.out.println("Searching for 'Smith': " + studentMap.get("Smith"));
    System.out.println("Searching for 'Taylor': " + studentMap.get("Taylor"));

    studentMap.remove("Miller");

    System.out.println("After deleting 'Miller': " + studentMap.get("Miller"));
    System.out.println("Map size after deletion: " + studentMap.size());
  }
}
