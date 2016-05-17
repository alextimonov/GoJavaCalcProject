package ua.goit.timonov.calcProject.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 15.05.2016.
 */
public class CalcMain {
    private StringBuilder expression = new StringBuilder();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalcFrame frame = new CalcFrame();
                frame.setTitle("Calculator Project");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}