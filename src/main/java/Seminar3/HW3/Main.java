package Seminar3.HW3;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        startGame (sc);
    }

    private static void startGame(Scanner sc) {
        System.out.println("¬ведите им€ »грока 1: ");
        String firstName = sc.nextLine();
        PlayerOne one = new PlayerOne(firstName);
        System.out.println("¬ведите им€ »грока 2: ");
        String secondName = sc.nextLine();
        PlayerTwo two = new PlayerTwo(secondName);
        PlayField playingField = new PlayField(new int[3][3]);

        int countTurn = 0; //счетчик ходов
        while(countTurn < 5) { // победа возможна только с п€того хода, поэтому до этого можно только записывать ходы
            playingField.printPlayingField();
            makeTurn(one, two, playingField.playingField, sc); // один игрок делает ход
            countTurn++;
        }
        while (countTurn < 9 & !check(playingField.playingField, one, two)) { // провер€ем есть ли победа с 5ого по 9ый ход
            playingField.printPlayingField();
            makeTurn(one, two, playingField.playingField, sc);
            countTurn++;
        }
        playingField.printPlayingField();
        if (countTurn == 9 & !check(playingField.playingField, one, two)) System.out.println("»гра окончена, ничь€");
        else if (check(playingField.playingField, one, two)) {
           if (one.turn) System.out.println(one.name + " победил!");
           else if (two.turn) System.out.println(two.name + " победил!");
        }
    }

    private static void makeTurn(Player one, Player two, int [][] playingField, Scanner sc) {
        one.turn = !one.turn;
        two.turn = !two.turn;
        boolean checkCell = false;
        int string = -1;
        int column = -1;
        while (!checkCell) {
            System.out.println("¬ведите номер строки €чейки (от 0 до 2)"); //игрок делает ход и указывает €чйку
            string = sc.nextInt();
            System.out.println("¬ведите номер столбца €чейки (от 0 до 2)");
            column = sc.nextInt();
            checkCell = true; // ѕроверка €чейки:
            if (string < 0 || string >2 || column < 0 || column >2) {//  существует ли такой адрес
                System.err.println("“акой €чейки нет");
                checkCell = false;
                continue;
            }
            if (playingField[string][column] != 0) { // и зан€та ли эта €чейка
                System.err.println("Ёта €чейка уже зан€та");
                checkCell = false;
            }
        }
        if (one.turn) playingField[string][column] = 1; // если ход первого игрока, ставитс€ 1
        else if (two.turn) playingField[string][column] = 2; // если ход второго игрока, ставитс€ 2
    }

    private static boolean check(int [][] playingField, PlayerOne one, PlayerTwo two){ // ѕроверка на победу
        one.resetCountDiagonal(); //счетчик символов каждого игрока по каждому направлению, сбрасываетс€ перед проверкой
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
            if (one.checkColumnsStrings() || two.checkColumnsStrings()) { //проверка строк и колонок каждого игрока
                return true;
            }
            if (playingField[i][i] == 1) one.countValuesDiagonal(); //проверка диагоналей  каждого игрока
            else if (playingField[i][i] == 2) two.countValuesDiagonal();
            if (playingField[i][2-i] == 1) one.countValuesSecondDiagonal();
            else if (playingField[i][2-i] == 2) two.countValuesSecondDiagonal();
        }
        return one.checkDiagonals() || two.checkDiagonals();
    }
}