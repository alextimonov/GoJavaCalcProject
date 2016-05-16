package ua.goit.timonov.calcProject.logic;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by Alex on 15.05.2016.
 */
public class Evaluator {

    private static Logger log = Logger.getLogger(Evaluator.class.getName());

    public double evaluate(String inputString) {
        try {
            LogManager.getLogManager().readConfiguration(Evaluator.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        log.fine("Input string: " + inputString);
        double result = 0;
        try {
            List<String> postfix = new InfixToPostfix(inputString).transform();
            result = new ParsePost(postfix).doParse();
        }
        catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            log.severe("Exception: " + exception.toString());
            throw exception;
        }
        log.fine("Resulting value: " + String.valueOf(result));
        return result;
    }
}
