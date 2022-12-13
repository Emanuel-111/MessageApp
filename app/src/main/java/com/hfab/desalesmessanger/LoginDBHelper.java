package com.hfab.desalesmessanger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class LoginDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "logins.db";
    private static final int DB_VERSION = 1;

    public LoginDBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        System.out.println(DBContract.LoginEntry.CREATE_LOGIN_TABLE_CMD);
        sqLiteDatabase.execSQL(DBContract.LoginEntry.CREATE_LOGIN_TABLE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(DBContract.LoginEntry.DROP_LOGIN_TABLE_CMD);
        onCreate(sqLiteDatabase);
    }

    public void saveLogin(String studentName, String emailAddress, String password)
    {
        //INSERT INTO student (student ID, name, email, password)
        // VALUES (1249469, 'Joseph Traglia', 'jt9469@desales.edu', 'Desales12345')
        String insertString = String.format("INSERT INTO %s (%s, %s, %s) " +
                        "VALUES (%d, '%s', '%s', '%s')",
                DBContract.LoginEntry.TABLE_NAME,
                DBContract.LoginEntry.COLUMN_NAME,
                DBContract.LoginEntry.COLUMN_EMAIL,
                DBContract.LoginEntry.COLUMN_PASSWORD,
                studentName,
                emailAddress,
                password);

        System.out.println("SAVING: " + insertString);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertString); //for writing

        db.close();
    }

    public ArrayList<Login> fetchAllStudents()
    {
        ArrayList<Login> allStudents = new ArrayList<Login>();

        String selectAllString = "SELECT * FROM " + DBContract.LoginEntry.TABLE_NAME;

        System.out.println("FETCHING all: " + selectAllString);

        SQLiteDatabase db = this.getReadableDatabase();

        //Cursor starts at the -1th position
        Cursor cursor = db.rawQuery(selectAllString, null);

        //Get the position of your columns
        int idPos = cursor.getColumnIndex(DBContract.LoginEntry.COLUMN_ID);
        int namePos = cursor.getColumnIndex(DBContract.LoginEntry.COLUMN_NAME);
        int emailPos = cursor.getColumnIndex(DBContract.LoginEntry.COLUMN_EMAIL);
        int passwordPos = cursor.getColumnIndex(DBContract.LoginEntry.COLUMN_PASSWORD);

        //Use positions to request the values in the columns
        while (cursor.moveToNext())
        {
            //Get information from current record
            int id = cursor.getInt(idPos);
            String name = cursor.getString(namePos);
            String email = cursor.getString(emailPos);
            String password = cursor.getString(passwordPos);

            allStudents.add(new Login(id, name, email, password));
        }

        cursor.close();
        db.close();
        return allStudents;
    }
}
