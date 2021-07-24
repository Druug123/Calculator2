import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws CalculatorException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные");
       ExpressionManager x = new ExpressionManager(scanner.nextLine());
       x.calculate(x.whichNumbers(), x.analyzeForOperation());

    }
}


