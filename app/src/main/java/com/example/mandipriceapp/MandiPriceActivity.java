package com.example.mandipriceapp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MandiPriceActivity extends AppCompatActivity {

    Spinner spinnerState, spinnerDistrict, spinnerCommodity;
    Button buttonFetchPrice;
    TextView textViewPrice;
    DatabaseHelper databaseHelper;
    SQLiteDatabase database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandi_price); // Ensure you are using the correct layout file

        spinnerState = findViewById(R.id.spinnerState);
        spinnerDistrict = findViewById(R.id.spinnerDistrict);
        spinnerCommodity = findViewById(R.id.spinnerCommodity);
        buttonFetchPrice = findViewById(R.id.buttonFetchPrice);
        textViewPrice = findViewById(R.id.textViewPrice);

        // Initialize Database
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getReadableDatabase();

        // Load States into Spinner
        loadSpinnerData("state", spinnerState);

        // Set District Spinner based on State selection
        spinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = parent.getItemAtPosition(position).toString();
                loadSpinnerData("district", spinnerDistrict, "state", selectedState);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Set Commodity Spinner based on District selection
        spinnerDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedDistrict = parent.getItemAtPosition(position).toString();
                loadSpinnerData("commodity", spinnerCommodity, "district", selectedDistrict);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Fetch Price Button Click Listener
        buttonFetchPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String state = spinnerState.getSelectedItem().toString();
                String district = spinnerDistrict.getSelectedItem().toString();
                String commodity = spinnerCommodity.getSelectedItem().toString();
                fetchPrice(state, district, commodity);
            }
        });
    }

    // Method to load data into Spinner
    private void loadSpinnerData(String column, Spinner spinner) {
        loadSpinnerData(column, spinner, null, null);
    }

    // Overloaded method to load data into Spinner with filtering
    private void loadSpinnerData(String column, Spinner spinner, String filterColumn, String filterValue) {
        ArrayList<String> data = new ArrayList<>();
        Cursor cursor;

        if (filterColumn != null && filterValue != null) {
            cursor = database.query(true, "mandi_prices", new String[]{column},
                    filterColumn + " = ?", new String[]{filterValue},
                    null, null, column, null);
        } else {
            cursor = database.query(true, "mandi_prices", new String[]{column},
                    null, null, null, null, column, null);
        }

        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    // Method to fetch price
    private void fetchPrice(String state, String district, String commodity) {
        Cursor cursor = database.query("mandi_prices", new String[]{"modal_price"},
                "state = ? AND district = ? AND commodity = ?",
                new String[]{state, district, commodity}, null, null, null);
        if (cursor.moveToFirst()) {
            double price = cursor.getDouble(0);
            textViewPrice.setText("Price: ₹" + price);
        } else {
            textViewPrice.setText("Price not available.");
        }
        cursor.close();
    }
}
