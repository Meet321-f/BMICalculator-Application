package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imgMale, imgFemale;
    private Button btnNext;
    private NumberPicker numberPickerAge, numberPickerWeight;
    private boolean isMaleSelected = false;
    private boolean isGenderSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        imgMale = findViewById(R.id.imgMale);
        imgFemale = findViewById(R.id.imgFemale);
        btnNext = findViewById(R.id.btnNext);
        numberPickerAge = findViewById(R.id.numberPickerAge);
        numberPickerWeight = findViewById(R.id.numberPickerWeight);

        // Age Picker setup
        numberPickerAge.setMinValue(1);
        numberPickerAge.setMaxValue(100);
        numberPickerAge.setWrapSelectorWheel(true);

        // Weight Picker setup
        numberPickerWeight.setMinValue(1);
        numberPickerWeight.setMaxValue(200);
        numberPickerWeight.setWrapSelectorWheel(true);

        // Gender selection logic
        imgMale.setOnClickListener(v -> {
            isMaleSelected = true;
            isGenderSelected = true;
            imgMale.setBackgroundResource(R.drawable.selected_border);
            imgFemale.setBackgroundResource(R.drawable.normal_border);
        });

        imgFemale.setOnClickListener(v -> {
            isMaleSelected = false;
            isGenderSelected = true;
            imgFemale.setBackgroundResource(R.drawable.selected_border);
            imgMale.setBackgroundResource(R.drawable.normal_border);
        });

        // Next button logic
        btnNext.setOnClickListener(v -> {
            if (!isGenderSelected) {
                btnNext.setText("Select Gender First!");
                return;
            }

            int age = numberPickerAge.getValue();
            int weight = numberPickerWeight.getValue();

            Intent intent;
            if (isMaleSelected) {
                intent = new Intent(MainActivity.this, HeightSelectMaleActivity.class);
            } else {
                intent = new Intent(MainActivity.this, HeightSelectFemaleActivity.class);
            }

            intent.putExtra("age", age);
            intent.putExtra("weight", weight);
            startActivity(intent);
        });
    }
}
