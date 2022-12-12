package com.hfab.desalesmessanger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConversationDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "conversation.db";
    public static final int DB_VERSION = 1;

    public ConversationDBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
