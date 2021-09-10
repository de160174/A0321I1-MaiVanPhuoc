package bai6_inheritance.thuc_hanh;

public class Geometric {
    private String color="green";
    private  boolean filled=true;

    public Geometric() {
    }

    public Geometric(String color, boolean filled) {
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

    @Override
    public String toString() {
        return "A Shape with color of "+color+ " and " +(isFilled()?"filled":"not filled");
    }
    public class Circle extends Geometric {
        private double radius = 1.0;

        public Circle() {
        }

        public Circle(double radius) {
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

        public double getArea() {
            return radius * radius * Math.PI;
        }

        public double getPerimeter() {
            return 2 * radius * Math.PI;
        }

        @Override
        public String toString() {
            return "A Circle with radius="
                    + getRadius()
                    + ", which is a subclass of "
                    + super.toString();
        }
    }
    public class Rectangle extends Geometric{
        private double width=1.0;
        private double length=1.0;

        public Rectangle() {
        }

        public Rectangle(double width, double length) {
            this.width = width;
            this.length = length;
        }

        public Rectangle(String color, boolean filled, double width, double length) {
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
        public double getArea(double width,double height){
            return width*height;
        }
        public double getPerimeter(double width,double height){
            return (width+height)*2;
        }

        @Override
        public String toString() {
            return  "A Rectangle with width= "+width+" and length= "+length+", which is a subclass of "+super.toString();
        }

    }
    public class Square extends Rectangle {
        public Square() {
        }

        public Square( String color, boolean filled,double side) {
            super(color, filled,side,side);
        }

        public Square(double side) {
            super(side, side);
        }

        public double getSide() {
            return getWidth();
        }

        public void setSide(double side) {
            setWidth(side);
            setLength(side);
        }

        @Override
        public void setWidth(double width) {
            setSide(width);
        }

        @Override
        public void setLength(double length) {
            setSide(length);
        }

        @Override
        public String toString() {
            return "A Square with side="
                    + getSide()
                    + ", which is a subclass of "
                    + super.toString();
        }
    }

    public static void main(String[] args) {
        Geometric shape = new Geometric();
        System.out.println(shape);

        shape = new Geometric("red", false);
        System.out.println(shape);
    }

}
