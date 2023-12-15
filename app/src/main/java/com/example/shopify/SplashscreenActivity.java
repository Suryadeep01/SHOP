package com.example.shopify;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        TextView skipTextView = findViewById(R.id.skip_tv);
        TextView getStartedTextView = findViewById(R.id.next_arrow);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToNextScreen();
            }
        }, 1400);

        getStartedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToNextScreen();
            }
        });
    }

    private void navigateToNextScreen() {
        // For demonstration purposes, just launch another activity (replace with your logic)
        Intent intent = new Intent(SplashscreenActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Finish this activity so the user cannot navigate back to it
    }
}
