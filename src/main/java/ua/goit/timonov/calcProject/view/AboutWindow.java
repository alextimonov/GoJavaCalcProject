package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Window with info about app
 */
public class AboutWindow extends JFrame {

    /* default sizes of frame */
    public static final int WIDTH_DEFAULT = 150;
    public static final int HEIGHT_DEFAULT = 50;

    /**
     * Frame constructor
     */
    public AboutWindow() {
        setTitle("About");
        setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        Image img = new ImageIcon("resources/calcIcon.png").getImage();
        setIconImage(img);
        setResizable(false);
        setVisible(false);

        JButton buttonOk = new JButton("OK") {{
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hideAbout();
                }
            });

        }};

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setText("Calculator for math expressions with brackets \n" +
                         "Created by Alexey Timonov, 2016");

        add(textPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(buttonOk, new GridBagConstraints(0, 1, 1, 1, 0.5, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        pack();
    }

    /**
     * shows window about app
     */
    public void showAbout() {
        setVisible(true);
    }

    /**
     * hides window about app
     */
    public void hideAbout() {
        setVisible(false);
    }
}
