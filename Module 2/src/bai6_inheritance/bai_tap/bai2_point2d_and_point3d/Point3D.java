package bai6_inheritance.bai_tap.bai2_point2d_and_point3d;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z=0.0f;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ() {
        float[] arr={x,y,z};
        return arr;
    }

    public void setXYZ(float x,float y,float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static void main(String[] args) {
        Point3D point3D=new Point3D(1,2,3);
        System.out.println(point3D);
        point3D.setXYZ(4,5,6);
        System.out.println(" Point3D " + Arrays.toString(point3D.getXYZ()));
    }
}
