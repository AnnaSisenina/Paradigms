package Lecture_2.HW2;

import java.util.Scanner;

// ������� ����������� � ����������� ���������, �.�. ��� �������, ��� ��� ������� ������ ���

public class MultiplTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������� �����: ");
        int n = sc.nextInt();
        printMultiplTable(n);
    }

    /**
     *
     * @param n - �����, �������� �������������, �� �������� ����� ������� �������� ���������
     * @apiNote - ������� �� ����� ������� ��������� �� ��������� �����
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
