import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


interface MenuListener extends ActionListener, ItemListener {}

class FrameMenu extends Menu {
  private MenuListener listener;

  public FrameMenu(MenuListener l) {
    super("Frame");

    listener = l;

    MenuItem backgroundMenuItem = new MenuItem("Background");
    CheckboxMenuItem borderMenuItem = new CheckboxMenuItem("Border");

    backgroundMenuItem.addActionListener(listener);
    borderMenuItem.addItemListener(listener);

    add(backgroundMenuItem);
    add(new MenuItem("-"));
    add(borderMenuItem);
  }
}

class TableMenu extends Menu {
  private MenuListener listener;

  public TableMenu(MenuListener l) {
    super("Table");

    listener = l;

    Menu tableSelectMenu = new Menu("Select");

    MenuItem tableSelectTableMenuItem = new MenuItem("Table");
    MenuItem tableSelectColumnMenuItem = new MenuItem("Column");
    MenuItem tableSelectRowMenuItem = new MenuItem("Row");
    MenuItem tableSelectCellMenuItem = new MenuItem("Cell");

    tableSelectMenu.add(tableSelectTableMenuItem);
    tableSelectMenu.add(tableSelectColumnMenuItem);
    tableSelectMenu.add(tableSelectRowMenuItem);
    tableSelectMenu.add(tableSelectCellMenuItem);

    tableSelectTableMenuItem.addActionListener(listener);
    tableSelectColumnMenuItem.addActionListener(listener);
    tableSelectRowMenuItem.addActionListener(listener);
    tableSelectCellMenuItem.addActionListener(listener);

    add(tableSelectMenu);
  }
}

class Window extends Frame implements WindowListener, MenuListener {
  public Window() {
    super();

    setSize(640, 480);
    setLocationRelativeTo(null);
    setResizable(false);

    addWindowListener(this);

    setLayout(new BorderLayout());

    MenuBar menuBar = new MenuBar();

    Menu frameMenu = new FrameMenu(this);
    Menu tableMenu = new TableMenu(this);

    frameMenu.addActionListener(this);
    tableMenu.addActionListener(this);

    menuBar.add(frameMenu);
    menuBar.add(tableMenu);

    setMenuBar(menuBar);

    setVisible(true);
 }

  public void windowClosing(WindowEvent event) {
    setVisible(false);
    dispose();
    System.exit(0);
  }

  public void actionPerformed(ActionEvent event) {
    System.out.println(event);
  }

  public void itemStateChanged(ItemEvent event) {
    System.out.println(event);
  }

  public void windowActivated(WindowEvent event) {}
  public void windowClosed(WindowEvent event) {}
  public void windowDeiconified(WindowEvent event) {}
  public void windowOpened(WindowEvent event) {}
  public void windowIconified(WindowEvent event) {}
  public void windowDeactivated(WindowEvent event) {}
}

public class Main {
  public static void main(String[] args) {
    new Window();
  }
}
