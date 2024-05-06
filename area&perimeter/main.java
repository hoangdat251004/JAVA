package lab_shape;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        // Step1: Enter input Rectangle
        Rectangle rectangle = enterInputRectangle();
        // Step2: Enter input Circle
        Circle circle = enterInputCircle();
        // Step3: Enter input Triangle
        Triangle triangle = enterInputTriangle();
        // Step4: display result
        displayResult(rectangle, circle, triangle);

    }

    static double checkInputDouble() {
        Scanner sc = new Scanner(System.in);
        // check input format
        while (true) {
            try {
                double input = Double.parseDouble(sc.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Wrong format input. Enter again.");
            }
        }
    }

    static Triangle enterInputTriangle() {
        // check input format and a right triangle
        while (true) {
            System.out.println("Please enter side A of Triangle: ");
            double a = checkInputDouble();
            System.out.println("Please enter side B of Triangle: ");
            double b = checkInputDouble();
            System.out.println("Please enter side C of Triangle: ");
            double c = checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Not a triangle. Enter again");
            }
        }
    }

    static Rectangle enterInputRectangle() {
        System.out.println("Please enter side width of Rectangle: ");
        double width = checkInputDouble();
        System.out.println("Please enter length of Rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    static Circle enterInputCircle() {
        System.out.println("Please enter radius of Circle: ");
        double radius = checkInputDouble();
        return new Circle(radius);
    }

    static void displayResult(Rectangle rectangle, Circle circle, Triangle triangle) {
        System.out.println("\n\n");
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

}
