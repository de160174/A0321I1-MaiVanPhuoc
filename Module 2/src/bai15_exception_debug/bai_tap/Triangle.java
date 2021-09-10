package bai15_exception_debug.bai_tap;

public class Triangle {
    private int x;
    private int y;
    private int z;

    public Triangle(int x, int y, int z) throws IllegalTriangleException{
        this.x = x;
        this.y = y;
        this.z = z;
        if (x<0||y<0||z<0||x+y<z||x+z<y||y+z<x){
            throw new IllegalTriangleException("số không được âm và tổng của 2 cạnh phải lớn hơn cạnh còn lại");
        }
    }
}
