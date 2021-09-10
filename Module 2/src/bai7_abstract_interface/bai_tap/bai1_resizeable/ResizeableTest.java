package bai7_abstract_interface.bai_tap.bai1_resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(1);
        shapes[1] = new Rectangle(2, 2);
        shapes[2] = new Square(3);
        System.out.println("Pre-resized: ");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(((Circle) shape).getArea());
            }else if(shape instanceof Square){
                System.out.println(((Square)shape).getArea());
            }
            else {
                System.out.println(((Rectangle) shape).getArea());
            }
        }

        System.out.println("After resized: ");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                ((Circle) shape).resize(10);
                System.out.println(((Circle) shape).getArea());
            }else if(shape instanceof Square){
                ((Square) shape).resize(25);
                System.out.println(((Square)shape).getArea());
            }
            else {
                ((Rectangle) shape).resize(10);
                System.out.println(((Rectangle) shape).getArea());
            }
        }
    }
}
