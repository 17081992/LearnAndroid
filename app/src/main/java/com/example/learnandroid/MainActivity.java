package com.example.learnandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private TextView attemptsInfo;

    private String admin = "admin";
    private String pass = "1234";
    boolean isValid = true;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.Username1);
        password = findViewById(R.id.Password2);
        login = findViewById(R.id.button_login2);
        attemptsInfo = findViewById(R.id.viewAttempts);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();

                if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please complete the username and password", Toast.LENGTH_LONG).show();
                } else {
                    isValid = validation(inputUsername, inputPassword);
                    if (!isValid) {
                        counter--;
                        Toast.makeText(MainActivity.this, "Incorrect credentials!", Toast.LENGTH_LONG).show();
                        attemptsInfo.setText("Number of attempts remaining is " + counter);

                        if (counter == 0) {
                            login.setEnabled(false);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Login succesful!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent);
                    }

                }

            }
        });
    }

    private boolean validation(String name, String password) {
        if (name.equals(admin) && password.equals(pass)) {
            return true;
        }
        return false;

    }
}
