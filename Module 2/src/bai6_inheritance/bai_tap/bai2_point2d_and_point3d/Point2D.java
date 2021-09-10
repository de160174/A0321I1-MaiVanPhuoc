package bai6_inheritance.bai_tap.bai2_point2d_and_point3d;

import java.util.Arrays;

public class Point2D {
   protected float x=0.0f;
   protected float y=0.0f;

    public Point2D() {
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public float[] getXY() {
        float[] arr={x,y};
        return arr;
    }

    public void setXY(float x,float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point2D point2D=new Point2D(1,2);
        System.out.println(point2D);
        System.out.println(" Point2D " +Arrays.toString(point2D.getXY()));
    }
}
