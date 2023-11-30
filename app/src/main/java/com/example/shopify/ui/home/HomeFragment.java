package com.example.shopify.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.shopify.CategoriesAdapter;
import com.example.shopify.CheckoutActivity;
import com.example.shopify.R;
import com.example.shopify.ui.cart.CartActivity;
import com.example.shopify.ui.cart.CartItem;
import com.example.shopify.ui.home.CarouselAdapter;
import com.example.shopify.ui.home.CartAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ViewPager2 newArrivalsViewPager;
    private CarouselAdapter carouselAdapter;
    private Handler handler = new Handler();
    private CartAdapter cartAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        newArrivalsViewPager = rootView.findViewById(R.id.newArrivalsViewPager);
        RecyclerView recyclerView = rootView.findViewById(R.id.recylerview);
        CategoriesAdapter adapter = new CategoriesAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        carouselAdapter = new CarouselAdapter(requireContext());
        newArrivalsViewPager.setAdapter(carouselAdapter);

        // Start auto-scrolling
        startAutoScroll();

        // Cart icon click listener
        ImageView cartIcon = rootView.findViewById(R.id.cartIcon);
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the CartFragment
                startActivity(new Intent(requireContext(), CartActivity.class));

            }
        });

        // Checkout button click listener
        View checkoutButton = rootView.findViewById(R.id.Checkout);
        if (checkoutButton != null) {
            checkoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start CheckoutActivity when the button is clicked
                    startActivity(new Intent(requireContext(), CheckoutActivity.class));
                }
            });
        } else {
            Log.e("HomeFragment", "Checkout button not found!");
        }

        // Initialize the CartAdapter


        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
    }

    private void startAutoScroll() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem = newArrivalsViewPager.getCurrentItem();
                int totalItems = carouselAdapter.getItemCount();
                int nextItem = (currentItem + 1) % totalItems;
                newArrivalsViewPager.setCurrentItem(nextItem, true);
                startAutoScroll();
            }
        }, 3000); // Adjust the delay as needed (e.g., 3000 milliseconds for 3 seconds)
    }
}
