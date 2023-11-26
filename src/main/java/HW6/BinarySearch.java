package HW6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BinarySearch {
    public static void main(String[] args) {
        int [] array = new int [20];
        for (int i = 0; i < 20; i++) {
            array[i] = i;
        }
        for (Integer integer :array) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println("Введите число ");
        Scanner sc = new Scanner(System.in);
        int numberToFind = sc.nextInt();
        int index = searchBinary(array, numberToFind);
        System.out.println("Искомое число находится под индексом " + index);
    }

    private static int searchBinary(int[] array, int numberToFind) {
        int rightBorder = array.length - 1;
        int leftBorder = 0;
        while (leftBorder <= rightBorder) {
            int middle = (rightBorder + leftBorder) / 2;
            int checkNumber = array[middle];
            if (checkNumber == numberToFind) {
                return middle;
            } else if (checkNumber < numberToFind) {
                leftBorder = middle + 1;
            } else {
                rightBorder = middle - 1;
            }
        }
        return -1;
    }

}
