package com.hfab.desalesmessanger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ConversationDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "conversations.db";
    private static final int DB_VERSION = 1;
    Context context;
    MessageDBHelper messageDBHelper = new MessageDBHelper(context);
    LoginDBHelper studentDBHelper = new LoginDBHelper(context);

    public ConversationDBHelper(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        System.out.println(DBContract.ConversationEntry.CREATE_CONVERSATION_TABLE_CMD);
        sqLiteDatabase.execSQL(DBContract.ConversationEntry.CREATE_CONVERSATION_TABLE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL(DBContract.ConversationEntry.DROP_CONVERSATION_TABLE_CMD);
        onCreate(sqLiteDatabase);
    }

    public void saveConversation(int student1ID, int student2ID, int imageID, String timestamp, String lastMessageSent)
    {
        //INSERT INTO message (int conversationId, String person1, String person2)
        //VALUES (, , 'Hey, how are you doing?')
        String insertString = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) " +
                        "VALUES (%d, %d, %d, '%s', '%s')",
                DBContract.ConversationEntry.TABLE_NAME,
                DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                student1ID,
                student2ID,
                imageID,
                timestamp,
                lastMessageSent);

        System.out.println("SAVING: " + insertString);

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertString); //for writing

        db.close();
    }

    public ArrayList<Conversation> fetchAllConversations()
    {
        messageDBHelper.fetchAllMessages();
        studentDBHelper.fetchAllStudents();

        ArrayList<Conversation> allConversations = new ArrayList<>();

        String selectAllString = "SELECT * FROM " + DBContract.ConversationEntry.TABLE_NAME;

        String selectConversationString = "SELECT _id";

        System.out.println("FETCHING all: " + selectAllString);

        SQLiteDatabase db = this.getReadableDatabase();

        //Cursor starts at the -1th position
        Cursor cursor = db.rawQuery(selectAllString, null);

        //Get the position of your columns
        int idPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_ID);
        int student1IDPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_STUDENT_1_ID);
        int student2IDPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_STUDENT_2_ID);
        int imageIDPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_IMAGE_ID);
        int timestampPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_TIMESTAMP);
        int lastMessageSentPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT);



        //Use positions to request the values in the columns
        while (cursor.moveToNext())
        {
            //Get information from current record
            int id = cursor.getInt(idPos);
            int student1ID = cursor.getInt(student1IDPos);
            int student2ID = cursor.getInt(student2IDPos);
            int imageID = cursor.getInt(imageIDPos);
            String timestamp = cursor.getString(timestampPos);
            String lastMessageSent = cursor.getString(lastMessageSentPos);


            allConversations.add(new Conversation(id, student1ID, student2ID, imageID, timestamp, lastMessageSent));
        }

        cursor.close();
        db.close();
        return allConversations;
    }


}
