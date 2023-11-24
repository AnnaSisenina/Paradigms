package Seminar4.HW4;

import java.util.Arrays;

public class PirsonsCorrelation {
    public static void main(String[] args) {
    double [] arrayX = {2,3,4,8,6};
    double [] arrayY = {3,4,5,6,7};
    double averageX = Arrays.stream(arrayX)
            .average()
            .getAsDouble();
    double averageY = Arrays.stream(arrayY)
            .average()
            .getAsDouble();
        System.out.println(averageX);
        System.out.println(averageY);
        System.out.println(correlation(arrayX, arrayY, averageX, averageY));
    }

    private static double correlation(double[] arrayX, double[] arrayY, double averageX, double averageY) {
        double numerator = 0;
        double denumerator1 = 0;
        double denumerator2 = 0;
        int length = arrayX.length;
        for (int i = 0; i < length; i++) {
                numerator += (arrayX[i] - averageX)*(arrayY[i] - averageY);
                denumerator1 += Math.pow((arrayX[i] - averageX),2);
                denumerator2 += Math.pow((arrayY[i] - averageY),2);
            }
        return numerator / Math.sqrt(denumerator1*denumerator2);

        }

}
