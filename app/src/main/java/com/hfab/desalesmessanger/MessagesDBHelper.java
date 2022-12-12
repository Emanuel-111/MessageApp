package com.hfab.desalesmessanger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MessagesDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "messages.db";
    private static final int DB_VERSION = 1;

    public MessagesDBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        System.out.println(DBContract.MessageEntry.CREATE_MESSAGE_TABLE_CMD);
        sqLiteDatabase.execSQL(DBContract.MessageEntry.CREATE_MESSAGE_TABLE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(DBContract.MessageEntry.DROP_MESSAGE_TABLE_CMD);
        onCreate(sqLiteDatabase);
    }

    public void saveMessage(long senderID, long recipientID, String senderMessageContents)
    {
        //INSERT INTO message (sender, recipient, contents)
        //VALUES (1249469, 1249123, 'Hey, how are you doing?')
        String insertString = String.format("INSERT INTO %s (%s, %s, %s) " +
                        "VALUES (%d, %d, '%s')",
                DBContract.MessageEntry.TABLE_NAME,
                DBContract.MessageEntry.COLUMN_SENDER,
                DBContract.MessageEntry.COLUMN_RECIPIENT,
                DBContract.MessageEntry.COLUMN_CONTENTS,
                senderID,
                recipientID,
                senderMessageContents);

        System.out.println("SAVING: " + insertString);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertString); //for writing

        db.close();
    }

    public ArrayList<Message> fetchAllMessages()
    {
        ArrayList<Message> allMessages = new ArrayList<>();

        String selectAllString = "SELECT * FROM " + DBContract.MessageEntry.TABLE_NAME;

        System.out.println("FETCHING all: " + selectAllString);

        SQLiteDatabase db = this.getReadableDatabase();

        //Cursor starts at the -1th position
        Cursor cursor = db.rawQuery(selectAllString, null);

        //Get the position of your columns
        int idPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_ID);
        int senderIDPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_SENDER);
        int recipientIDPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_RECIPIENT);
        int contentsPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_CONTENTS);

        //Use positions to request the values in the columns
        while (cursor.moveToNext())
        {
            //Get information from current record
            long id = cursor.getLong(idPos);
            long senderID = cursor.getLong(senderIDPos);
            long recipientID = cursor.getLong(recipientIDPos);
            String contents = cursor.getString(contentsPos);

            allMessages.add(new Message(id, senderID, recipientID, contents));
        }

        cursor.close();
        db.close();
        return allMessages;
    }

}
