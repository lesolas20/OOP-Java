import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface Mobile {
  void setSerialNumber(String serialNumber);
  String getSerialNumber();

  void setMass(double mass);
  double getMass();

  void setPrice(double price);
  double getPrice();

  void setMemory(int memory);
  int getMemory();

  void setCell(String cell);
  String getCell();
}

abstract class SiemensMobile implements Mobile {
  protected String serialNumber;
  protected double mass;
  protected double price;
  protected int memory;
  protected String cell;

  @Override
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  @Override
  public String getSerialNumber() {
    return serialNumber;
  }

  @Override
  public void setMass(double mass) {
    this.mass = mass;
  }

  @Override
  public double getMass() {
    return mass;
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public void setMemory(int memory) {
    this.memory = memory;
  }

  @Override
  public int getMemory() {
    return memory;
  }

  @Override
  public void setCell(String cell) {
    this.cell = cell;
  }

  @Override
  public String getCell() {
    return cell;
  }
}

class Model extends SiemensMobile {
  private String mobileModel;
  private int yearOfSale;

  public void setMobileModel(String mobileModel) {
    this.mobileModel = mobileModel;
  }

  public String getMobileModel() { return mobileModel; }

  public void setYearOfSale(int yearOfSale) { this.yearOfSale = yearOfSale; }

  public int getYearOfSale() { return yearOfSale; }

  @Override
  public String toString() {
    return "Model: " + mobileModel + ", Serial Number: " + serialNumber +
        ", Mass: " + mass + ", Price: " + price + ", Memory: " + memory +
        ", Cell: " + cell + ", Year of Sale: " + yearOfSale;
  }
}

public class Main {
  public static void main(String[] args) {
    Model m1 = new Model();
    m1.setMobileModel("Samsung S25");
    m1.setSerialNumber("ABC123");
    m1.setMass(200);
    m1.setPrice(500);
    m1.setMemory(256);
    m1.setCell("4G");
    m1.setYearOfSale(2020);

    Model m2 = new Model();
    m2.setMobileModel("iPhone 19");
    m2.setSerialNumber("DEF456");
    m2.setMass(190);
    m2.setPrice(800);
    m2.setMemory(192);
    m2.setCell("4G");
    m2.setYearOfSale(2025);

    Model m3 = new Model();
    m3.setMobileModel("Xiaomi 10");
    m3.setSerialNumber("X91223");
    m3.setMass(205);
    m3.setPrice(600);
    m3.setMemory(256);
    m3.setCell("4G");
    m3.setYearOfSale(2023);

    List<Model> mobiles = new ArrayList<>();
    mobiles.add(m1);
    mobiles.add(m2);
    mobiles.add(m3);

    try (FileWriter fw = new FileWriter("mobiles.txt")) {
      for (Model mob : mobiles) {
        fw.write(mob.toString() + "\n");
      }
      System.out.println("Wrote data to mobiles.txt");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
