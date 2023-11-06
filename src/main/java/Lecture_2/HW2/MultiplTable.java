package Lecture_2.HW2;

import java.util.Scanner;

// Выбрала процедурную и структурную парадигму, т.к. мне кажется, что там удобнее читать код

public class MultiplTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int n = sc.nextInt();
        printMultiplTable(n);
    }

    /**
     *
     * @param n - число, заданное пользователем, до которого нужно вывести тамблицу умножения
     * @apiNote - выводит на экран таблицу умножения до заданного числа
     */
    private static void printMultiplTable(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
            System.out.println();
        }
    }
}
