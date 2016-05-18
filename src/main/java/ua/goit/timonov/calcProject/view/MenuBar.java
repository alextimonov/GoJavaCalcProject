package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 18.05.2016.
 */
public class MenuBar extends JMenuBar {
    private AboutWindow aboutWindow = new AboutWindow();

    public MenuBar() {

        JMenu menuFile = new JMenu("File");
        JMenuItem fileMenuItemExit = new JMenuItem("Exit");
        menuFile.add(fileMenuItemExit);

        /*JMenu menuEdit = new JMenu("Edit");
        JMenuItem editMenuItemCopy = new JMenuItem("Copy");
        JMenuItem editMenuItemPaste = new JMenuItem("Paste");
        menuEdit.add(editMenuItemCopy);
        menuEdit.add(editMenuItemPaste);*/

        JMenu menuHelp = new JMenu("Help");
        JMenuItem helpMenuItemAbout = new JMenuItem("About");
        menuHelp.add(helpMenuItemAbout);

        add(menuFile);
//        add(menuEdit);
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
