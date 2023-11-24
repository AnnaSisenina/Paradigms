package Seminar4.Task1;

public class Circle extends Shape {


    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double get_area() {
        return this.radius*this.radius*Math.PI;
    }

    @Override
    public double get_perimeter() {
        return 2 * Math.PI * this.radius;
    }
}
