package bai6_inheritance.bai_tap.bai1_circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return radius*radius*Math.PI*height;
    }

    @Override
    public String toString() {
        return "Cylinder: " +
                "radius=" + radius +
                ", height=" + height + " and volume "+getVolume();
    }

    public static void main(String[] args) {
        Cylinder cylinder=new Cylinder(2,"yellow",3);
        System.out.println(cylinder);
    }
}
