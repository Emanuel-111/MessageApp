package com.hfab.desalesmessanger;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Emanuel Luna, Joseph Traglia, and Wyatt Giberson
 */
public class MainActivity extends AppCompatActivity {

    public static DBHelper.LoginDBHelper loginDBHelper;
    public static DBHelper.ConversationDBHelper convDBHelper;
    public static DBHelper.MessageDBHelper messageDBHelper;

    private SharedPreferences sharedPreferences;

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

        loginDBHelper = new DBHelper.LoginDBHelper(this);
        convDBHelper = new DBHelper.ConversationDBHelper(this);
        messageDBHelper = new DBHelper.MessageDBHelper(this);

        // sharedPreferences should allow users to change the background color
        sharedPreferences = getSharedPreferences("fragment_settings.xml", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("bg_color", R.color.white);
        editor.apply();


    }


}