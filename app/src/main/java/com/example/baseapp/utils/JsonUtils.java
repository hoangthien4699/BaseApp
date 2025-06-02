package com.example.baseapp.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JsonUtils {

    public static String loadJSONFromAsset(Context context, String fileName) {
        StringBuilder json = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(context.getAssets().open(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}

