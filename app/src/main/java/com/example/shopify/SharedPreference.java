package com.example.shopify;

public class SharedPreference {
    private static SharedPreference single_instance = null;
    public static synchronized SharedPreference getInstance() {

        if (single_instance == null)
            single_instance = new SharedPreference();

        return single_instance;
    }
}
