package Lecture_2.Seminar2.Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¬ведите число: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println(DecimalToString(number));
    }
    private static String DecimalToString(int number) {
        StringBuilder binary = new StringBuilder();
        while (number != 0) {
            binary.append(number % 2);
            number = number / 2;
        }
        binary.reverse();
        return binary.toString();
    }
}
