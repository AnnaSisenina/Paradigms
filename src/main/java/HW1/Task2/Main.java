package HW1.Task2;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int [] array = new int [10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int)(Math.random()*10);
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        ArrayInverter.invert(array);
        System.out.println(Arrays.toString(array));
    }
    public static class ArrayInverter {
        public static void invert(int[] array) {
            for (int i = 0; i < array.length / 2; i++) {
                int tmp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] =  tmp;
            }
        }
    }
}
