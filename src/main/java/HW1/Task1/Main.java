package HW1.Task1;

import java.util.Arrays;

//Дан список целых чисел numbers. Необходимо написать в императивном стиле процедуру для сортировки чисел в списке в порядке убывания.
//Сортировка пузырьком
public class Main {
    public static void main(String[] args) {
        int [] array = new int [10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int)(Math.random()*10);
        }
        System.out.println(Arrays.toString(array));
        int length = array.length;

        boolean check = false;
        while (!check) {
            check = true;
            for (int i = 0; i < length - 1; i++) {
                if (array[i + 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    check = false;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
