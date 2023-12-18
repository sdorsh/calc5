import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;


public class Calculator {
    static int intOne;
    static int intTwo;
    static int result;
    static String inputSKlava;
    static String[] inputSplit;
    static String resultSTR;
    static String stringOne;
    static String stringTwo;
    static String regex = "[^+*/-]";
    static String symbol;
    static String symbolOne = "/";
    static String symbolTwo = "*";
    static String symbolThree = "+";
    static String symbolFour = "-";
    static Pattern pattern = Pattern.compile(regex);




    public static void main(String[] args) {
        System.out.println("Введи ЧЕРЕЗ ПРОБЕЛ целое число от 1 до 10 или римские цифры от I до X и \n" + "арифметическую операцию");
        Scanner klava = new Scanner(System.in);
        while (true) {
            inputSKlava = klava.nextLine();
            Calculator.calc(inputSKlava);
        }
    }

    public static String calc(String input) {

        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] oneToHundredSTR = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int[] oneToHundredINT = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100};


        inputSplit = input.split(" ");

        if (inputSplit.length == 1 || inputSplit.length == 2) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Вычисление прекращено т.к. строка не является математической операцией или ввод чисел произведён НЕ через пробел");
                System.exit(0);
            }
        } else if (inputSplit.length > 3) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Вычисление прекращено т.к. введено более двух чисел или знаков");/* формат не
                соответствует математической операции " +
                "- два операнда и один оператор (+,-,/,*).");*/
                System.exit(0);
            }
        }

        boolean one = isInteger(inputSplit[0]);
        boolean two = isInteger(inputSplit[2]);
        if ((one == true && two == false) || (one == false && two == true)) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Ведены некорректные данные (Используются одновременно разные системы счисления или введены не целые числа). Повторите ввод");
                System.exit(0);

            }
        }

        if (one == true && two == true) {
            intOne = parseInt(inputSplit[0]);
            symbol = inputSplit[1];
            intTwo = parseInt(inputSplit[2]);

            if (intOne > 10 || intTwo > 10) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Вводите только числа от 1 до 10.");
                    System.exit(0);
                }

            } else {
                switch (symbol) {
                    case "+":
                        result = intOne + intTwo;
                        resultSTR = String.valueOf(result);
                        System.out.println(resultSTR);
                        break;
                    case "-":
                        result = intOne - intTwo;
                        resultSTR = String.valueOf(result);
                        System.out.println(resultSTR);
                        break;
                    case "*":
                        result = intOne * intTwo;
                        resultSTR = String.valueOf(result);
                        System.out.println(resultSTR);
                        break;
                    case "/":
                        result = intOne / intTwo;
                        resultSTR = String.valueOf(result);
                        System.out.println(resultSTR);
                        break;

                    default:
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            System.out.println("Введён неверный знак - " + symbol + ". Повторите ввод.");
                            System.exit(0);

                        }
                }
            }
        }

        if (one == false && two == false) {
            switch (inputSplit[0]) {
                case "I":
                    intOne = 1;
                    break;
                case "II":
                    intOne = 2;
                    break;
                case "III":
                    intOne = 3;
                    break;
                case "IV":
                    intOne = 4;
                    break;
                case "V":
                    intOne = 5;
                    break;
                case "VI":
                    intOne = 6;
                    break;
                case "VII":
                    intOne = 7;
                    break;
                case "VIII":
                    intOne = 8;
                    break;
                case "IX":
                    intOne = 9;
                    break;
                case "X":
                    intOne = 10;
                    break;
                case "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C":
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Вводите только числа от I до X.");
                    }
                    System.exit(0);
                    break;
            }
            switch (inputSplit[2]) {
                case "I":
                    intTwo = 1;
                    break;
                case "II":
                    intTwo = 2;
                    break;
                case "III":
                    intTwo = 3;
                    break;
                case "IV":
                    intTwo = 4;
                    break;
                case "V":
                    intTwo = 5;
                    break;
                case "VI":
                    intTwo = 6;
                    break;
                case "VII":
                    intTwo = 7;
                    break;
                case "VIII":
                    intTwo = 8;
                    break;
                case "IX":
                    intTwo = 9;
                    break;
                case "X":
                    intTwo = 10;
                    break;
                case "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C":
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        System.out.println("Вводите только числа от I до X.");
                    }
                    System.exit(0);
                    break;
            }
            symbol = inputSplit[1];
            switch (symbol) {
                case "+":
                    result = intOne + intTwo;
                    break;
                case "-":
                    result = intOne - intTwo;
                    break;
                case "*":
                    result = intOne * intTwo;
                    break;
                case "/":
                    result = intOne / intTwo;
                    break;

            }
            for (int i = 0; i < roman.length; i++) {
                if (roman[i].compareTo(inputSplit[0]) == 0) {
                    stringOne = roman[i];
                    break;
                } else {
                    stringOne = " ";
                }
            }
            for (int i = 0; i < roman.length; i++) {
                if (roman[i].compareTo(inputSplit[2]) == 0) {
                    stringTwo = roman[i];
                    break;
                } else {
                    stringTwo = " ";
                }
            }

            if ((stringOne.compareTo(inputSplit[0]) == 0 && stringTwo.compareTo(inputSplit[2]) == 0)) {
                for (int x = 0; x < oneToHundredINT.length; x++) {
                    if ((result == oneToHundredINT[x])) {
                        resultSTR = oneToHundredSTR[x];
                        break;
                    }
                }
            }

            if (((result > 0) && symbol.equals("/")) || ((result > 0) && symbol.equals("*")) || ((result > 0) && symbol.equals("+")) || ((result > 0) && symbol.equals("-"))) {
                System.out.println(resultSTR);
            } else if (((result == 0) && !symbol.equals(symbolOne)) || ((result == 0) && !symbol.equals(symbolTwo)) || ((result == 0) && !symbol.equals(symbolThree))
                    || ((result == 0) && !symbol.equals(symbolFour))) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Результат не отобразится т.к. в Римской системе нет отрицательных чисел/ноля ИЛИ Вы внесли что-то совсем не относящееся к вычислениям. Повторите ввод");
                    System.exit(0);
                }
            } else if (((result < 0) && symbol.equals(symbolOne)) || ((result < 0) && symbol.equals(symbolTwo)) || ((result < 0) && symbol.equals(symbolThree))
                    || ((result < 0) && symbol.equals(symbolFour))) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("В Римской системе нет отрицательных чисел. Повторите ввод");
                    System.exit(0);
                }


            }
        }
        return resultSTR;
    }

    public static boolean isInteger(String str) {
        try {
            parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}







