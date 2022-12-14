package com.hfab.desalesmessanger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper {

    /**
     *
     */
    static class LoginDBHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "logins.db";
        private static final int DB_VERSION = 1;

        public LoginDBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            System.out.println(DBContract.LoginEntry.CREATE_LOGIN_TABLE_CMD);
            sqLiteDatabase.execSQL(DBContract.LoginEntry.CREATE_LOGIN_TABLE_CMD);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DBContract.LoginEntry.DROP_LOGIN_TABLE_CMD);
            onCreate(sqLiteDatabase);
        }

        public void saveLogin(String studentName, String emailAddress, String password) {
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

        public void updateSqlLogins() {
            String updateString1 = String.format("UPDATE %s \n" +
                            "SET %s = %d,\n" +
                            "WHERE %s = '%s';",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    1,
                    DBContract.LoginEntry.COLUMN_NAME,
                    "Joseph Traglia");

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(updateString1); //for writing

            db.close();
        }

        public void deleteSqlLogins() {
            String deleteString1 = String.format("DELETE FROM %s \n" +
                            "WHERE %s = %d;",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    29);

            String deleteString2 = String.format("DELETE FROM %s \n" +
                            "WHERE %s = %d;",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    30);

            String deleteString3 = String.format("DELETE FROM %s \n" +
                            "WHERE %s = %d;",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    31);

            String deleteString4 = String.format("DELETE FROM %s \n" +
                            "WHERE %s = %d;",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    32);

            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL(deleteString1);
            db.execSQL(deleteString2);
            db.execSQL(deleteString3);
            db.execSQL(deleteString4);

            db.close();
        }


        public void callSqlLogins() {
            //INSERT INTO student (studentName, emailAddress, password)
            //VALUES ('Joseph Traglia', 'jt9469@desales.edu', 'Desales12345')


            String insertString1 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', '%s')",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    DBContract.LoginEntry.COLUMN_NAME,
                    DBContract.LoginEntry.COLUMN_EMAIL,
                    DBContract.LoginEntry.COLUMN_PASSWORD,
                    1,
                    "Joseph Traglia",
                    "jt9469@desales.edu",
                    "12345");

            String insertString2 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', '%s')",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    DBContract.LoginEntry.COLUMN_NAME,
                    DBContract.LoginEntry.COLUMN_EMAIL,
                    DBContract.LoginEntry.COLUMN_PASSWORD,
                    2,
                    "Emanuel Luna",
                    "el7027273@desales.edu",
                    "12345");

            String insertString3 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', '%s')",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    DBContract.LoginEntry.COLUMN_NAME,
                    DBContract.LoginEntry.COLUMN_EMAIL,
                    DBContract.LoginEntry.COLUMN_PASSWORD,
                    3,
                    "Wyatt Giberson",
                    "wg4655@desales.edu",
                    "12345");

            String insertString4 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', '%s')",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    DBContract.LoginEntry.COLUMN_NAME,
                    DBContract.LoginEntry.COLUMN_EMAIL,
                    DBContract.LoginEntry.COLUMN_PASSWORD,
                    4,
                    "Luke Cossmann",
                    "lc2027@desales.edu",
                    "12345");

            String insertString5 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', '%s')",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    DBContract.LoginEntry.COLUMN_NAME,
                    DBContract.LoginEntry.COLUMN_EMAIL,
                    DBContract.LoginEntry.COLUMN_PASSWORD,
                    5,
                    "Austin Weaver",
                    "aw3335@desales.edu",
                    "12345");


            String insertString6 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', '%s')",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    DBContract.LoginEntry.COLUMN_NAME,
                    DBContract.LoginEntry.COLUMN_EMAIL,
                    DBContract.LoginEntry.COLUMN_PASSWORD,
                    6,
                    "Natalie Arner",
                    "na8354@desales.edu",
                    "12345");


            String insertString7 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', '%s')",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    DBContract.LoginEntry.COLUMN_NAME,
                    DBContract.LoginEntry.COLUMN_EMAIL,
                    DBContract.LoginEntry.COLUMN_PASSWORD,
                    7,
                    "Angel Negron",
                    "an0807@desales.edu",
                    "12345");

            String insertString8 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', '%s')",
                    DBContract.LoginEntry.TABLE_NAME,
                    DBContract.LoginEntry.COLUMN_ID,
                    DBContract.LoginEntry.COLUMN_NAME,
                    DBContract.LoginEntry.COLUMN_EMAIL,
                    DBContract.LoginEntry.COLUMN_PASSWORD,
                    8,
                    "Samantha Rindgen",
                    "sr9123@desales.edu",
                    "12345");

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(insertString1); //for writing
            db.execSQL(insertString2);
            db.execSQL(insertString3);
            db.execSQL(insertString4);
            db.execSQL(insertString5);
            db.execSQL(insertString6);
            db.execSQL(insertString7);
            db.execSQL(insertString8);

            db.close();
        }

        public ArrayList<Login> fetchAllStudents() {
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
            while (cursor.moveToNext()) {
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

    /**
     *
     */
    static class MessageDBHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "messages.db";
        private static final int DB_VERSION = 1;

        public MessageDBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            System.out.println(DBContract.MessageEntry.CREATE_MESSAGE_TABLE_CMD);
            sqLiteDatabase.execSQL(DBContract.MessageEntry.CREATE_MESSAGE_TABLE_CMD);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DBContract.MessageEntry.DROP_MESSAGE_TABLE_CMD);
            onCreate(sqLiteDatabase);
        }

        public void saveMessage(int id, int conversationID, String contents, String timestamp, int senderID) {
            //INSERT INTO message (sender, recipient, contents)
            //VALUES (1249469, 1249123, 'Hey, how are you doing?')
            String insertString = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_ID,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    id,
                    conversationID,
                    contents,
                    timestamp,
                    senderID);

            System.out.println("SAVING: " + insertString);

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(insertString); //for writing

            db.close();
        }

        public ArrayList<Message> fetchAllMessages() {
            ArrayList<Message> allMessages = new ArrayList<>();

            String selectAllString = "SELECT * FROM " + DBContract.MessageEntry.TABLE_NAME;

            System.out.println("FETCHING all: " + selectAllString);

            SQLiteDatabase db = this.getReadableDatabase();

            //Cursor starts at the -1th position
            Cursor cursor = db.rawQuery(selectAllString, null);

            //Get the position of your columns
            int idPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_ID);
            int conversationIDPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_CONVERSATION_ID);
            int contentsPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_CONTENTS);
            int timestampPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_TIMESTAMP);
            int senderIDPos = cursor.getColumnIndex(DBContract.MessageEntry.COLUMN_SENDER_ID);


            //Use positions to request the values in the columns
            while (cursor.moveToNext()) {
                //Get information from current record
                int id = cursor.getInt(idPos);
                int conversationID = cursor.getInt(conversationIDPos);
                String contents = cursor.getString(contentsPos);
                String timestamp = cursor.getString(timestampPos);
                int senderID = cursor.getInt(senderIDPos);

                allMessages.add(new Message(id, conversationID, contents, timestamp, senderID));
            }

            cursor.close();
            db.close();
            return allMessages;
        }

        public void addMessage()
        {
            int data = 1;
            int data2 = 2;
            String data1 = data + "0000" + 2;


            String insertMessageString1 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_ID,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    1,
                    10002,
                    "Hi Manny",
                    "10:00",
                    0);

            String insertMessageString2 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_ID,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    2,
                    10002,
                    "How are you?",
                    "10:01",
                    0);

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(insertMessageString1);
            db.execSQL(insertMessageString2);

            db.close();

        }

    }

    /**
     *
     */
    static class ConversationDBHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "conversations.db";
        private static final int DB_VERSION = 1;
        Context context;
        DBHelper.MessageDBHelper messageDBHelper = new DBHelper.MessageDBHelper(context);
        DBHelper.LoginDBHelper studentDBHelper = new DBHelper.LoginDBHelper(context);

        public ConversationDBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            System.out.println(DBContract.ConversationEntry.CREATE_CONVERSATION_TABLE_CMD);
            sqLiteDatabase.execSQL(DBContract.ConversationEntry.CREATE_CONVERSATION_TABLE_CMD);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DBContract.ConversationEntry.DROP_CONVERSATION_TABLE_CMD);
            onCreate(sqLiteDatabase);
        }

        public void saveConversation(int student1ID, int student2ID, int imageID, String timestamp, String lastMessageSent) {
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

        public ArrayList<Conversation> fetchAllConversations() {
//            messageDBHelper.fetchAllMessages();
//            studentDBHelper.fetchAllStudents();

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
            while (cursor.moveToNext()) {
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

        public void insertConversation()
        {
            String insertConversationString1 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    1,
                    2,
                    700002,
                    "10:01",
                    "How are you?");

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(insertConversationString1);

            db.close();
        }


    }

}
