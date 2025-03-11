package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMIResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        // Get references to UI elements
        TextView txtBMIStatus = findViewById(R.id.txtBMIStatus);
        TextView txtBMIValue = findViewById(R.id.txtBMIValue);
        TextView txtWeightRange = findViewById(R.id.txtWeightRange);
        Button btnRecalculate = findViewById(R.id.btnRecalculate);

        // Get BMI value from intent
        double bmi = getIntent().getDoubleExtra("bmi", 0.0);

        // Determine BMI category and weight range
        String status;
        String weightRange;

        if (bmi < 18.5) {
            status = "UNDERWEIGHT";
            weightRange = "58 ~ 70";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "NORMAL WEIGHT";
            weightRange = "60 ~ 75";
        } else {
            status = "OVERWEIGHT";
            weightRange = "65 ~ 85";
        }

        // Update UI with BMI results
        txtBMIStatus.setText(status);
        txtBMIValue.setText(String.format("%.1f", bmi));
        txtWeightRange.setText(weightRange);

        // Recalculate Button Click Listener
        btnRecalculate.setOnClickListener(v -> {
            Intent intent = new Intent(BMIResultActivity.this, HeightSelectMaleActivity.classlectMaleActivityaleActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
