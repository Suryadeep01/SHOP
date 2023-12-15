package com.example.shopify.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopify.R;

import java.util.ArrayList;
import java.util.List;

public class WishListFragment extends Fragment {

    private RecyclerView wishListRecyclerView;
    private WishListAdapter wishListAdapter;
    private Button proceedToCheckoutButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_wish_list, container, false);

        // Initialize RecyclerView
        wishListRecyclerView = rootView.findViewById(R.id.wishListRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        wishListRecyclerView.setLayoutManager(layoutManager);

        // Initialize and set up your RecyclerView adapter with wish list items
        List<WishListItem> wishListItems = generateWishListItems(); // Replace with your data
        wishListAdapter = new WishListAdapter(wishListItems);
        wishListRecyclerView.setAdapter(wishListAdapter);

        // Initialize Proceed to Checkout button
        proceedToCheckoutButton = rootView.findViewById(R.id.ProceedToCheckout);

        return rootView;
    }

    private List<WishListItem> generateWishListItems() {
        // Replace this with your actual data
        List<WishListItem> wishListItems = new ArrayList<>();
        wishListItems.add(new WishListItem(R.drawable.sre, "Product 1", 20.99));
        wishListItems.add(new WishListItem(R.drawable.sss, "Product 2", 15.49));
        // Add more items as needed
        return wishListItems;
    }
}
