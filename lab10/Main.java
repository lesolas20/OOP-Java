import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
  public static void main(String[] args) {
    JFrame mainWindow = new JFrame();

    mainWindow.setSize(600, 300);
    mainWindow.setLocationRelativeTo(null);

    mainWindow.setTitle("Centered Window");
    mainWindow.setExtendedState(JFrame.ICONIFIED);
    mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    mainWindow.setVisible(true);

    Dimension size = mainWindow.getSize();
    Point position = mainWindow.getLocation();
    int state = mainWindow.getExtendedState();

    System.out.printf("Window size: %sx%s\n", size.width, size.height);
    System.out.printf("Window location: %s,%s\n", position.x, position.y);
    System.out.printf("Window state: %s\n", state);
  }
}
