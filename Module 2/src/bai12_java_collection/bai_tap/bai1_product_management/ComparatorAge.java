package bai12_java_collection.bai_tap.bai1_product_management;

import bai12_java_collection.bai_tap.bai1_product_management.Product;

import java.util.Comparator;

public class ComparatorAge implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice()-o2.getPrice());
    }
}
