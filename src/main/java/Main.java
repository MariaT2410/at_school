import model.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String[] params = readParams();
        // считать из консоли данные, затем вернуть их в виде массива строк( сделано)
        Scanner in = new Scanner(System.in);
        String number1 = in.nextLine();
        String mathOperation = in.nextLine();
        String number2 = in.nextLine();
        //System.out.println("Результат:"+(Arrays.toString(new String[]{mathOperation, number1, number2})));

        System.out.println(Calculator.execute(new String[]{ number1, mathOperation, number2}));
    }

}