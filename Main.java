package movable;

public class Main {
    public static void main(String[] args) {
// Абстрактный класс Shape
        abstract class Shape {
            protected String color;
            protected boolean filled;

            public Shape() {
                color = "green";
                filled = true;
            }

            public Shape(String color, boolean filled) {
                this.color = color;
                this.filled = filled;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public boolean isFilled() {
                return filled;
            }

            public void setFilled(boolean filled) {
                this.filled = filled;
            }

            public abstract double getArea();
            public abstract double getPerimeter();

            public String toString() {
                return "Shape[color=" + color + ", filled=" + filled + "]";
            }
        }

// Класс Circle (круг)
        class Circle extends Shape {
            protected double radius;

            public Circle() {
                super();
                radius = 1.0;
            }

            public Circle(double radius) {
                super();
                this.radius = radius;
            }

            public Circle(double radius, String color, boolean filled) {
                super(color, filled);
                this.radius = radius;
            }

            public double getRadius() {
                return radius;
            }

            public void setRadius(double radius) {
                this.radius = radius;
            }

            @Override
            public double getArea() {
                return Math.PI * radius * radius;
            }

            @Override
            public double getPerimeter() {
                return 2 * Math.PI * radius;
            }

            @Override
            public String toString() {
                return "Circle[" + super.toString() + ", radius=" + radius + "]";
            }
        }

// Класс Rectangle (прямоугольник)
        class Rectangle extends Shape {
            protected double width;
            protected double length;

            public Rectangle() {
                super();
                width = 1.0;
                length = 1.0;
            }

            public Rectangle(double width, double length) {
                super();
                this.width = width;
                this.length = length;
            }

            public Rectangle(double width, double length, String color, boolean filled) {
                super(color, filled);
                this.width = width;
                this.length = length;
            }

            public double getWidth() {
                return width;
            }

            public void setWidth(double width) {
                this.width = width;
            }

            public double getLength() {
                return length;
            }

            public void setLength(double length) {
                this.length = length;
            }

            @Override
            public double getArea() {
                return width * length;
            }

            @Override
            public double getPerimeter() {
                return 2 * (width + length);
            }

            @Override
            public String toString() {
                return "Rectangle[" + super.toString() + ", width=" + width + ", length=" + length + "]";
            }
        }

// Класс Square (квадрат)
        class Square extends Rectangle {
            public Square() {
                super();
            }

            public Square(double side) {
                super(side, side);
            }

            public Square(double side, String color, boolean filled) {
                super(side, side, color, filled);
            }

            public double getSide() {
                return width;
            }

            public void setSide(double side) {
                this.width = side;
                this.length = side;
            }

            @Override
            public void setWidth(double side) {
                setSide(side);
            }

            @Override
            public void setLength(double side) {
                setSide(side);
            }

            @Override
            public String toString() {
                return "Square[" + super.toString() + "]";
            }
        }

// Главный класс для тестирования
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println("Area: " + s1.getArea());
        System.out.println("Perimeter: " + s1.getPerimeter());
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());

        // Для вызова getRadius() нужно сделать downcast
        if (s1 instanceof Circle) {
            System.out.println("Radius: " + ((Circle)s1).getRadius());
        }

        Circle c1 = (Circle)s1;
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println("Color: " + c1.getColor());
        System.out.println("Filled: " + c1.isFilled());
        System.out.println("Radius: " + c1.getRadius());

        // Убрано создание абстрактного класса Shape
        // Shape s2 = new Shape(); // НЕВОЗМОЖНО!

        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println("Area: " + s3.getArea());
        System.out.println("Perimeter: " + s3.getPerimeter());
        System.out.println("Color: " + s3.getColor());

        // Для вызова getLength() нужно сделать downcast
        if (s3 instanceof Rectangle) {
            System.out.println("Length: " + ((Rectangle)s3).getLength());
        }

        Rectangle r1 = (Rectangle)s3;
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Color: " + r1.getColor());
        System.out.println("Length: " + r1.getLength());

        Shape s4 = new Square(6.6);
        System.out.println(s4);
        System.out.println("Area: " + s4.getArea());
        System.out.println("Color: " + s4.getColor());

        // Для вызова getSide() нужно сделать downcast до Square
        if (s4 instanceof Square) {
            System.out.println("Side: " + ((Square)s4).getSide());
        }

        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println("Area: " + r2.getArea());
        System.out.println("Color: " + r2.getColor());

        // getSide() доступен только в Square, не в Rectangle
        // System.out.println(r2.getSide()); // ОШИБКА!
        System.out.println("Length: " + r2.getLength());

        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Color: " + sq1.getColor());
        System.out.println("Side: " + sq1.getSide());
        System.out.println("Length: " + sq1.getLength());

        //Для задания 2
        // Тестирование MovablePoint
        System.out.println("");
        System.out.println("Задание 2");
        System.out.println("");
        MovablePoint point = new MovablePoint(0, 0, 1, 1);
        System.out.println("Initial: " + point);

        point.moveUp();
        System.out.println("After moveUp: " + point);

        point.moveRight();
        System.out.println("After moveRight: " + point);

        // Тестирование MovableCircle
        MovableCircle circle = new MovableCircle(5, 5, 2, 2, 3);
        System.out.println("Initial circle: " + circle);

        circle.moveDown();
        System.out.println("After moveDown: " + circle);

        circle.moveLeft();
        System.out.println("After moveLeft: " + circle);
    }
}