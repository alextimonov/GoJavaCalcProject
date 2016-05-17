package ua.goit.timonov.calcProject.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alex on 15.05.2016.
 */
@Deprecated
public class PostfixApp {

    public static void main(String[] args) throws IOException
    {
        String input;
        int output;
        while(true)
        {
            System.out.print("Enter postfix: ");
            System.out.flush();
            input = getString(); // Ввод строки с клавиатуры
            if( input.equals("") ) // Завершение, если нажата клавиша [Enter]
            break;

//            ParsePost aParser = new ParsePost(input);
//            output = aParser.doParse(); // Обработка выражения
//            System.out.println("Evaluates to " + output);
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
