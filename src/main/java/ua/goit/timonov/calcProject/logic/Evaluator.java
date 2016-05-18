package ua.goit.timonov.calcProject.logic;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Evaluator for math expressions with braces
 * Supports math operations: addition, subtraction, multiplication, division
 * Supports sign "-" for start numbers of numbers after opening braces
 * Logs results to files "calcProject_log.txt"
 */
public class Evaluator {

//    private static Logger log = Logger.getLogger(Evaluator.class.getName());

    public double evaluate(String inputString) {
        /*try {
            LogManager.getLogManager().readConfiguration(
                    Evaluator.class.getResourceAsStream("/logging.properties"));
        }
        catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        log.info("Input string: " + inputString);*/
        double result = 0;
        try {
            List<String> postfix = new InfixToPostfix(inputString).transform();
            result = new ParsePostfix(postfix).doParse();
        }
        catch (IllegalArgumentException exception) {
//            log.severe("Exception: " + exception.toString());
            throw exception;
        }
//        log.info("Resulting value: " + String.valueOf(result));
        return result;
    }
}
