package com.example.c4;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText userName, password, address, age;
    RadioGroup gender;
    DatePicker dob;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        dob = findViewById(R.id.dob);
        display = findViewById(R.id.display);

        // Set onClickListener for submit button
        findViewById(R.id.submit).setOnClickListener(v -> {
            // Get selected gender
            int selectedGenderId = gender.getCheckedRadioButtonId();
            String genderText = "";
            if (selectedGenderId != -1) {
                genderText = ((RadioButton) findViewById(selectedGenderId)).getText().toString();
            }

            // Get date of birth
            String dobText = dob.getDayOfMonth() + "/" + (dob.getMonth() + 1) + "/" + dob.getYear();

            // Prepare result string
            String result = "User Name: " + userName.getText().toString() +
                    "\nPassword: " + password.getText().toString() +
                    "\nAddress: " + address.getText().toString() +
                    "\nGender: " + genderText +
                    "\nAge: " + age.getText().toString() +
                    "\nDate of Birth: " + dobText ;

            // Display result
            display.setText(result);
        });
    }
}
