import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Window extends Frame implements WindowListener, KeyListener, MouseMotionListener {
  Point lastPosition = null;

  public Window() {
    super();
    addWindowListener(this);
    addKeyListener(this);
    addMouseMotionListener(this);
  }

  public void windowClosing(WindowEvent event) {
    setVisible(false);
    dispose();
    System.exit(0);
  }

  public void keyPressed(KeyEvent event) {
    if (event.getKeyCode() == KeyEvent.VK_SPACE) {
      repaint();
    }
  }

  public void mouseExited(MouseEvent event) {
    lastPosition = null;
  }

  public void mouseMoved(MouseEvent event) {
    Point currentPosition = event.getPoint();

    if (lastPosition != null) {
      Graphics g = getGraphics();
      g.drawLine(lastPosition.x, lastPosition.y, currentPosition.x, currentPosition.y);
    }

    lastPosition = currentPosition;
  }

  public void windowActivated(WindowEvent event) {}
  public void windowClosed(WindowEvent event) {}
  public void windowDeiconified(WindowEvent event) {}
  public void windowOpened(WindowEvent event) {}
  public void windowIconified(WindowEvent event) {}
  public void windowDeactivated(WindowEvent event) {}

  public void keyReleased(KeyEvent event) {}
  public void keyTyped(KeyEvent event) {}

  public void mouseEntered(MouseEvent event) {}
  public void mouseDragged(MouseEvent event) {}
}

public class Main {
  public static void main(String[] args) {
    Window mainWindow = new Window();

    mainWindow.setSize(900, 500);
    mainWindow.setLocationRelativeTo(null);
    mainWindow.setVisible(true);
  }
}
