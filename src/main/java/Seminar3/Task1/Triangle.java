package Seminar3.Task1;

public class Triangle extends Shape{

    double firstSide;
    double secondSide;
    double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public double get_area() {
        double perimeter = get_perimeter() * 0.5;
        return Math.sqrt(perimeter*(perimeter-this.firstSide)*(perimeter-this.secondSide)*(perimeter-this.thirdSide));
    }

    @Override
    public double get_perimeter() {
        return this.firstSide+this.secondSide+this.thirdSide;
    }
}
