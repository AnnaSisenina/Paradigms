package Seminar3.HW3;

public class PlayField {
    int [][] playingField;

    public PlayField(int[][] playingField) {
        this.playingField = playingField;
    }

    public void printPlayingField(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(playingField[i][j] + " | ");
            }
            System.out.println();
        }
    }




}
