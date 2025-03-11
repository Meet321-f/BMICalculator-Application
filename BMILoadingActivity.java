package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class BMILoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_loading);

        // Get data from intent
        int feet = getIntent().getIntExtra("feet", 0);
        int inches = getIntent().getIntExtra("inches", 0);
        double weight = getIntent().getDoubleExtra("weight", 0.0);

        // Calculate BMI
        double heightInMeters = ((feet * 12) + inches) * 0.0254;
        double bmi = weight / (heightInMeters * heightInMeters);

        // Delay for 3 seconds then show result
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(BMILoadingActivity.this, BMIResultActivity.class);
            intent.putExtra("bmi", bmi);
            startActivity(intent);
            finish();
        }, 3000);
    }
}
