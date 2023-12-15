package com.example.shopify.ui.cart;

public class WishListItem {
    private int imageResourceId;
    private String productName;
    private double productPrice;

    public WishListItem(int imageResourceId, String productName, double productPrice) {
        this.imageResourceId = imageResourceId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
