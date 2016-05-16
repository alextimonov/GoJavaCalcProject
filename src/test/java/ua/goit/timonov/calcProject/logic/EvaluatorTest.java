package ua.goit.timonov.calcProject.logic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 15.05.2016.
 */
public class EvaluatorTest {

    public static final double DELTA = 10E-6;
    Evaluator evaluator = new Evaluator();

    @Test
    public void testEvaluateNormal_1() {
        String inputString = "3 + 2 - 1";
        double expected = 4;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testEvaluateNormal_2() {
        String inputString = "3*4 - 2*5";
        double expected = 2;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateNormal_3() {
        String inputString = "3*(2+4/2)";
        double expected = 12;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateNormal_4() {
        String inputString = "3*(8/(7-5))";
        double expected = 12;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateNormal_5() {
        String inputString = "23+12/3";
        double expected = 27;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateNormal_6() {
        String inputString = "123.12+34*(12-10)";
        double expected = 191.12;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateNormal_7() {
        String inputString = "(12.5 + 29.26) / ((3.5  +2.3) * (7.5 - 6.3))";
        double expected = 6.0;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateNormal_8() {
        String inputString = "(5 + 2.5) ";
        double expected = 7.5;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateBorder_1() {
        String inputString = "120";
        double expected = 120;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateBorder_2() {
        String inputString = "1000000 * 1000000";
        double expected = 1.0E12;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateBorder_3() {
        String inputString = "";
        double expected = 0.0;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test
    public void testEvaluateBorder_4() {
        String inputString = "()";
        double expected = 0.0;
        double actual = evaluator.evaluate(inputString);
        assertEquals(expected, actual, 10E-6);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_1() {
        String inputString = ")5+2(";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_2() {
        String inputString = "5 + * 2";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_3() {
        String inputString = "+-*";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_4() {
        String inputString = "((12.5+29.26) / (3.5  +2.3)";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_5() {
        String inputString = "(2 + 5 ))";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_6() {
        String inputString = "(12.54.3+29.26) / (3.5  +2.3)";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_7() {
        String inputString = "7 / 0";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_8() {
        String inputString = "0/0";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_9() {
        String inputString = "(()";
        evaluator.evaluate(inputString);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEvaluateAbnormal_10() {
        String inputString = "())";
        evaluator.evaluate(inputString);
    }
}