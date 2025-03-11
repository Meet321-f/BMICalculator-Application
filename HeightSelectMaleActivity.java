package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HeightSelectMaleActivity extends AppCompatActivity {

    private int selectedFeet = -1;
    private int selectedInches = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heightselect_male); // Male Layout

        // Find views
        ListView listFeet = findViewById(R.id.listFeet);
        ListView listInches = findViewById(R.id.listInches);
        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);

        // Populate "Feet" list
        String[] feetItems = {"1", "2", "3", "4", "5", "6", "7"};
        ArrayAdapter<String> feetAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                feetItems
        );
        listFeet.setAdapter(feetAdapter);
        listFeet.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Populate "Inches" list
        String[] inchesItems = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        ArrayAdapter<String> inchesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                inchesItems
        );
        listInches.setAdapter(inchesAdapter);
        listInches.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Handle Feet selection
        listFeet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedFeet = Integer.parseInt(feetItems[position]);
            }
        });

        // Handle Inches selection
        listInches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedInches = Integer.parseInt(inchesItems[position]);
            }
        });

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Next button
        btnNext.setOnClickListener(v -> {
            if (selectedFeet == -1 || selectedInches == -1) {
                Toast.makeText(HeightSelectMaleActivity.this, "Please select your height.", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(HeightSelectMaleActivity.this, BMIResultActivity2.class);
                intent.putExtra("feet", selectedFeet);
                intent.putExtra("inches", selectedInches);
                startActivity(intent);
            }
        });
    }
}
