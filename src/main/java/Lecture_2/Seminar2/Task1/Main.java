package Lecture_2.Seminar2.Task1;

public class Main {
    public static void main(String[] args) {
        int [][]array = new int[5][5];
        int length = array[0].length;
        int width = array[1].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                array[i][j] = (int) (Math.random() * 5);
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

        if (length == width) {
            int trace = 0;
            for (int i = 0; i < length; i++) {
                trace = trace + array[i][i];
            }
            System.out.println("След матрицы =" + trace);
        }
        else System.out.println("для этой матрицы нельзя рассчитать след");



    }

}
