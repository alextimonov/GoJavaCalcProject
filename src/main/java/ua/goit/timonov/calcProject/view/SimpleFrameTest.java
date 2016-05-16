package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 15.05.2016.
 */
public class SimpleFrameTest  {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                SimpleFrame frame = new SimpleFrame();
            }
        });
    }
}
