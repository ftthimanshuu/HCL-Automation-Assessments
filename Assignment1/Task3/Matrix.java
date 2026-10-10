// Write a program to perform operations on matrices.

package Task3;

import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\\n1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Transpose");
            System.out.println("5. Check Square Matrix");
            System.out.println("6. Check Diagonal Matrix");
            System.out.println("7. Check Identity Matrix");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();

            if (ch == 8) {
                break;
            }

            if (ch < 1 || ch > 8) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            if (ch >= 1 && ch <= 3) {
                int[][] matrix1 = readMatrix(sc, "first");
                int[][] matrix2 = readMatrix(sc, "second");

                try {
                    int[][] result;

                    switch (ch) {
                        case 1:
                            result = addition(matrix1, matrix2);
                            System.out.println("Result of addition:");
                            printMatrix(result);
                            break;
                        case 2:
                            result = subtraction(matrix1, matrix2);
                            System.out.println("Result of subtraction:");
                            printMatrix(result);
                            break;
                        case 3:
                            result = multiplication(matrix1, matrix2);
                            System.out.println("Result of multiplication:");
                            printMatrix(result);
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else {
                int[][] matrix = readMatrix(sc, "");

                switch (ch) {
                    case 4:
                        System.out.println("Result of transpose:");
                        printMatrix(transpose(matrix));
                        break;
                    case 5:
                        System.out.println(isSquareMatrix(matrix)
                                ? "The matrix is a square matrix."
                                : "The matrix is not a square matrix.");
                        break;
                    case 6:
                        System.out.println(isDiagonalMatrix(matrix)
                                ? "The matrix is a diagonal matrix."
                                : "The matrix is not a diagonal matrix.");
                        break;
                    case 7:
                        System.out.println(isIdentityMatrix(matrix)
                                ? "The matrix is an identity matrix."
                                : "The matrix is not an identity matrix.");
                        break;
                }
            }
        } while (true);

        sc.close();
    }

    public static int[][] readMatrix(Scanner sc, String label) {
        if (!label.isEmpty()) {
            System.out.println("Enter the number of rows of " + label + " matrix:");
        } else {
            System.out.println("Enter the number of rows of matrix:");
        }
        int rows = sc.nextInt();

        if (!label.isEmpty()) {
            System.out.println("Enter the number of columns of " + label + " matrix:");
        } else {
            System.out.println("Enter the number of columns of matrix:");
        }
        int cols = sc.nextInt();

        while (rows <= 0 || cols <= 0) {
            System.out.println("Rows and columns must be positive. Enter them again:");
            rows = sc.nextInt();
            cols = sc.nextInt();
        }

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] addition(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length
                || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] subtraction(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length
                || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public static int[][] multiplication(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException(
                    "Columns of first matrix must equal rows of second matrix.");
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static boolean isSquareMatrix(int[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    public static boolean isDiagonalMatrix(int[][] matrix) {
        if (!isSquareMatrix(matrix)) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isIdentityMatrix(int[][] matrix) {
        if (!isSquareMatrix(matrix)) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false;
                }
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
