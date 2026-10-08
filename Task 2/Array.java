// Write a menu driven program in Java to perform insertion, deletion, linear search, binary search, to find maximum value, to count even/ odd and to perform insertion sort operation in one dimensional array.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        boolean elementPresent = false;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                elementPresent = true;
                continue;
            } else if (elementPresent) {
                newArr[i - 1] = arr[i];
            } else {
                newArr[i] = arr[i];
            }
        }

        if (!elementPresent) {
            System.out.println("Element not found in the array");
            return arr;
        }  

        System.out.println("Element deleted successfully");
        return newArr;
    }

    static int maxValue (int[] arr) {
        int max =Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    static int even (int[] arr) {
        int countEven = 0;
        for(int i : arr) {
            if (i % 2 == 0) {
                countEven++;
            }
        }

        return countEven;
    }


}