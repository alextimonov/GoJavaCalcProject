package ua.goit.timonov.calcProject.view;

import java.awt.*;

/**
 * Main class that runs app
 */
public class CalcMain {
//    private static Logger log = Logger.getLogger(CalcMain.class.getName());

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CalcFrame frame = new CalcFrame();
            }
        });
    }
}
