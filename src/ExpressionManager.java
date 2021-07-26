public class ExpressionManager {
    private String expression;
    private int a;
    private int b;

    public ExpressionManager(String expression) {
        this.expression = expression;
    }

    public Operation analyzeForOperation() throws CalculatorException {
        if (expression.contains("+")) {
            return Operation.PLUS;
        }
        if (expression.contains("-")) {
            return Operation.DEDUCTION;
        }
        if (expression.contains("*")) {
            return Operation.MULTIPLICATION;
        }
        if (expression.contains("/")) {
            return Operation.DIVISION;
        }
        throw new CalculatorException("Вы ввели неправильные данные");
    }


    public ArabianOrRome whichNumbers() throws CalculatorException {
        String[] arrayExpression = expression.replaceAll("\\s", "").split("[-+*/]");
        String[] romeNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean aIsFill = false;
        boolean bIsFill = false;
        if (!(arrayExpression.length == 2)) {
            throw new CalculatorException("Вы ввели неправильные данные");
        }
        for (int i = 0; i < romeNumbers.length; i++) {
            if (arrayExpression[0].equals(romeNumbers[i])) {
                a = i + 1;
                aIsFill = true;
            }
        }
        for (int i = 0; i < romeNumbers.length; i++) {
            if (arrayExpression[1].equals(romeNumbers[i])) {
                b = i + 1;
                bIsFill = true;
            }
        }
        if (aIsFill & bIsFill) {
            return ArabianOrRome.ROME;
        } else {
            try {
                a = Integer.parseInt(arrayExpression[0]);
                b = Integer.parseInt(arrayExpression[1]);
                if (a > 10 || b > 10 || a < 0 || b < 0) {
                    throw new CalculatorException("Вы ввели неправильные данные");
                }
            } catch (NumberFormatException e) {
                throw new CalculatorException("Вы ввели неправильные данные");
            }
            return ArabianOrRome.ARABIAN;
        }
    }

    public static String convertToRome(int param){
        int [] valueList = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] charList = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i<valueList.length;i++){
            while (param>=valueList[i]){
                param -= valueList[i];
                temp.append(charList[i]);
            }
        }
        return temp.toString();
    }

    public void calculate(ArabianOrRome kindOfNumber, Operation theOperation) throws CalculatorException {
        int result;
        if (kindOfNumber == ArabianOrRome.ARABIAN) {
            switch (theOperation) {
                case PLUS: {
                    result = a + b;
                    System.out.println(result);
                    break;
                }
                case DEDUCTION: {
                    result = a - b;
                    System.out.println(result);
                    break;
                }
                case MULTIPLICATION: {
                    result = a * b;
                    System.out.println(result);
                    break;
                }
                case DIVISION: {
                if (!(b==0)) {result = a / b;
                    System.out.println(result);
                    break;
                    } else {throw new CalculatorException("Вы ввели неправильные данные");
                    }
                }

            }
        } else {
            switch (theOperation) {
                case PLUS: {
                    result = a + b;
                    System.out.println(convertToRome(result));
                    break;
                }
                case DEDUCTION: {
                    result = a - b;
                    System.out.println(convertToRome(result));
                    break;
                }
                case MULTIPLICATION: {
                    result = a * b;
                    System.out.println(convertToRome(result));
                    break;
                }
                case DIVISION: {
                    result = a / b;
                    System.out.println(convertToRome(result));
                    break;
                }

            }

        }
    }
}