package com.example.shopify.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopify.CheckoutActivity;
import com.example.shopify.R;
import com.example.shopify.ui.home.CartAdapter;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ImageView backButton = findViewById(R.id.backButton);
        RecyclerView cartRecyclerView = findViewById(R.id.cartRecyclerViewActivty);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });



        Button checkoutButton = findViewById(R.id.Checkout);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start CheckoutActivity when the checkout button is clicked
                startActivity(new Intent(CartActivity.this, CheckoutActivity.class));
            }
        });
//
            List<CartItem> cartItemList = new ArrayList<>();
            CartAdapter cartAdapter = new CartAdapter(cartItemList, this);
            cartRecyclerView.setAdapter(cartAdapter);
           cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        }
    }
