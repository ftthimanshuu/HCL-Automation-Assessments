// Write a menu driven program to perform operations on a one dimensional array.

package Task2;

import java.util.Scanner;
import java.util.Arrays;

public class Array {

    static void linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    static int[] insertion(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = element;
        return newArr;
    }

    static int[] deletion(int[] arr, int element) {
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Element not found in the array");
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        for (int i = index + 1; i < arr.length; i++) {
            newArr[i - 1] = arr[i];
        }

        System.out.println("Element deleted successfully");
        return newArr;
    }

    static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    static int maxValue(int[] arr) {
        int max = arr[0];

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    static int even(int[] arr) {
        int countEven = 0;

        for (int i : arr) {
            if (i % 2 == 0) {
                countEven++;
            }
        }

        return countEven;
    }

    static int odd(int[] arr) {
        int countOdd = 0;

        for (int i : arr) {
            if (i % 2 != 0) {
                countOdd++;
            }
        }

        return countOdd;
    }

    static int[] insertionSort(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < sorted.length; i++) {
            int key = sorted[i];
            int j = i - 1;

            while (j >= 0 && sorted[j] > key) {
                sorted[j + 1] = sorted[j];
                j--;
            }

            sorted[j + 1] = key;
        }

        return sorted;
    }

    static void display(int[] arr) {
        System.out.println("Array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        while (n <= 0) {
            System.out.print("Enter a positive number of elements: ");
            n = sc.nextInt();
        }

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\\n1. Insertion");
            System.out.println("2. Deletion");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even and Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display Array");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert: ");
                    arr = insertion(arr, sc.nextInt());
                    display(arr);
                    break;

                case 2:
                    System.out.print("Enter element to delete: ");
                    arr = deletion(arr, sc.nextInt());
                    display(arr);
                    break;

                case 3:
                    System.out.print("Enter element to search: ");
                    linearSearch(arr, sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    int target = sc.nextInt();
                    int[] sortedForSearch = Arrays.copyOf(arr, arr.length);
                    Arrays.sort(sortedForSearch);
                    int index = binarySearch(sortedForSearch, target);

                    if (index == -1) {
                        System.out.println("Element not found");
                    } else {
                        System.out.println("Element found at index " + index
                                + " in the sorted array " + Arrays.toString(sortedForSearch));
                    }
                    break;

                case 5:
                    System.out.println("Maximum value: " + maxValue(arr));
                    break;

                case 6:
                    System.out.println("Even elements: " + even(arr));
                    System.out.println("Odd elements: " + odd(arr));
                    break;

                case 7:
                    arr = insertionSort(arr);
                    System.out.println("Array sorted using insertion sort.");
                    display(arr);
                    break;

                case 8:
                    display(arr);
                    break;

                case 9:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 9);

        sc.close();
    }
}
