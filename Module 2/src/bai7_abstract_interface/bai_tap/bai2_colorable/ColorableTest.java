package bai7_abstract_interface.bai_tap.bai2_colorable;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        shapes[0]=new Rectangle(1,2);
        shapes[1]=new Square(1);
        shapes[2]=new Square(2);

        for(Shape shape: shapes){
            System.out.println(shape.getArea());
            if(shape instanceof Square){
                ((Square) shape).howToColor();
            }
        }
    }

}
