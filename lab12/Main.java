import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DialogMessage extends Frame implements ActionListener {
  Dialog dialog;

  public DialogMessage(Frame owner, String title, String message) {
    Font font = new Font("Verdana", Font.PLAIN, 16);

    dialog = new Dialog(owner, title);

    Label label = new Label(message, Label.CENTER);
    Button button = new Button("OK");

    setLayout(new BorderLayout());

    button.addActionListener(this);

    label.setFont(font);
    button.setFont(font);

    dialog.add(label, BorderLayout.CENTER);
    dialog.add(button, BorderLayout.SOUTH);

    dialog.setSize(450, 150);
    dialog.setLocationRelativeTo(null);
    dialog.setResizable(false);
    dialog.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    dialog.setVisible(false);
    dialog.dispose();
  }
}

class CalculatorWindow extends Frame implements WindowListener, ActionListener {
  private Font font;
  private TextField radiusInput;
  private TextField heightInput;
  private TextField volumeOutput;

  public CalculatorWindow() {
    super();

    setTitle("Cone Volume Calculator");
    setSize(500, 250);
    setLocationRelativeTo(null);
    setResizable(false);

    addWindowListener(this);

    font = new Font("Verdana", Font.PLAIN, 24);

    setLayout(new BorderLayout());

    // Main panel
    Panel mainPanel = new Panel(new GridLayout(3, 2));

    Label radiusLabel = new Label("Radius:");
    Label heightLabel = new Label("Height:");
    Label volumeLabel = new Label("Volume:");

    radiusInput = new TextField();
    heightInput = new TextField();

    volumeOutput = new TextField();

    volumeOutput.setEditable(false);

    radiusLabel.setFont(font);
    heightLabel.setFont(font);
    volumeLabel.setFont(font);

    radiusInput.setFont(font);
    heightInput.setFont(font);
    volumeOutput.setFont(font);

    mainPanel.add(radiusLabel);
    mainPanel.add(radiusInput);

    mainPanel.add(heightLabel);
    mainPanel.add(heightInput);

    mainPanel.add(volumeLabel);
    mainPanel.add(volumeOutput);

    add(mainPanel, BorderLayout.NORTH);

    Button calculateButton = new Button("Calculate");

    calculateButton.setActionCommand("calculate");
    calculateButton.addActionListener(this);

    calculateButton.setFont(font);

    add(calculateButton, BorderLayout.CENTER);

    setVisible(true);
 }

  public void windowClosing(WindowEvent event) {
    setVisible(false);
    dispose();
    System.exit(0);
  }

  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();

    if (command.equals("calculate")) {
      String radiusText, heightText;
      double radius, height, volume;

      radiusText = radiusInput.getText();
      heightText = heightInput.getText();

      try {
        radius = Double.parseDouble(radiusText);
      } catch (NumberFormatException e) {
        new DialogMessage(this, "Error", "The radius of the cone must be a valid number");
        return;
      }

      if (radius <= 0) {
        new DialogMessage(this, "Error", "The radius of the cone must be more than zero");
        return;
      }

      try {
        height = Double.parseDouble(heightText);
      } catch (NumberFormatException e) {
        new DialogMessage(this, "Error", "The height of the cone must be a valid number");
        return;
      }

      if (height <= 0) {
        new DialogMessage(this, "Error", "The height of the cone must be more than zero");
        return;
      }

      volume = (Math.PI * Math.pow(radius, 2) * height) / 3;

      volumeOutput.setText(String.valueOf(volume));
    }
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
    new CalculatorWindow();
  }
}
