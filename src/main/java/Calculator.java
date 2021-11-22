import com.sun.org.apache.xpath.internal.operations.Div;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Калькулятор складывает, вычитает, умножает и делит целые числа от -2147483648 до 2147483647
 *
 * сложение метод Summing
 * вычитание - метод Subtraction
 * умножение - метод Multiplication
 * деление - метод Division
  */

public class Calculator {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите операцию (+,-,*,/)");
        String operation = reader.readLine();

        System.out.println("Введите первое число");

        String firstInput = reader.readLine();
        Integer firstInteger = Integer.parseInt(firstInput);

        System.out.println("Введите второе число");

        String secondInput = reader.readLine();
        Integer secondInteger = Integer.parseInt(secondInput);

        switch (operation) {
            case "+":
                System.out.println(Summing(firstInteger, secondInteger));break;
            case "-":
                System.out.println(Subtraction(firstInteger, secondInteger));break;
            case "*":
                System.out.println(Multiplication(firstInteger, secondInteger));break;
            case "/":
                System.out.println(Division(firstInteger, secondInteger));break;
        }


    }

    public static Double Summing(Integer a, Integer b) {
        return Double.valueOf(a*1.0+b);
    }

    public static Double Subtraction(Integer a, Integer b) {
        return Double.valueOf((a*1.0)-b);
    }

    public static Double Multiplication(Integer a, Integer b) {
        return Double.valueOf((a*1.0)*b);
    }

    public static Double Division(Integer a, Integer b) {
        return Double.valueOf((a*1.0)/b);
    }
}
