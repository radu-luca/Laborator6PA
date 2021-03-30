import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    Color configColor = Color.BLACK ;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        String [] test = {"random","black"};
        colorCombo = new JComboBox(test);
        colorCombo.setEditable(true);
        colorCombo.addActionListener(this::comboBox);
        //create the colorCombo, containing the values: Random and Black
 //...TODO
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }
    private void comboBox(ActionEvent e)
    {
        Object selected = colorCombo.getSelectedItem();
        if(selected.toString().equals("black")) {
            configColor=Color.BLACK;
        }
        else if(selected.toString().equals("random"))
        {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            configColor = new Color(R, G, B); //random color, but can be bright or dull
        }
    }

}
