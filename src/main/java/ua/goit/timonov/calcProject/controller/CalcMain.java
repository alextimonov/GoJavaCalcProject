package ua.goit.timonov.calcProject.controller;

import ua.goit.timonov.calcProject.view.CalcFrame;

import java.awt.*;

/**
 * Main class that runs app
 */
public class CalcMain {


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalcFrame frame = new CalcFrame();
            }
        });
    }
}
