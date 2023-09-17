package com.example.cr_hire1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class fives extends AppCompatActivity {

    // Firebase references
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FloatingActionButton floatingActionButton;

    // Views
    private EditText licenseEditText, locationEditText, durationEditText;
    private Button bookButton;
    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphard);

        licenseEditText = findViewById(R.id.license);
        locationEditText = findViewById(R.id.email);
        durationEditText = findViewById(R.id.duration);
        priceTextView =  findViewById(R.id.logg);
        bookButton = findViewById(R.id.login1);



        findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String license = licenseEditText.getText().toString();
                String duration = durationEditText.getText().toString();
                String location = locationEditText.getText().toString();
                String price = priceTextView.getText().toString();



                addQuoteToDB(license, duration, location, price);

            }
        });
    }

    private void addQuoteToDB(String license, String duration, String location, String price) {
        HashMap<String, Object> nameHashmap = new HashMap<>();
        nameHashmap.put("name", license);
        nameHashmap.put("email", duration);
        nameHashmap.put("phone", location);
        nameHashmap.put("license", price);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myself = database.getReference("bookings fives");

        String key = myself.push().getKey();
        nameHashmap.put("key", key);
        myself.child(key).setValue(nameHashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                Toast.makeText(fives.this, "Added", Toast.LENGTH_SHORT).show();
                locationEditText.getText().clear();
                licenseEditText.getText().clear();

                durationEditText.getText().clear();

            }
        });
    }


}

