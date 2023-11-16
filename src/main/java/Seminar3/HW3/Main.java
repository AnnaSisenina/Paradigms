package Seminar3.HW3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        startGame (sc);
    }

    private static void startGame(Scanner sc) {
        System.out.println("������� ��� ������ 1: ");
        String firstName = sc.nextLine();
        PlayerOne one = new PlayerOne(firstName);
        System.out.println("������� ��� ������ 2: ");
        String secondName = sc.nextLine();
        PlayerTwo two = new PlayerTwo(secondName);
        PlayField playingField = new PlayField(new int[3][3]);

        int countTurn = 0; //������� �����
        while(countTurn < 5) { // ������ �������� ������ � ������ ����, ������� �� ����� ����� ������ ���������� ����
            playingField.printPlayingField();
            makeTurn(one, two, playingField.playingField, sc); // ���� ����� ������ ���
            countTurn++;
        }
        while (countTurn < 9 & !check(playingField.playingField, one, two)) { // ��������� ���� �� ������ � 5��� �� 9�� ���
            playingField.printPlayingField();
            makeTurn(one, two, playingField.playingField, sc);
            countTurn++;
        }
        playingField.printPlayingField();
        if (countTurn == 9 & !check(playingField.playingField, one, two)) System.out.println("���� ��������, �����");
        else if (check(playingField.playingField, one, two)) {
           if (one.turn) System.out.println(one.name + " �������!");
           else if (two.turn) System.out.println(two.name + " �������!");
        }
    }

    private static void makeTurn(Player one, Player two, int [][] playingField, Scanner sc) {
        one.turn = !one.turn;
        two.turn = !two.turn;
        boolean checkCell = false;
        int string = -1;
        int column = -1;
        while (!checkCell) {
            System.out.println("������� ����� ������ ������ (�� 0 �� 2)"); //����� ������ ��� � ��������� �����
            string = sc.nextInt();
            System.out.println("������� ����� ������� ������ (�� 0 �� 2)");
            column = sc.nextInt();
            checkCell = true; // �������� ������:
            if (string < 0 || string >2 || column < 0 || column >2) {//  ���������� �� ����� �����
                System.err.println("����� ������ ���");
                checkCell = false;
                continue;
            }
            if (playingField[string][column] != 0) { // � ������ �� ��� ������
                System.err.println("��� ������ ��� ������");
                checkCell = false;
            }
        }
        if (one.turn) playingField[string][column] = 1; // ���� ��� ������� ������, �������� 1
        else if (two.turn) playingField[string][column] = 2; // ���� ��� ������� ������, �������� 2
    }

    private static boolean check(int [][] playingField, PlayerOne one, PlayerTwo two){ // �������� �� ������
        one.resetCountDiagonal(); //������� �������� ������� ������ �� ������� �����������, ������������ ����� ���������
        one.resetCountSecondDiagonal();
        two.resetCountDiagonal();
        two.resetCountSecondDiagonal();
        for (int i = 0; i < 3; i++) {
            one.resetCountColumns();
            one.resetCountString();
            two.resetCountColumns();
            two.resetCountString();
            for (int j = 0; j < 3 ; j++) {
                if (playingField[i][j] == 1) one.countValuesColumn();
                else if (playingField[i][j] == 2) two.countValuesColumn();
                if (playingField[j][i] == 1) one.countValuesString();
                else if (playingField[j][i] == 2) two.countValuesString();
                }
            if (one.checkColumnsStrings() || two.checkColumnsStrings()) { //�������� ����� � ������� ������� ������
                return true;
            }
            if (playingField[i][i] == 1) one.countValuesDiagonal(); //�������� ����������  ������� ������
            else if (playingField[i][i] == 2) two.countValuesDiagonal();
            if (playingField[i][2-i] == 1) one.countValuesSecondDiagonal();
            else if (playingField[i][2-i] == 2) two.countValuesSecondDiagonal();
        }
        return one.checkDiagonals() || two.checkDiagonals();
    }
}