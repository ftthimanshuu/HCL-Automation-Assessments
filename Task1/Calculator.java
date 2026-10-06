// A class sixth student required to solve basic mathematics problems. For this he/ she needs to perform operations such as addition, subtraction, multiplication, division, remainder, square, cube, and absolute. Write a program using methods to perform these basic operations.

import java.util.Scanner;

public class Calculator {

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        return a / b;
    }

    public static double square(double a) {
        return a * a;
    }

    public static double cube(double a) {
        return a * a * a;
    }

    public static double remainder(double a, double b) {
        return a % b;
    }

    public static double absolute(double a) {
        return Math.abs(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a;
        double b;
        double result = 0;
        char ch;

        do {
            System.out.println("\n1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Square");
            System.out.println("6. Cube");
            System.out.println("7. Remainder");
            System.out.println("8. Absolute");
            System.out.println("9. Exit");

            ch = sc.next().charAt(0);

            if (ch == '9') {
                break;
            }

            if (ch == '5' || ch == '6' || ch == '8') {

                System.out.println("Enter number:");
                a = sc.nextDouble();

                switch (ch) {
                    case '5':
                        result = square(a);
                        break;

                    case '6':
                        result = cube(a);
                        break;

                    case '8':
                        result = Math.abs(a);
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } else {

                System.out.println("Enter first number:");
                a = sc.nextDouble();

                System.out.println("Enter second number:");
                b = sc.nextDouble();

                switch (ch) {
                    case '1':
                        result = sum(a, b);
                        break;

                    case '2':
                        result = subtraction(a, b);
                        break;

                    case '3':
                        result = multiplication(a, b);
                        break;

                    case '4':
                        if (b == 0) {
                            System.out.println("Cannot divide by zero");
                            continue;
                        }
                        result = division(a, b);
                        break;

                    case '7':
                        if (b == 0) {
                            System.out.println("Cannot find remainder with zero");
                            continue;
                        }
                        result = remainder(a, b);
                        break;

                    default:
                        System.out.println("Invalid choice");
                        continue;
                }
            }

            System.out.println("The result is = " + result);

        } while (true);

        sc.close();

    }

}
