// CartAdapter.java
package com.example.shopify.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopify.R;
import com.example.shopify.ui.cart.CartItem;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    int quatity = 0;
    private List<CartItem> cartItems;
    private Context context;

    public CartAdapter(List<CartItem> cartItems, Context context) {
        this.cartItems = cartItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_view, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        holder.incrementButton.setOnClickListener(view -> {
            holder.quantityTextView.setText(String.valueOf(quatity++));



        });

        holder.decrementButton.setOnClickListener(view -> {
            if(quatity >0)  holder.quantityTextView.setText(String.valueOf(quatity--));
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemPrice;
        ImageView itemImage;
        TextView quantityTextView;
        Button incrementButton;
        Button decrementButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.itemName);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            itemImage = itemView.findViewById(R.id.itemImage);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            incrementButton = itemView.findViewById(R.id.btnAdd);
            decrementButton = itemView.findViewById(R.id.btnSubtract);
        }
    }
}
