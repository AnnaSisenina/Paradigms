package Seminar3.HW3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player one = new Player("one", false);
        Player two = new Player("two", true);
        int [][] playingField = new int[3][3];
        int countTurn = 0;
        boolean checkWin = false;
        Scanner sc = new Scanner(System.in);
        startGame (one, two, playingField, countTurn, sc, checkWin);

    }

    private static void startGame(Player one, Player two, int[][] playingField, int countTurn, Scanner sc, boolean checkWin) {
        while (!checkWin) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(playingField[i][j] + " | ");
                }
                System.out.println();
            }
            makeTurn(one, two, playingField, sc);
            countTurn++;
            if (countTurn >= 5) {
                if (check(playingField)) {
                    checkWin = true;
                    System.out.println("Игра окончена");
                }
            }
            if (countTurn == 9) {
                checkWin = true;
                System.out.println("Игра окончена, ничья");
            }
        }
    }

    private static void makeTurn(Player one, Player two, int [][] playingField, Scanner sc) {
        one.turn = !one.turn;
        two.turn = !two.turn;
        if (one.turn) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            playingField[i][j] = 1;
        }
        else if (two.turn) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            playingField[i][j] = 2;
        }
    }

    private static boolean check(int [][] playingField){
        int countColumn1 = 0;
        int countColumn2 = 0;
        int countString1 = 0;
        int countString2 = 0;
        int countDiagonal1 = 0;
        int countDiagonal2 = 0;
        int countSecondDiagonal1 = 0;
        int countSecondDiagonal2 = 0;
        for (int i = 0; i < 3; i++) {
            countColumn1 = 0;
            countColumn2 = 0;
            countString1 = 0;
            countString2 = 0;
            for (int j = 0; j < 3 ; j++) {
                if (playingField[i][j] == 1) countColumn1++;
                else if (playingField[i][j] == 2) countColumn2++;
                if (playingField[j][i] == 1) countString1++;
                else if (playingField[j][i] == 2) countString2++;
                }
            if (playingField[i][i] == 1) countDiagonal1++;
            else if (playingField[i][i] == 2) countDiagonal2++;
            if (playingField[i][2-i] == 1) countSecondDiagonal1++;
            else if (playingField[i][2-i] == 2) countSecondDiagonal2++;
            if (countColumn1 == 3 || countColumn2 == 3 || countString1 == 3 || countString2 == 3) {
                return true;
            }
        }
        return countDiagonal1 == 3 || countDiagonal2 == 3 || countSecondDiagonal1 == 3 || countSecondDiagonal2 == 3;
    }
}