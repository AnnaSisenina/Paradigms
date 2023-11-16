package Seminar3.HW3;

public class PlayerOne extends Player {

    public PlayerOne(String name) {
        super(name);
        this.turn = false;
    }

    @Override
    public void countValuesColumn() {
        this.valuesColumn++;
    }

    @Override
    public void countValuesString() {
        this.valuesString++;
    }

    @Override
    public void countValuesDiagonal() {
        this.valuesDiagonal++;
    }

    @Override
    public void countValuesSecondDiagonal() {
        this.valuesSecondDiagonal++;
    }

    @Override
    public void resetCountColumns() {
        this.valuesColumn = 0;
    }

    @Override
    public void resetCountString() {
        this.valuesString = 0;
    }
    @Override
    public void resetCountDiagonal() {
        this.valuesDiagonal = 0;
    }

    @Override
    public void resetCountSecondDiagonal() {
        this.valuesSecondDiagonal = 0;
    }

    @Override
    public boolean checkColumnsStrings() {
        return this.valuesColumn == 3 || this.valuesString == 3;
    }

    @Override
    public boolean checkDiagonals() {
        return this.valuesDiagonal == 3 || this.valuesSecondDiagonal == 3;
    }


}
