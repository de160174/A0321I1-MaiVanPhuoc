package bai6_inheritance.bai_tap.bai3_point_and_moveablepoint;

import java.util.Arrays;

public class Point {
    protected float x=0.0f;
    protected float y=0.0f;

    public Point() {
    }

    public Point(float x, float y) {
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
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point point=new Point(2,2);
        System.out.println(point);
        System.out.println(Arrays.toString(point.getXY()));
    }
}
