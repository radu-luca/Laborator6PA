import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {

        setLayout(new GridLayout(1, 4));

        add(saveBtn);
        add(resetBtn);
        add(loadBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG",
                    new FileOutputStream("d:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void exit(ActionEvent e)
    {
        System.exit(0);
    }
    private void reset(ActionEvent e)
    {
        frame.canvas.graphics.setColor(Color.WHITE); //fill the image with white
        frame.canvas.graphics.fillRect(0, 0, 800, 600);
    }
    private void load(ActionEvent e)
    {
        try {
            frame.canvas.image = ImageIO.read(new File("d:/test2.png"));
            frame.canvas.graphics = frame.canvas.image.createGraphics();
        }
        catch (IOException err) {
            System.out.println("Error loading iamge");
        }
    }



}
