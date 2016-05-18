package ua.goit.timonov.calcProject.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for parse postfix writing of expression and evaluate it
 */
public class ParsePostfix {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';

    // permitted value of deviation
    public static final double DELTA = 10E-12;

    // input list with postfix writing of math expression
    private List<String> postfixWrite;
    // auxiliary stack with operators
    private LinkedList stackOperands;


    /**
     * ParsePostfix constructor
     * @param postfixWrite      input list performing postfix writing
     */
    public ParsePostfix(List<String> postfixWrite) {
        this.postfixWrite = postfixWrite;
    }

    /**
     * parses  postfix writing of expression and evaluate it
     * @return      double result of expression
     */
    public double doParse()
    {
        stackOperands = new LinkedList<Double>();
        double number1, number2;
        double result;
        for (String item : postfixWrite) {
            if (isNumber(item)) {
                stackOperands.addFirst(Double.parseDouble(item) );
            }
            else
            {
                try {
                    number2 = (double) stackOperands.remove();
                    number1 = (double) stackOperands.remove();
                } catch (NoSuchElementException e) {
                    throw new IllegalArgumentException(e.getMessage() +
                            " There's not enough operators or unwanted closing brace");
                }
                switch (item.charAt(0))
                {
                    case PLUS:
                        result = number1 + number2;
                    break;
                    case MINUS:
                        result = number1 - number2;
                        break;
                    case MULTIPLY:
                        result = number1 * number2;
                        break;
                    case DIVIDE:
                        if (Math.abs(number2) < DELTA) {
                            throw new IllegalArgumentException("Dividing by zero!");
                        }
                        result = number1 / number2;
                        break;
                    default:
                        result = 0;
                }
                stackOperands.addFirst(result);
            }
        }
        if (stackOperands.isEmpty()) return 0;
            result = (double) stackOperands.remove();
        return result;
    }

    // checks if given string contains floating point number
    private boolean isNumber(String string) {
        char firstSymbol = string.charAt(0);
        return (firstSymbol >= InfixToPostfix.DIGIT_0 && firstSymbol <= InfixToPostfix.DIGIT_9) ||
                firstSymbol == InfixToPostfix.DOT ||
                (firstSymbol == InfixToPostfix.MINUS && string.length() > 1);
    }
}
