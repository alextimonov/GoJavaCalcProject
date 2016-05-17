package ua.goit.timonov.calcProject.view;

import ua.goit.timonov.calcProject.logic.Evaluator;
import ua.goit.timonov.calcProject.logic.StringExpression;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 15.05.2016.
 */
public class SimpleFrame extends JFrame {

    public static final String START_ZERO = "0";
    private JTextField textField;
    private JPanel buttonPanel;

    public static final int WIDTH_DEFAULT = 250;
    public static final int HEIGHT_DEFAULT = 250;

    private StringBuilder expression = new StringBuilder();
    private Evaluator evaluator = new Evaluator();

    public SimpleFrame()  {

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

        textField = new JTextField("0");
        textField.setSize(280, 30);
        textField.setLocation(1, 180);
        add(textField);

        buttonPanel = new JPanel();
        buttonPanel.setSize(280, 200);
        buttonPanel.setLocation(1, 30);
        add(buttonPanel);

        JButton buttonEqual = new JButton("=");
        JButton buttonReset = new JButton("C");
        JButton buttonBackspace = new JButton("<");

        makeButton("7", '7');
        makeButton("8", '8');
        makeButton("9", '9');
        makeButton("/", '/');
        buttonPanel.add(buttonReset);

        makeButton("4", '4');
        makeButton("5", '5');
        makeButton("6", '6');
        makeButton("*", '*');
        buttonPanel.add(buttonBackspace);

        makeButton("1", '1');
        makeButton("2", '2');
        makeButton("3", '3');
        makeButton("-", '-');
        makeButton("(", '(');

        makeButton("0", '0');
        makeButton(".", '.');
        buttonPanel.add(buttonEqual);
        makeButton("+", '+');
        makeButton(")", ')');

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    double result = evaluator.evaluate(expression.toString());
                    textField.setText(String.valueOf(result));
                }
                catch (Exception ex) {
                    textField.setText("Error!");
                }
                expression = new StringBuilder();
            }
        });

        buttonBackspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expression.length() > 1) {
                    expression.deleteCharAt(expression.length() - 1);
                    textField.setText(expression.toString());
                }
                else {
                    expression = new StringBuilder();
                    textField.setText(START_ZERO);
                }

            }
        });

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression = new StringBuilder();
                textField.setText(START_ZERO);
            }
        });


        /*// add buttons to panel
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
    }

    public  void makeButton(String name, final char symbol) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expression.append(symbol);
                textField.setText(expression.toString());
            }
        });
    }

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
