package ua.goit.timonov.calcProject.view;

import ua.goit.timonov.calcProject.logic.Evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 15.05.2016.
 */
public class CalcFrame extends JFrame {

    public static final String START_ZERO = "0.0";
    public static final String MESSAGE_ERROR = "ERROR!";

    private JTextField textField;
    private JPanel buttonPanel;

    public static final int WIDTH_DEFAULT = 250;
    public static final int HEIGHT_DEFAULT = 250;

    private String expression = new String();
    private Evaluator evaluator = new Evaluator();

    public CalcFrame()  {

//        setLocation(300, 200);
//        frame.setUndecorated(true);

        setTitle("Calculator Project");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
//        setSize(screenWidth / 3, screenHeight / 3);
//        setExtendedState(Frame.MAXIMIZED_BOTH);

        setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
        setResizable(false);
        setLocationByPlatform(true);
        setVisible(true);
        Image img = new ImageIcon("resources/calcIcon.png").getImage();
        setIconImage(img);

//        Container contentPane = getContentPane();
//        Component comp = new ;
//        contentPane.add(comp);
//        add(new TextComponent());

        /*// create buttons
        JButton buttonOne = new JButton("1");
        JButton buttonTwo = new JButton("2");
        JButton buttonThree = new JButton("3");
        JButton buttonFour = new JButton("4");*/

        textField = new JTextField(START_ZERO);
        textField.setSize(240, 30);
        textField.setLocation(1, 180);
        add(textField);

        buttonPanel = new JPanel();
        buttonPanel.setSize(248, 200);
        add(buttonPanel);
        buttonPanel.setLocation(1, 1);

        JButton buttonEqual = new JButton("=");
        JButton buttonReset = new JButton("C");
        JButton buttonBackspace = new JButton("<");

        makeButton('7');
        makeButton('8');
        makeButton('9');
        makeButton('/');
        buttonPanel.add(buttonReset);

        makeButton('4');
        makeButton('5');
        makeButton('6');
        makeButton('*');
        buttonPanel.add(buttonBackspace);

        makeButton('1');
        makeButton('2');
        makeButton('3');
        makeButton('-');
        makeButton('(');

        makeButton('0');
        makeButton('.');
        buttonPanel.add(buttonEqual);
        makeButton('+');
        makeButton(')');

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    expression = textField.getText();
                    double result = evaluator.evaluate(expression);
                    textField.setText(String.valueOf(result));
                }
                catch (Exception ex) {
                    textField.setText(MESSAGE_ERROR);
                }
            }
        });

        buttonBackspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = textField.getText();
                if (lineCouldBeReduced()) {
                    textField.setText(expression.substring(0, expression.length() - 1));
                }
                else {
                    textField.setText(START_ZERO);
                }

            }

            private boolean lineCouldBeReduced() {
                return expression.length() > 1 && !expression.equals(START_ZERO) && !expression.equals(MESSAGE_ERROR);
            }
        });

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(START_ZERO);
            }
        });

    }

    public void makeButton(final char symbol) {
        JButton button = new JButton(String.valueOf(symbol));
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals(START_ZERO)) {
                    textField.setText(String.valueOf(symbol));
                }
                else {
                    textField.setText(textField.getText() + symbol);
                }
            }
        });
    }

    /* from frame
    // add buttons to panel
        buttonPanel.add(buttonOne);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);
        buttonPanel.add(buttonFour);

        // create button actions
        ButtonPressed buttonOneAction = new ButtonPressed('1');
        ButtonPressed buttonTwoAction = new ButtonPressed('2');
        ButtonPressed buttonThreeAction = new ButtonPressed('3');
        ButtonPressed buttonFourAction = new ButtonPressed('4');

        // associate actions with buttons
        buttonOne.addActionListener(buttonOneAction);
        buttonTwo.addActionListener(buttonTwoAction);
        buttonThree.addActionListener(buttonThreeAction);
        buttonFour.addActionListener(buttonFourAction);*/

//        pack();

   /* private class ButtonPressed implements ActionListener {
        private char symbol;

        public ButtonPressed(char symbol) {
            this.symbol = symbol;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            expression.append(symbol);
        }
    }*/
}
