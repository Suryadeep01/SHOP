// ProductDescriptionActivity.java
package com.example.shopify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ProductDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);

        // Retrieve product details from Intent or any other source
        String productName = getIntent().getStringExtra("productName");
        double productPrice = getIntent().getDoubleExtra("productPrice", 0.0);
        int productImageResId = getIntent().getIntExtra("productImageResId", 0);

        // Set up UI components
        TextView nameTextView = findViewById(R.id.productName);
        TextView priceTextView = findViewById(R.id.productPrice);
        ImageView productImageView = findViewById(R.id.productImage);
        Button addToCartButton = findViewById(R.id.addToCartButton);
        Intent mIntent = getIntent();
        int c = mIntent.getIntExtra("Category", 0);

        int b = mIntent.getIntExtra("product", 0);


        Intent intent = new Intent();
//         int c =  Integer.parseInt(intent.getStringExtra("id"));
//         int b = Integer.parseInt(intent.getStringExtra("product"));
        int draw = ShopDb.getInstance().getProduct(c,b);
        Glide.with(this).load(draw).into(productImageView);



        // Set product details to UI
//        nameTextView.setText(productName);
//        priceTextView.setText(getString(R.string.price_format, productPrice));
//        productImageView.setImageResource(productImageResId);

        // Add to cart button click listener
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement the logic to add the product to the cart
                // You may want to use a ViewModel or other architecture components for this
                // For simplicity, you can use SharedPreferences, a database, or other storage methods
                // Update: You can use the CartAdapter and CartItem classes for this logic
            }
        });
    }
}
