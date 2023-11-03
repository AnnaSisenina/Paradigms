package Lecture_2.task1;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        int[] li = {1, 3, 2, 3, 4, 2, 5, 3};
        int n = 3;
        int count = 0;
        int length = li.length;
        for (int i = 0; i < length; i++) {
            if (li[i] == n)
                count++;
        }
        System.out.println(count);
    }

}
