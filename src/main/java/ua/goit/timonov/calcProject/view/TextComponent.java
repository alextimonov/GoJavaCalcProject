package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Alex on 16.05.2016.
 */
@Deprecated
public class TextComponent extends JComponent {

    public static final int MESSAGE_X = 50;
    public static final int MESSAGE_Y = 50;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        g.drawString("Here is some text!", MESSAGE_X, MESSAGE_Y);

        Graphics2D g2 = (Graphics2D) g;
        Font sansbold14 = new Font("SansSerif", Font.BOLD, 14);
        g2.setFont(sansbold14);
        g2.drawString("Here is some text!", 70, 100);


        // drawing rectangle
        Rectangle2D rect = new Rectangle(20, 20, 50, 50);
        g2.draw(rect);

    }

}
