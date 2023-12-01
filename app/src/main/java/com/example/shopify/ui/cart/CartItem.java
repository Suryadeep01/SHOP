package com.example.shopify.ui.cart;

public class CartItem {

    private String itemName;
    private double itemPrice;
    private int itemImageResource; // Assuming you use a resource ID for the item image

    public CartItem(String itemName, double itemPrice, int itemImageResource) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImageResource = itemImageResource;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getItemImageResource() {
        return itemImageResource;
    }

    public int getQuantity() {
        return 0;
    }
}
