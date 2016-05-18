package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu bar
 */
public class MenuBar extends JMenuBar {
    /* Window about app */
    private AboutWindow aboutWindow = new AboutWindow();

    /**
     * Menu bar constructor
     */
    public MenuBar() {
        JMenu menuFile = new JMenu("File");
        JMenuItem fileMenuItemExit = new JMenuItem("Exit");
        menuFile.add(fileMenuItemExit);

        JMenu menuHelp = new JMenu("Help");
        JMenuItem helpMenuItemAbout = new JMenuItem("About");
        menuHelp.add(helpMenuItemAbout);

        add(menuFile);
        add(menuHelp);

        fileMenuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        helpMenuItemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                aboutWindow.showAbout();
            }
        });
    }
}
