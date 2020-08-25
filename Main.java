package lesson2.exceptions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to see? \n");

        System.out.println("Press 1, if you want to see Array without any problems");
        System.out.println("Press 2, if you want to see Array with Size problem and thrown Exception");
        System.out.println("Press 3, if you want to see Array with Number Format problem and thrown Exception");

        int numberForChoosing = scanner.nextInt();

        if(numberForChoosing == 1) {
            checkingArray(successArray(4, 4));
        }
        else if(numberForChoosing == 2) {
            checkingArray(unSuccessArrayWithSize(5, 4));
        }
        else {
            checkingArray(unSuccessArrayWithElements(3, 3));
        }

    }

    public static void checkingArray(String[][] array) {

        if(array.length > 4 || array[0].length > 4) {
            throw new ArrayIndexOutOfBoundsException("MyArraySizeException");
        }

        int sum = 0;

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                try {
                    int n = Integer.parseInt(array[i][j]);
                    sum += n;
                }
                catch (NumberFormatException n) {
                    throw new NumberFormatException("MyArrayDataException in " + i + " row and " + j + " column!");
                }
            }
        }

        System.out.println("Sum of Arrays elements = " + sum);
    }

    public static String[][] successArray(int n, int m) {

        String[][] arrayOfStrings = new String[n][m];

        for(int i = 0; i < arrayOfStrings.length; i++) {
            for(int j = 0; j < arrayOfStrings[0].length; j++) {
                arrayOfStrings[i][j] = "5";
            }
        }

        // Тут нет никаких ошибок
        return arrayOfStrings;
    }

    public static String[][] unSuccessArrayWithSize(int n, int m) {

        // Тут ошибка(n или m не может быть больше чем 4) и будет выброшено исключение(ArrayIndexOutOfBoundsException)
        String[][] arrayOfStrings = new String[n][m];

        for(int i = 0; i < arrayOfStrings.length; i++) {
            for(int j = 0; j < arrayOfStrings[0].length; j++) {
                arrayOfStrings[i][j] = "12";
            }
        }

        return arrayOfStrings;
    }

    public static String[][] unSuccessArrayWithElements(int n, int m) {

        String[][] arrayOfStrings = new String[n][m];

        for(int i = 0; i < arrayOfStrings.length; i++) {
            for(int j = 0; j < arrayOfStrings[0].length; j++) {
                arrayOfStrings[i][j] = "5";
            }
        }

        // Тут ошибка и в последующем, будет выброшено исключение(NumberFormatException)
        arrayOfStrings[2][2] = "aaa";

        return arrayOfStrings;
    }

}
