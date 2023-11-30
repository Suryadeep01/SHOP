package com.example.shopify;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

class ProfileActivity extends AppCompatActivity {

    private CircleImageView profileImage;
    private TextView userName, mailId, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = findViewById(R.id.profile_image);
        userName = findViewById(R.id.userName);
        mailId = findViewById(R.id.mailId);
        address = findViewById(R.id.address);

        // Set profile image (replace with your actual image)
        profileImage.setImageResource(R.drawable.banner);
        profileImage.setBorderWidth(2); // Set border width in dp
        profileImage.setBorderColor(getResources().getColor(R.color.white)); // Set border color
        profileImage.setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.profile_image_bottom_margin)); // Set bottom margin

        userName.setText("User Name");
        mailId.setText("user@gmail.com");
        address.setText("Bangalore, Karnataka");
    }
}
