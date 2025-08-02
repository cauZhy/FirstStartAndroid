package com.example.firststartandroid.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import com.example.firststartandroid.R;

public class RegisterActivity extends AppCompatActivity {

    EditText editFirstName, editLastName, editUsername, editPhone, editEmail, editNote;
    Button btnSignUp, btnBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_register);

        // Use root view via android.R.id.content
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editUsername = findViewById(R.id.editUsername);
        editPhone = findViewById(R.id.editPhone);
        editEmail = findViewById(R.id.editEmail);
        editNote = findViewById(R.id.editNote);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnBackToLogin = findViewById(R.id.btnBackToLogin);

        btnSignUp.setOnClickListener(v -> {
            if (validateInputs()) {
                Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                // Add your registration logic here
            }
        });

        btnBackToLogin.setOnClickListener(v -> finish());
    }

    private boolean validateInputs() {
        String firstName = editFirstName.getText().toString().trim();
        String lastName = editLastName.getText().toString().trim();
        String username = editUsername.getText().toString().trim();
        String phone = editPhone.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String note = editNote.getText().toString().trim();

        if (TextUtils.isEmpty(firstName)) {
            editFirstName.setError("First name is required");
            editFirstName.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(lastName)) {
            editLastName.setError("Last name is required");
            editLastName.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(username)) {
            editUsername.setError("Username is required");
            editUsername.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(phone)) {
            editPhone.setError("Phone number is required");
            editPhone.requestFocus();
            return false;
        }
        if (!Patterns.PHONE.matcher(phone).matches()) {
            editPhone.setError("Invalid phone number");
            editPhone.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(email)) {
            editEmail.setError("Email is required");
            editEmail.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("Invalid email address");
            editEmail.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(note)) {
            editNote.setError("Note is required");
            editNote.requestFocus();
            return false;
        }
        return true;
    }
}
