package com.example.firststartandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import com.example.firststartandroid.R;

public class LoginActivity extends AppCompatActivity {

    EditText editStudentID, editPassword;
    CheckBox checkboxRemember;
    TextView textForgotPassword;
    Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge UI
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_login);

        // Use android.R.id.content as root view for insets listener
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Bind views
        editStudentID = findViewById(R.id.editStudentID);
        editPassword = findViewById(R.id.editPassword);
        checkboxRemember = findViewById(R.id.checkboxRemember);
        textForgotPassword = findViewById(R.id.textForgotPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        // Login button click
        btnLogin.setOnClickListener(v -> {
            if (validateLogin()) {
                Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                // TODO: Add actual login logic here
            }
        });

        // Sign Up button click
        btnSignUp.setOnClickListener(v -> {
//            Toast.makeText(LoginActivity.this, "Navigate to Sign Up screen", Toast.LENGTH_SHORT).show();
//            // TODO: Add navigation to RegisterActivity
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        // Forgot Password clickable text
        textForgotPassword.setOnClickListener(v -> {
            Toast.makeText(LoginActivity.this, "Forgot Password clicked", Toast.LENGTH_SHORT).show();
            // TODO: Add forgot password logic here
        });
    }

    private boolean validateLogin() {
        String studentID = editStudentID.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if (TextUtils.isEmpty(studentID)) {
            editStudentID.setError("Student ID is required");
            editStudentID.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            editPassword.setError("Password is required");
            editPassword.requestFocus();
            return false;
        }

        if (password.length() < 6) {
            editPassword.setError("Password must be at least 6 characters");
            editPassword.requestFocus();
            return false;
        }

        return true;
    }
}
