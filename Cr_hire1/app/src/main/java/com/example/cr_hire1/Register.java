package com.example.cr_hire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    // Firebase references
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FloatingActionButton floatingActionButton;

    // Views
    private EditText nameEditText, emailEditText, licenseNumberEditText, PhoneNumber, pass;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = findViewById(R.id.name1);
        emailEditText = findViewById(R.id.email);
        licenseNumberEditText = findViewById(R.id.license);
        PhoneNumber = findViewById(R.id.phone);
        pass = findViewById(R.id.duration);
        registerButton = findViewById(R.id.login1);


        findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String license = licenseNumberEditText.getText().toString();
                String phone = PhoneNumber.getText().toString();
                String password = pass.getText().toString();

                addQuoteToDB(name, email, phone, license);
                 registerUser(email, password);
            }
        });
    }

    private void addQuoteToDB(String name, String email, String phone, String license) {
        HashMap<String, Object> nameHashmap = new HashMap<>();
        nameHashmap.put("name", name);
        nameHashmap.put("email", email);
        nameHashmap.put("phone", phone);
        nameHashmap.put("license", license);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myself = database.getReference("names");

        String key = myself.push().getKey();
        nameHashmap.put("key", key);
        myself.child(key).setValue(nameHashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                Toast.makeText(Register.this, "Added", Toast.LENGTH_SHORT).show();
                nameEditText.getText().clear();
                emailEditText.getText().clear();
                licenseNumberEditText.getText().clear();
                PhoneNumber.getText().clear();

            }
        });
    }

    private void registerUser(String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registration successful
                            Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            // Registration failed
                            Toast.makeText(Register.this, "Registration failed: " + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    }

