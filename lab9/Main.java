import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class Main {
  private static ByteArrayInputStream
  generateRandomByteArrayInputStream(int size) {
    byte[] bytes = new byte[size];
    for (int i = 0; i < size; i++) {
      bytes[i] = (byte)(30 + (Math.random() * 20));
    }
    return new ByteArrayInputStream(bytes);
  }

  public static void main(String[] args) {
    int numStreams = 5;
    int byteArraySize = 15;

    Vector<InputStream> streamVector = new Vector<>(numStreams);

    for (int i = 0; i < numStreams; i++) {
      streamVector.add(generateRandomByteArrayInputStream(byteArraySize));
    }

    Enumeration<InputStream> enumStreams = streamVector.elements();

    SequenceInputStream sequenceStream = new SequenceInputStream(enumStreams);

    int bytesRead;
    try {
      while ((bytesRead = sequenceStream.read()) != -1) {
        System.out.print(bytesRead + " ");
      }
      System.out.print("\n");
      sequenceStream.close();
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
