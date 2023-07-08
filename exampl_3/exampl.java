/*Реализовать простой калькулятор*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Scanner;

public class exampl {
    static int scanNumber() {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        return number;
        
    }

    // метод получения числа операции
    static String scanOperations() {
        Scanner scan = new Scanner(System.in);
        String operations = scan.nextLine();
        return operations;

    }

    // метод получения результата
    static int getResult(String opr, int num1, int num2) {
        int result = 0;
        switch (opr) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;

            default:
                System.out.println("Введите оператор: -, +, *, /");
                break;
        }
        return result;

    }

    public static void main(String[] args) throws IOException {

        try {
            File file = new File ("Log.txt");
            FileWriter fileWriter= new FileWriter(file, true);   
            System.out.println("Введите первое число: ");
            int num1 = scanNumber();

            System.out.println("Введите оператор: -, +, *, /");
            String operations = scanOperations();
            System.out.println("Введите второе число: ");
            int num2 = scanNumber();
            int result = getResult(operations, num1, num2);
            System.out.printf("%d %s %d = %d", num1, operations, num2, result);  
            fileWriter.write("\n"+num1 + operations + num2 + "=" + result);
            fileWriter.close();
            } catch (Exception e) {
            System.out.println("Исключение при работе с файлом");
        }
    

    }

}