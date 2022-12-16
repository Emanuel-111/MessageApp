package com.hfab.desalesmessanger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Emanuel Luna, Joseph Traglia, and Wyatt Giberson
 */
public class MainActivity extends AppCompatActivity {


    /**
     * onCreate - allows the navigation graph to be used for the entire application.
     * It also allows for personal options for a background when the user logs on to
     * their account.
     *
     * @param savedInstanceState - savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sharedPreferences should allow users to change the background color
        SharedPreferences sharedPreferences = getSharedPreferences("fragment_settings.xml", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("bg_color", R.color.white);
        editor.apply();


    }
}