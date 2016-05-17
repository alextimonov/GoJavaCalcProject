package ua.goit.timonov.calcProject.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Alex on 14.05.2016.
 */
public class InfixToPostfix {
    public static final char DIGIT_0 = '0';
    public static final char DIGIT_9 = '9';
    public static final char DOT = '.';
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';
    public static final char OPEN_BRACKET = '(';
    public static final char CLOSE_BRACKET = ')';
    public static final char SPACE = ' ';
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_HIGH = 2;

    private static Logger log = Logger.getLogger(InfixToPostfix.class.getName());

    private LinkedList operatorStack;
    private String inputString;
    private List postfixWrite = new ArrayList<String>();

    public InfixToPostfix(String inputString)
    {
        this.inputString = inputString;
        operatorStack = new LinkedList<Character>();
    }

    public List<String> transform()
    {
        log.info("Input string: " + inputString);
        StringBuilder nextNumber = new StringBuilder();
        for (int j = 0; j < inputString.length(); j++)
        {
            char symbol = inputString.charAt(j);
            if (referToNumber(symbol, j)) nextNumber.append(symbol);
            else {
                if (nextNumber.length() > 0) {
                    checkNumber(nextNumber);
                    postfixWrite.add(nextNumber.toString());
                    nextNumber = new StringBuilder();
                }
                switch (symbol) {
                    case PLUS:
                    case MINUS:
                        getOperator(symbol, PRIORITY_LOW);
                    break;
                    case MULTIPLY:
                    case DIVIDE:
                        getOperator(symbol, PRIORITY_HIGH);
                    break;
                    case OPEN_BRACKET:
                        operatorStack.addFirst(symbol);
                    break;
                    case CLOSE_BRACKET:
                        getClosingBracket(symbol);
                    break;
                    case SPACE:
                        // NOP
                    break;
                    default:
                        throw new IllegalArgumentException("There is illegal symbol!");
                }
            }
        }
        if (nextNumber.length() > 0) {
            checkNumber(nextNumber);
            postfixWrite.add(nextNumber.toString());
        }
        while( !operatorStack.isEmpty() ) // Извлечение оставшихся операторов
        {
            postfixWrite.add(String.valueOf(operatorStack.remove())); // write to output
        }
        return postfixWrite; // Возвращение постфиксного выражения
    }

    private void checkNumber(StringBuilder nextNumber) {
        int numberOfDots = 0;
        for (int i = 0; i < nextNumber.length(); i++) {
            if (nextNumber.charAt(i) == DOT) numberOfDots++;
        }
        if (numberOfDots > 1) throw new IllegalArgumentException("Wrong number! Too many dots!");
    }

    private boolean referToNumber(char symbol, int index) {
        return (symbol >= DIGIT_0 && symbol <= DIGIT_9) || symbol == DOT ||
                symbolMinusIsPartOfNumber(symbol, index) ;
    }

    private boolean symbolMinusIsPartOfNumber(char symbol, int index) {
        return symbol == MINUS && (index == 0 || inputString.charAt(index - 1) == OPEN_BRACKET);
    }

    private void getOperator(char operatorThis, int priorityThis)
    {
        while( !operatorStack.isEmpty() )
        {
            char operatorTop = (char) operatorStack.remove();
            if( operatorTop == OPEN_BRACKET )
            {
                operatorStack.addFirst(operatorTop);
                break;
            }
            else
            {
                int priorityTop; // Приоритет нового оператора
                if (operatorTop == PLUS || operatorTop == MINUS) priorityTop = PRIORITY_LOW;
                else priorityTop = PRIORITY_HIGH;
                if (priorityTop < priorityThis) // Если приоритет нового оператора
                { // меньше приоритета старого
                    operatorStack.addFirst(operatorTop); // Сохранить новый оператор
                    break;
                }
                else // Приоритет нового оператора не меньше приоритета старого
                    postfixWrite.add(String.valueOf(operatorTop));
            }
        }
        operatorStack.addFirst(operatorThis); // Занесение в стек нового оператора
    }

    private void getClosingBracket(char symbol)
    {
        boolean foundOpeningBracket = false;
        while( !operatorStack.isEmpty() )
        {
            char operatorTop = (char) operatorStack.remove();
            if( operatorTop == OPEN_BRACKET ) {
                foundOpeningBracket = true;
                break;
            }
            else postfixWrite.add(String.valueOf(operatorTop));
        }
        if (!foundOpeningBracket) throw new IllegalArgumentException("There's closing bracket before opening!");
    }
}
