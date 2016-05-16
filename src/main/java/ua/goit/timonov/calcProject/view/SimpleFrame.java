package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 15.05.2016.
 */
public class SimpleFrame extends JFrame {

//    public static final int WIDTH_DEFAULT = 300;
//    public static final int HEIGHT_DEFAULT = 200;

    public SimpleFrame()  {

//        setLocation(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setUndecorated(true);
        setTitle("Calculator Project");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth / 3, screenHeight / 3);
//        setExtendedState(Frame.MAXIMIZED_BOTH);

        setLocationByPlatform(true);
        setVisible(true);

        Container contentPane = getContentPane();
//        Component comp = new ;
//        contentPane.add(comp);
        add(new TextComponent());
        pack();
    }
}
