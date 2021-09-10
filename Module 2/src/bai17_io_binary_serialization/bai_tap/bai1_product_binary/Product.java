package bai17_io_binary_serialization.bai_tap.bai1_product_binary;

import java.io.Serializable;

public class Product implements Serializable {
    private String ProductId;
    private String ProductName;
    private String ProductBrand;
    private double ProductPrice;
    private String ProductDesc;

    public Product() {
    }

    public Product(String productId, String productName, String productBrand, double productPrice, String productDesc) {
        ProductId = productId;
        ProductName = productName;
        ProductBrand = productBrand;
        ProductPrice = productPrice;
        ProductDesc = productDesc;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductBrand() {
        return ProductBrand;
    }

    public void setProductBrand(String productBrand) {
        ProductBrand = productBrand;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductDesc() {
        return ProductDesc;
    }

    public void setProductDesc(String productDesc) {
        ProductDesc = productDesc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId='" + ProductId + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", ProductBrand='" + ProductBrand + '\'' +
                ", ProductPrice=" + ProductPrice +
                ", ProductDesc='" + ProductDesc + '\'' +
                '}';
    }
}
