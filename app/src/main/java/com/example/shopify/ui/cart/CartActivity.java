package com.example.shopify.ui.cart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopify.R;
import com.example.shopify.ui.home.CartAdapter;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        List<CartItem> cartItemList = new ArrayList<>(); // Replace this with your actual list
        CartAdapter cartAdapter = new CartAdapter(cartItemList, this);
        RecyclerView cartRecyclerView =  findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setAdapter(cartAdapter);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}