package com.example.cr_hire1;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            findViewById(R.id.login1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Open the RegisterActivity when the "Register" button is clicked
                    Intent intent = new Intent(MainActivity2.this, Register.class);
                    startActivity(intent);
                }
            });

            findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Open the LoginActivity when the "Login" button is clicked
                    Intent intent = new Intent(MainActivity2.this, Logins.class);
                    startActivity(intent);
                }
            });
        }
    }

