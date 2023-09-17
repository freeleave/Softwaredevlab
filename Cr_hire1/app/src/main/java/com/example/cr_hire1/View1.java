package com.example.cr_hire1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class View1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);
        findViewById(R.id.alphards).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the second activity when the "Rent" button is clicked
                Intent intent = new Intent(View1.this, Alphard.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.Suvs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the second activity when the "Rent" button is clicked
                Intent intent = new Intent(View1.this, fives.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the second activity when the "Rent" button is clicked
                Intent intent = new Intent(View1.this, Suvs.class);
                startActivity(intent);
            }
        });
    }
}