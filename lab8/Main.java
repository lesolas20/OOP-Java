import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class Main {
  static void encodeFile(String inputFileName, String outputFileName,
                         String key) {
    try {
      Reader input = new FileReader(inputFileName);
      Writer output = new FileWriter(outputFileName);

      int x;
      int i = 0;

      while (input.ready()) {
        x = key.charAt(i);
        i++;
        if (i == key.length()) {
          i = 0;
        }
        output.write(input.read() ^ x);
      }

      input.close();
      output.flush();
      output.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    String key = "John Smith";
    String file1 = "original.txt";
    String file2 = "encoded.txt";
    String file3 = "decoded.txt";

    encodeFile(file1, file2, key);
    encodeFile(file2, file3, key);
  }
}
