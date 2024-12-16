package com.example.mandipriceapp;

import android.content.Context;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {

    private static final String FILE_NAME = "users.csv";
    private final File file;

    public CsvHelper(Context context) {
        file = new File(context.getFilesDir(), FILE_NAME);
        initializeFile();
    }

    // Create file with header if it doesn't exist
    private void initializeFile() {
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.append("Full Name,Email,Password\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Write user data to the file
    public boolean writeUser(String fullName, String email, String password) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.append(fullName).append(",")
                    .append(email).append(",")
                    .append(password).append("\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check if user exists for login
    public boolean isValidUser(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 3 && tokens[1].equals(email) && tokens[2].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check if an email is already registered
    public boolean isEmailRegistered(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 1 && tokens[1].equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
