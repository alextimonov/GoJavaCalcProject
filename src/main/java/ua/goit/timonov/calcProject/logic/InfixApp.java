package ua.goit.timonov.calcProject.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.LogManager;

/**
 * Created by Alex on 14.05.2016.
 */
public class InfixApp {
     public static void main(String[] args) throws IOException
        {
            String input, output;
            while(true)
            {
                System.out.print("Enter infix: ");
                System.out.flush();
                input = getString(); // Чтение строки с клавиатуры
                if( input.equals("") ) // Выход, если нажата клавиша [Enter]
                    break;
// Создание объекта-преобразователя
                InfixToPostfix transformer = new InfixToPostfix(input);
//                output = transformer.transform(); // Преобразование
//                System.out.println("Postfix is " + output + '\n');
            }
        }
//--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
