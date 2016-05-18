package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18.05.2016.
 */
public class AboutWindow extends JFrame {

    public AboutWindow() {
        setTitle("About");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        setResizable(false);
        setVisible(false);

        JButton buttonOk = new JButton("Ok") {{
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hideAbout();
                }
            });

        }};

        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setText("Calculator with parsing expressions \n" +
                         "Created by Alexey Timonov, 2016 \n" +
                         "All rights reserved");

        add(textPane, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        add(buttonOk, new GridBagConstraints(0, 1, 1, 1, 0.5, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        pack();
    }

    public void showAbout() {
        setVisible(true);
    }

    public void hideAbout() {
        setVisible(false);
    }
}
