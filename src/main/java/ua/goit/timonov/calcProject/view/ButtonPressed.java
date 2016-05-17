package ua.goit.timonov.calcProject.view;

import ua.goit.timonov.calcProject.logic.StringExpression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 17.05.2016.
 */
@Deprecated
public class ButtonPressed implements ActionListener {
    private char symbol;
//    private StringBuilder expression = new StringBuilder();
    private StringExpression line;

    public ButtonPressed(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
//        expression.append(symbol);
        line.addSymbol(symbol);
    }


}
