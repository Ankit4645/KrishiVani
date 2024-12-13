package com.example.mandipriceapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mandi_prices.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;
    private String databasePath;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        databasePath = context.getDatabasePath(DATABASE_NAME).getPath();
        initializeDatabase();
    }

    private void initializeDatabase() {
        if (!new java.io.File(databasePath).exists()) {
            try (InputStream input = context.getAssets().open(DATABASE_NAME);
                 OutputStream output = new FileOutputStream(databasePath)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error copying database", e);
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // You can define SQL schema here if you want to create a new database.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade if needed.
    }
}
