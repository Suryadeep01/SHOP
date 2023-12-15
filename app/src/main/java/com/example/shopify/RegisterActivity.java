package com.example.shopify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = findViewById(R.id.name_et);
        editTextEmail = findViewById(R.id.email_et);
        editTextPhone = findViewById(R.id.phone_et);
        editTextPassword = findViewById(R.id.password_et);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    // Registration logic
                    String name = editTextName.getText().toString();
                    String email = editTextEmail.getText().toString();
                    String phone = editTextPhone.getText().toString();
                    String password = editTextPassword.getText().toString();

                    // For demonstration purposes, just launch NextActivity
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("phone", phone);
                    intent.putExtra("password", password);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean validateInputs() {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String password = editTextPassword.getText().toString();

        if (name.isEmpty()) {
            editTextName.setError("Name is required");
            return false;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            return false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email address");
            return false;
        }

        if (phone.isEmpty()) {
            editTextPhone.setError("Phone number is required");
            return false;
        } else if (phone.length() != 10) {
            editTextPhone.setError("Enter a valid 10-digit phone number");
            return false;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            return false;
        } else if (password.length() < 8) {
            editTextPassword.setError("Password must be at least 8 characters");
            return false;
        } else if (!isStrongPassword(password)) {
            editTextPassword.setError("Password should contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
            return false;
        }

        // Clear any previous errors
        editTextName.setError(null);
        editTextEmail.setError(null);
        editTextPhone.setError(null);
        editTextPassword.setError(null);

        return true;
    }

    private boolean isStrongPassword(String password) {
        // Add your criteria for a strong password here
        // For example, requiring at least one uppercase letter, one lowercase letter, one digit, and one special character
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return password.matches(pattern);
    }
}
