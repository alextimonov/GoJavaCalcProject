package ua.goit.timonov.calcProject.view;

import ua.goit.timonov.calcProject.logic.Evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.GridBagConstraints.HORIZONTAL;
import static java.awt.GridBagConstraints.NORTH;

/**
 * Panel with calc buttons
 */
public class ButtonPanel extends JPanel {

    /* Start value in text field */
    public static final String START_ZERO = "0.0";
    /* Message about error */
    public static final String MESSAGE_ERROR = "ERROR!";

    // String with inputted symbol sequence that can be a future expression
    private String expression = new String();
    // expression evaluator
    private Evaluator evaluator = new Evaluator();
    // text field for input expression and output result
    private JTextField textField;

    /**
     * Button panel constructor
     * @param textField     CalcFrame text field
     */
    public ButtonPanel(JTextField textField) {
        setLayout(new GridBagLayout());
        setVisible(true);
        this.textField = textField;
        createButtons();
    }

    // creates calc buttons, adds their listeners
    private void createButtons() {
        JButton buttonEqual = new JButton("=");
        JButton buttonReset = new JButton("C");
        JButton buttonBackspace = new JButton("BS");

        makeButton('7', 0, 0);
        makeButton('8', 1, 0);
        makeButton('9', 2, 0);
        makeButton('/', 3, 0);
        add(buttonReset, new GridBagConstraints(4, 0, 1, 1, 1, 1, NORTH, HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        makeButton('4', 0, 1);
        makeButton('5', 1, 1);
        makeButton('6', 2, 1);
        makeButton('*', 3, 1);
        add(buttonBackspace, new GridBagConstraints(4, 1, 1, 1, 1, 1, NORTH, HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        makeButton('1', 0, 2);
        makeButton('2', 1, 2);
        makeButton('3', 2, 2);
        makeButton('-', 3, 2);
        makeButton('(', 4, 2);

        makeButton('0', 0, 3);
        makeButton('.', 1, 3);
        add(buttonEqual, new GridBagConstraints(2, 3, 1, 1, 1, 1, NORTH, HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        makeButton('+', 3, 3);
        makeButton(')', 4, 3);

        // action for button "="
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

        // action for button "Backspace (BS)"
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

            // return true if Backspace can reduce the expression in text field
            private boolean lineCouldBeReduced() {
                return expression.length() > 1 && !expression.equals(START_ZERO) && !expression.equals(MESSAGE_ERROR);
            }
        });

        // Action for reset button (C)
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(START_ZERO);
            }
        });
    }

    // creates button with given symbol at given place of panel grid
    private void makeButton(final char symbol, int gridX, int gridY) {
        JButton button = new JButton(String.valueOf(symbol));
        add(button, new GridBagConstraints(gridX, gridY, 1, 1, 1, 1, NORTH, HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
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
}