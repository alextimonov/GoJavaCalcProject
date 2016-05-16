package ua.goit.timonov.calcProject.logic;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Alex on 15.05.2016.
 */
public class ParsePost {
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTIPLY = '*';
    public static final char DIVIDE = '/';
    public static final double DEVIATION = 10E-12;

    private LinkedList stackOperands;
    private List<String> postfixWrite;

    /*public ParsePost(String inputString) {
        this.inputString = inputString;
    }*/

    public ParsePost(List<String> postfixWrite) {
        this.postfixWrite = postfixWrite;
    }

    public double doParse()
    {
        stackOperands = new LinkedList<Double>(); // Создание объекта стека
//        char symbol;
        double number1, number2;
        double result;
        for (String item : postfixWrite) {
//            stackOperands.displayStack(""+symbol+" "); // *диагностика*
            if (InfixToPostfix.referToNumber(item.charAt(0))) {
                stackOperands.addFirst(Double.parseDouble(item) ); // Занести в стек
            }
            else // Если это оператор
            {
                try {
                    number2 = (double) stackOperands.remove();
                    number1 = (double) stackOperands.remove();
                } catch (NoSuchElementException e) {
                    throw new IllegalArgumentException(e.getMessage() +
                            " There's not enough operators or unwanted closing bracket");
                }
                switch (item.charAt(0)) // Выполнение арифметической
                { // операции
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
                        if (Math.abs(number2) < DEVIATION) {
                            throw new IllegalArgumentException("Dividing by zero!");
                        }
                        result = number1 / number2;
                        break;
                    default:
                        result = 0;
                }
                stackOperands.addFirst(result); // Занесение промежуточного
            } // результата в стек
        }
        if (stackOperands.isEmpty()) return 0;
//        try {
            result = (double) stackOperands.remove();
//        }
//        catch (NoSuchElementException e) {
//            throw new IllegalArgumentException(e.getMessage() + " There's not enough operators!");
//        }
        return result;
    }
}
