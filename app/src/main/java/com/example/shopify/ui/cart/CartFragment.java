package com.example.shopify.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.shopify.R;

public class CartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        // Get the "Proceed to Checkout" button
        Button btnProceedToCheckout = rootView.findViewById(R.id.btnProceedToCheckout);

        // Set a click listener to navigate to the checkout page when the button is clicked
        btnProceedToCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use Navigation to navigate to the checkout page
                Navigation.findNavController(view).navigate(R.id.action_cartFragment_to_CheckoutActivity);
            }
        });

        return rootView;
    }
}
