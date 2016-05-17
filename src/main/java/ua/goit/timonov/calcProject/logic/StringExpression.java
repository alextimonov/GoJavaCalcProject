package ua.goit.timonov.calcProject.logic;

/**
 * Created by Alex on 17.05.2016.
 */
@Deprecated
public class StringExpression {
    private StringBuilder expression;

    public StringExpression() {
        expression = new StringBuilder();
    }

    public StringBuilder getExpression() {
        return expression;
    }

    public void setExpression(StringBuilder expression) {
        this.expression = expression;
    }

    public void addSymbol(char symbol) {
        expression.append(symbol);
    }

    @Override
    public String toString() {
        return expression.toString();
    }

    public void clearExpression() {
        expression = new StringBuilder();
    }
}
