package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.*;

/**
 * Main app frame
 */
public class CalcFrame extends JFrame {

    /* default sizes of frame */
    public static final int WIDTH_DEFAULT = 250;
    public static final int HEIGHT_DEFAULT = 250;

    // menu bar
    private JMenuBar menuBar;
    // field for input expression and output result
    private JTextField textField;
    // panel with buttons
    private JPanel buttonPanel;

    /**
     * Frame constructor
     */
    public CalcFrame()  {
        setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Calculator Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        Image img = new ImageIcon("resources/calcIcon.png").getImage();
        setIconImage(img);
        menuBar = new MenuBar();
        textField = new JTextField();
        buttonPanel = new ButtonPanel(textField);

        setJMenuBar(menuBar);
        add(textField, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        add(buttonPanel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        pack();
        setVisible(true);
    }
}
