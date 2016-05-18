package ua.goit.timonov.calcProject.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to transform infix writing to postfix one
 */
public class InfixToPostfix {
    /* char constants */
    public static final char DIGIT_0 = '0';
    public static final char DIGIT_9 = '9';
    public static final char DOT = '.';
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';
    public static final char OPENING_BRACE = '(';
    public static final char CLOSING_BRACE = ')';
    public static final char SPACE = ' ';

    /* levels of math operator priority */
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_HIGH = 2;

    // input string with infix writing of expression
    private String inputString;
    // auxiliary stack with math operators
    private LinkedList operatorStack;
    // output list with postfix writing of expression
    private List postfixWrite = new ArrayList<String>();

    /**
     * InfixToPostfix constructor
     * @param inputString   input string with infix writing of math expression
     */
    public InfixToPostfix(String inputString)
    {
        this.inputString = inputString;
        operatorStack = new LinkedList<Character>();
    }

    /**
     * transforms infix writing to postfix one
     * @return      list of strings in order of postfix writing of expression
     */
    public List<String> transform()
    {
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
                    case OPENING_BRACE:
                        operatorStack.addFirst(symbol);
                        break;
                    case CLOSING_BRACE:
                        checkIfBracesAreEmpty(j - 1);
                        findOpeningBrace();
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
        while( !operatorStack.isEmpty() )
        {
            postfixWrite.add(String.valueOf(operatorStack.remove()));
        }
        return postfixWrite;
    }

    // checks if found braces are empty
    private void checkIfBracesAreEmpty(int j) {
        while (j > 0 && inputString.charAt(j) == SPACE) j--;
        if (inputString.charAt(j) == OPENING_BRACE) {
            throw new IllegalArgumentException("There are empty braces!");
        }
    }

    // checks if given string is supposed to contain double number has too many dots
    private void checkNumber(StringBuilder nextNumber) {
        int numberOfDots = 0;
        for (int i = 0; i < nextNumber.length(); i++) {
            if (nextNumber.charAt(i) == DOT) numberOfDots++;
        }
        if (numberOfDots > 1) throw new IllegalArgumentException("Wrong number! Too many dots!");
    }

    // checks if symbol at given place of string can be part of number
    private boolean referToNumber(char symbol, int index) {
        return (symbol >= DIGIT_0 && symbol <= DIGIT_9) || symbol == DOT ||
                minusIsPartOfNumber(symbol, index) ;
    }

    // checks if founded sign can be part of number
    private boolean minusIsPartOfNumber(char symbol, int index) {
        return symbol == MINUS && (index == 0 || inputString.charAt(index - 1) == OPENING_BRACE);
    }

    // compares priorities of founded operatorThis and operatorTop from the auxiliary stack
    // pushes operator operatorThis to auxiliary stack, writes operators to output list with postfix writing
    private void getOperator(char operatorThis, int priorityThis)
    {
        while( !operatorStack.isEmpty() )
        {
            char operatorTop = (char) operatorStack.remove();
            if( operatorTop == OPENING_BRACE)
            {
                operatorStack.addFirst(operatorTop);
                break;
            }
            else
            {
                int priorityTop;
                if (operatorTop == PLUS || operatorTop == MINUS) priorityTop = PRIORITY_LOW;
                else priorityTop = PRIORITY_HIGH;
                if (priorityTop < priorityThis)
                {
                    operatorStack.addFirst(operatorTop);
                    break;
                }
                else
                    postfixWrite.add(String.valueOf(operatorTop));
            }
        }
        operatorStack.addFirst(operatorThis);
    }

    // writes operators between opening and closing braces from auxiliary stack to postfix writing of expression
    private void findOpeningBrace()
    {
        boolean foundOpeningBrace = false;
        while( !operatorStack.isEmpty() )
        {
            char operatorTop = (char) operatorStack.remove();
            if( operatorTop == OPENING_BRACE) {
                foundOpeningBrace = true;
                break;
            }
            else postfixWrite.add(String.valueOf(operatorTop));
        }
        if (!foundOpeningBrace) throw new IllegalArgumentException("There's closing brace before opening!");
    }
}
