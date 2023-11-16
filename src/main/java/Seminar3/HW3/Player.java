package Seminar3.HW3;

public abstract class Player {

    String name;
    boolean turn;
    public int valuesColumn = 0;
    public int valuesString = 0;
    public  int valuesDiagonal = 0;
    public  int valuesSecondDiagonal =0;

    public Player(String name) {
        this.name = name;
    }

    public abstract void countValuesColumn();
    public abstract void countValuesString();
    public abstract void countValuesDiagonal();
    public abstract void countValuesSecondDiagonal();

    public abstract void resetCountColumns();
    public abstract void resetCountString();
    public abstract boolean checkColumnsStrings();
    public abstract boolean checkDiagonals();
    public abstract void resetCountDiagonal();
    public abstract void resetCountSecondDiagonal();


}
