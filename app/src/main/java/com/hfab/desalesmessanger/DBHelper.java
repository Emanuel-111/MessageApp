package com.hfab.desalesmessanger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * DBHelper.java
 * This class represents the messenger app's database helper for inserting, updating,
 * and deleting various SQL queries within the program.
 *
 * @author Joseph Traglia
 */
public class DBHelper {

    /**
     * LoginDBHelper
     * This class represents the messenger app's login database helper for inserting, updating,
     * and deleting various SQL queries within the program.
     *
     * @author Joseph Traglia
     */
    static class LoginDBHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "logins.db";
        private static final int DB_VERSION = 1;

        /**
         * LoginDBHelper
         * This constructor is utilized for the LoginDBHelper class.
         *
         * @param context Context for the LoginDBHelper.
         */
        public LoginDBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        /**
         * onCreate
         * This method creates the SQLite database.
         *
         * @param sqLiteDatabase Database table being created.
         */
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            System.out.println(DBContract.LoginEntry.CREATE_LOGIN_TABLE_CMD);
            sqLiteDatabase.execSQL(DBContract.LoginEntry.CREATE_LOGIN_TABLE_CMD);
        }

        /**
         * onUpgrade
         * This method drops the SQLite database.
         *
         * @param sqLiteDatabase Database table being dropped.
         * @param i              First cursor location.
         * @param i1             Second cursor location.
         */
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DBContract.LoginEntry.DROP_LOGIN_TABLE_CMD);
            onCreate(sqLiteDatabase);
        }

        /**
         * saveLogin
         * This method saves the logins for each student in the SQLite database.
         *
         * @param studentName  The Student's name.
         * @param emailAddress The Student's email address.
         * @param password     The Student's password.
         */
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

        /**
         * updateSqlLogins
         * This method updates a students information within the SQLite database.
         */
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

        /**
         * deleteSqlLogins
         * This method deletes a students information within the SQLite database.
         */
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

        /**
         * callSqlLogins
         * This method inserts various students into the SQLite database
         * via SQL queries.
         */
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

        /**
         * fetchAllStudents
         * This method obtains all students currently located within the SQLite database by
         * utilizing a cursor to get their attributes' position within a column.
         *
         * @return An ArrayList of Student objects.
         */
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
     * MessageDBHelper
     * This class represents the messenger app's message database helper for inserting
     * message into the SQLite database.
     *
     * @author Joseph Traglia
     */
    static class MessageDBHelper extends SQLiteOpenHelper {

        private static final String DB_NAME = "messages.db";
        private static final int DB_VERSION = 1;

        /**
         * MessageDBHelper
         * This constructor is utilized for the MessageDBHelper class.
         *
         * @param context Context for the LoginDBHelper.
         */
        public MessageDBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        /**
         * onCreate
         * This method creates the SQLite database.
         *
         * @param sqLiteDatabase Database table being created.
         */
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            System.out.println(DBContract.MessageEntry.CREATE_MESSAGE_TABLE_CMD);
            sqLiteDatabase.execSQL(DBContract.MessageEntry.CREATE_MESSAGE_TABLE_CMD);
        }

        /**
         * onUpgrade
         * This method drops the SQLite database.
         *
         * @param sqLiteDatabase Database table being dropped.
         * @param i              First cursor location.
         * @param i1             Second cursor location.
         */
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DBContract.MessageEntry.DROP_MESSAGE_TABLE_CMD);
            onCreate(sqLiteDatabase);
        }

        /**
         * saveMessage
         * This method inserts a student's message into the SQLite database.
         *
         * @param id             The Message's ID.
         * @param conversationID The conversation the Message belongs to.
         * @param contents       The contents of the Message.
         * @param timestamp      The timestamp of the Message.
         * @param senderID       The Message sender's ID.
         */
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

        /**
         * fetchAllMessages
         * This method obtains all messages currently located within the SQLite database by
         * utilizing a cursor to get their attributes' position within a column.
         *
         * @return An ArrayList of Message objects.
         */
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

        /**
         * addMessage
         * This method adds a message to the SQLite database via SQL queries.
         */
        public void addMessage() {

            String insertMessageString1 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10002,
                    "Hello Emanuel",
                    "10:01",
                    0);

            String insertMessageString2 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10002,
                    "How are you?",
                    "10:02",
                    1);

            String insertMessageString3 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10003,
                    "Hello Wyatt",
                    "10:03",
                    0);

            String insertMessageString4 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10003,
                    "How are you?",
                    "10:04",
                    1);

            String insertMessageString5 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10004,
                    "Hello Luke",
                    "10:05",
                    0);

            String insertMessageString6 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10004,
                    "How are you?",
                    "10:06",
                    1);

            String insertMessageString7 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10005,
                    "Hello Austin",
                    "10:07",
                    0);

            String insertMessageString8 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10005,
                    "How are you?",
                    "10:08",
                    1);

            String insertMessageString9 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10006,
                    "Hello Natalie",
                    "10:09",
                    0);

            String insertMessageString10 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10006,
                    "How are you?",
                    "10:10",
                    1);

            String insertMessageString11 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10007,
                    "Hello Angel",
                    "10:11",
                    0);

            String insertMessageString12 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10007,
                    "How are you?",
                    "10:12",
                    1);

            String insertMessageString13 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10008,
                    "Hello Samantha",
                    "10:13",
                    0);

            String insertMessageString14 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    10008,
                    "How are you?",
                    "10:14",
                    1);

            String insertMessageString15 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20001,
                    "Hello Joseph",
                    "10:15",
                    0);

            String insertMessageString16 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20001,
                    "How are you?",
                    "10:16",
                    1);

            String insertMessageString17 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20003,
                    "Hello Wyatt",
                    "10:17",
                    0);

            String insertMessageString18 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20003,
                    "How are you?",
                    "10:18",
                    1);

            String insertMessageString19 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20004,
                    "Hello Luke",
                    "10:19",
                    0);

            String insertMessageString20 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20004,
                    "How are you?",
                    "10:20",
                    1);

            String insertMessageString21 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20005,
                    "Hello Austin",
                    "10:21",
                    0);

            String insertMessageString22 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20005,
                    "How are you?",
                    "10:22",
                    1);

            String insertMessageString23 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20006,
                    "Hello Natalie",
                    "10:23",
                    0);

            String insertMessageString24 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20006,
                    "How are you?",
                    "10:24",
                    1);

            String insertMessageString25 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20007,
                    "Hello Angel",
                    "10:25",
                    0);

            String insertMessageString26 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20007,
                    "How are you?",
                    "10:26",
                    1);

            String insertMessageString27 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20008,
                    "Hello Samantha",
                    "10:27",
                    0);

            String insertMessageString28 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    20008,
                    "How are you?",
                    "10:28",
                    1);

            String insertMessageString29 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30001,
                    "Hello Joseph",
                    "10:29",
                    0);

            String insertMessageString30 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30001,
                    "How are you?",
                    "10:30",
                    1);

            String insertMessageString31 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30002,
                    "Hello Emanuel",
                    "10:31",
                    0);

            String insertMessageString32 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30002,
                    "How are you?",
                    "10:32",
                    1);

            String insertMessageString33 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30004,
                    "Hello Luke",
                    "10:33",
                    0);

            String insertMessageString34 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30004,
                    "How are you?",
                    "10:34",
                    1);

            String insertMessageString35 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30005,
                    "Hello Austin",
                    "10:35",
                    0);

            String insertMessageString36 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30005,
                    "How are you?",
                    "10:36",
                    1);

            String insertMessageString37 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30006,
                    "Hello Natalie",
                    "10:37",
                    0);

            String insertMessageString38 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30006,
                    "How are you?",
                    "10:38",
                    1);

            String insertMessageString39 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30007,
                    "Hello Angel",
                    "10:39",
                    0);

            String insertMessageString40 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30007,
                    "How are you?",
                    "10:40",
                    1);

            String insertMessageString41 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30008,
                    "Hello Samantha",
                    "10:41",
                    0);

            String insertMessageString42 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    30008,
                    "How are you?",
                    "10:42",
                    1);

            String insertMessageString43 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40001,
                    "Hello Joseph",
                    "10:43",
                    0);

            String insertMessageString44 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40001,
                    "How are you?",
                    "10:44",
                    1);

            String insertMessageString45 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40002,
                    "Hello Emanuel",
                    "10:45",
                    0);

            String insertMessageString46 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40002,
                    "How are you?",
                    "10:46",
                    1);

            String insertMessageString47 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40003,
                    "Hello Wyatt",
                    "10:47",
                    0);

            String insertMessageString48 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40003,
                    "How are you?",
                    "10:48",
                    1);

            String insertMessageString49 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40005,
                    "Hello Austin",
                    "10:49",
                    0);

            String insertMessageString50 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40005,
                    "How are you?",
                    "10:50",
                    1);

            String insertMessageString51 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40006,
                    "Hello Natalie",
                    "10:51",
                    0);

            String insertMessageString52 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40006,
                    "How are you?",
                    "10:52",
                    1);

            String insertMessageString53 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40007,
                    "Hello Angel",
                    "10:53",
                    0);

            String insertMessageString54 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40007,
                    "How are you?",
                    "10:54",
                    1);

            String insertMessageString55 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40008,
                    "Hello Samantha",
                    "10:55",
                    0);

            String insertMessageString56 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    40008,
                    "How are you?",
                    "10:56",
                    1);

            String insertMessageString57 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50001,
                    "Hello Joseph",
                    "10:57",
                    0);

            String insertMessageString58 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50001,
                    "How are you?",
                    "10:58",
                    1);

            String insertMessageString59 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50002,
                    "Hello Emanuel",
                    "10:59",
                    0);

            String insertMessageString60 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50002,
                    "How are you?",
                    "11:00",
                    1);

            String insertMessageString61 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50003,
                    "Hello Wyatt",
                    "11:01",
                    0);

            String insertMessageString62 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50003,
                    "How are you?",
                    "11:02",
                    1);

            String insertMessageString63 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50004,
                    "Hello Luke",
                    "11:03",
                    0);

            String insertMessageString64 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50004,
                    "How are you?",
                    "11:04",
                    1);

            String insertMessageString65 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50006,
                    "Hello Natalie",
                    "11:05",
                    0);

            String insertMessageString66 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50006,
                    "How are you?",
                    "11:06",
                    1);

            String insertMessageString67 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50007,
                    "Hello Angel",
                    "11:07",
                    0);

            String insertMessageString68 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50007,
                    "How are you?",
                    "11:08",
                    1);

            String insertMessageString69 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50008,
                    "Hello Samantha",
                    "11:09",
                    0);

            String insertMessageString70 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    50008,
                    "How are you?",
                    "11:10",
                    1);

            String insertMessageString71 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60001,
                    "Hello Joseph",
                    "11:11",
                    0);

            String insertMessageString72 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60001,
                    "How are you?",
                    "11:12",
                    1);

            String insertMessageString73 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60002,
                    "Hello Emanuel",
                    "11:13",
                    0);

            String insertMessageString74 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60002,
                    "How are you?",
                    "11:14",
                    1);

            String insertMessageString75 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60003,
                    "Hello Wyatt",
                    "11:15",
                    0);

            String insertMessageString76 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60003,
                    "How are you?",
                    "11:16",
                    1);

            String insertMessageString77 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60004,
                    "Hello Luke",
                    "11:17",
                    0);

            String insertMessageString78 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60004,
                    "How are you?",
                    "11:18",
                    1);

            String insertMessageString79 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60005,
                    "Hello Austin",
                    "11:19",
                    0);

            String insertMessageString80 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60005,
                    "How are you?",
                    "11:20",
                    1);

            String insertMessageString81 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60007,
                    "Hello Angel",
                    "11:21",
                    0);

            String insertMessageString82 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60007,
                    "How are you?",
                    "11:22",
                    1);

            String insertMessageString83 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60008,
                    "Hello Samantha",
                    "11:23",
                    0);

            String insertMessageString84 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    60008,
                    "How are you?",
                    "11:24",
                    1);

            String insertMessageString85 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70001,
                    "Hello Joseph",
                    "11:25",
                    0);

            String insertMessageString86 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70001,
                    "How are you?",
                    "11:26",
                    1);

            String insertMessageString87 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70002,
                    "Hello Emanuel",
                    "11:27",
                    0);

            String insertMessageString88 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70002,
                    "How are you?",
                    "11:28",
                    1);

            String insertMessageString89 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70003,
                    "Hello Wyatt",
                    "11:29",
                    0);

            String insertMessageString90 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70003,
                    "How are you?",
                    "11:30",
                    1);

            String insertMessageString91 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70004,
                    "Hello Luke",
                    "11:31",
                    0);

            String insertMessageString92 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70004,
                    "How are you?",
                    "11:32",
                    1);

            String insertMessageString93 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70005,
                    "Hello Austin",
                    "11:33",
                    0);

            String insertMessageString94 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70005,
                    "How are you?",
                    "11:34",
                    1);

            String insertMessageString95 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70006,
                    "Hello Natalie",
                    "11:35",
                    0);

            String insertMessageString96 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70006,
                    "How are you?",
                    "11:36",
                    1);

            String insertMessageString97 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70008,
                    "Hello Samantha",
                    "11:37",
                    0);

            String insertMessageString98 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    70008,
                    "How are you?",
                    "11:38",
                    1);

            String insertMessageString99 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80001,
                    "Hello Joseph",
                    "11:39",
                    0);

            String insertMessageString100 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80001,
                    "How are you?",
                    "11:40",
                    1);

            String insertMessageString101 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80002,
                    "Hello Emanuel",
                    "11:41",
                    0);

            String insertMessageString102 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80002,
                    "How are you?",
                    "11:42",
                    1);

            String insertMessageString103 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80003,
                    "Hello Wyatt",
                    "11:43",
                    0);

            String insertMessageString104 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80003,
                    "How are you?",
                    "11:44",
                    1);

            String insertMessageString105 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80004,
                    "Hello Luke",
                    "11:45",
                    0);

            String insertMessageString106 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80004,
                    "How are you?",
                    "11:46",
                    1);

            String insertMessageString107 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80005,
                    "Hello Austin",
                    "11:47",
                    0);

            String insertMessageString108 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80005,
                    "How are you?",
                    "11:48",
                    1);

            String insertMessageString109 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80006,
                    "Hello Natalie",
                    "11:49",
                    0);

            String insertMessageString110 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80006,
                    "How are you?",
                    "11:50",
                    1);

            String insertMessageString111 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80007,
                    "Hello Angel",
                    "11:51",
                    0);

            String insertMessageString112 = String.format("INSERT INTO %s (%s, %s, %s, %s) " +
                            "VALUES (%d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    80007,
                    "How are you?",
                    "11:52",
                    1);

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(insertMessageString1);
            db.execSQL(insertMessageString2);
            db.execSQL(insertMessageString3);
            db.execSQL(insertMessageString4);
            db.execSQL(insertMessageString5);
            db.execSQL(insertMessageString6);
            db.execSQL(insertMessageString7);
            db.execSQL(insertMessageString8);
            db.execSQL(insertMessageString9);
            db.execSQL(insertMessageString10);
            db.execSQL(insertMessageString11);
            db.execSQL(insertMessageString12);
            db.execSQL(insertMessageString13);
            db.execSQL(insertMessageString14);
            db.execSQL(insertMessageString15);
            db.execSQL(insertMessageString16);
            db.execSQL(insertMessageString17);
            db.execSQL(insertMessageString18);
            db.execSQL(insertMessageString19);
            db.execSQL(insertMessageString20);
            db.execSQL(insertMessageString21);
            db.execSQL(insertMessageString20);
            db.execSQL(insertMessageString22);
            db.execSQL(insertMessageString23);
            db.execSQL(insertMessageString24);
            db.execSQL(insertMessageString25);
            db.execSQL(insertMessageString26);
            db.execSQL(insertMessageString27);
            db.execSQL(insertMessageString28);
            db.execSQL(insertMessageString29);
            db.execSQL(insertMessageString30);
            db.execSQL(insertMessageString31);
            db.execSQL(insertMessageString32);
            db.execSQL(insertMessageString33);
            db.execSQL(insertMessageString34);
            db.execSQL(insertMessageString35);
            db.execSQL(insertMessageString36);
            db.execSQL(insertMessageString37);
            db.execSQL(insertMessageString38);
            db.execSQL(insertMessageString39);
            db.execSQL(insertMessageString40);
            db.execSQL(insertMessageString41);
            db.execSQL(insertMessageString42);
            db.execSQL(insertMessageString43);
            db.execSQL(insertMessageString44);
            db.execSQL(insertMessageString45);
            db.execSQL(insertMessageString46);
            db.execSQL(insertMessageString47);
            db.execSQL(insertMessageString48);
            db.execSQL(insertMessageString49);
            db.execSQL(insertMessageString50);
            db.execSQL(insertMessageString51);
            db.execSQL(insertMessageString52);
            db.execSQL(insertMessageString53);
            db.execSQL(insertMessageString54);
            db.execSQL(insertMessageString55);
            db.execSQL(insertMessageString56);
            db.execSQL(insertMessageString57);
            db.execSQL(insertMessageString58);
            db.execSQL(insertMessageString59);
            db.execSQL(insertMessageString60);
            db.execSQL(insertMessageString61);
            db.execSQL(insertMessageString62);
            db.execSQL(insertMessageString63);
            db.execSQL(insertMessageString64);
            db.execSQL(insertMessageString65);
            db.execSQL(insertMessageString66);
            db.execSQL(insertMessageString67);
            db.execSQL(insertMessageString68);
            db.execSQL(insertMessageString69);
            db.execSQL(insertMessageString70);
            db.execSQL(insertMessageString71);
            db.execSQL(insertMessageString72);
            db.execSQL(insertMessageString73);
            db.execSQL(insertMessageString74);
            db.execSQL(insertMessageString75);
            db.execSQL(insertMessageString76);
            db.execSQL(insertMessageString77);
            db.execSQL(insertMessageString78);
            db.execSQL(insertMessageString79);
            db.execSQL(insertMessageString80);
            db.execSQL(insertMessageString81);
            db.execSQL(insertMessageString82);
            db.execSQL(insertMessageString83);
            db.execSQL(insertMessageString84);
            db.execSQL(insertMessageString85);
            db.execSQL(insertMessageString86);
            db.execSQL(insertMessageString87);
            db.execSQL(insertMessageString88);
            db.execSQL(insertMessageString89);
            db.execSQL(insertMessageString90);
            db.execSQL(insertMessageString91);
            db.execSQL(insertMessageString92);
            db.execSQL(insertMessageString93);
            db.execSQL(insertMessageString94);
            db.execSQL(insertMessageString95);
            db.execSQL(insertMessageString96);
            db.execSQL(insertMessageString97);
            db.execSQL(insertMessageString98);
            db.execSQL(insertMessageString99);
            db.execSQL(insertMessageString100);
            db.execSQL(insertMessageString101);
            db.execSQL(insertMessageString102);
            db.execSQL(insertMessageString103);
            db.execSQL(insertMessageString104);
            db.execSQL(insertMessageString105);
            db.execSQL(insertMessageString106);
            db.execSQL(insertMessageString107);
            db.execSQL(insertMessageString108);
            db.execSQL(insertMessageString109);
            db.execSQL(insertMessageString110);
            db.execSQL(insertMessageString111);
            db.execSQL(insertMessageString112);

            db.close();

        }

        /**
         * addMessageWithInfo
         * This method adds information to a pre-existing message with the SQLite database.
         *
         * @param pos    The Message's position within the database.
         * @param convId The Message's conversation ID.
         * @param cont   The Message's contents.
         * @param ts     The Message's timestamp.
         * @param type   The Message's type.
         */
        public void addMessagewithInfo(int pos, int convId, String cont, String ts, int type) {
            String insertMessageString1 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, '%s', '%s', %d)",
                    DBContract.MessageEntry.TABLE_NAME,
                    DBContract.MessageEntry.COLUMN_ID,
                    DBContract.MessageEntry.COLUMN_CONVERSATION_ID,
                    DBContract.MessageEntry.COLUMN_CONTENTS,
                    DBContract.MessageEntry.COLUMN_TIMESTAMP,
                    DBContract.MessageEntry.COLUMN_SENDER_ID,
                    pos,
                    convId,
                    cont,
                    ts,
                    type);

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(insertMessageString1);

            db.close();

        }


    }

    /**
     * MessageDBHelper
     * This class represents the messenger app's message database helper for inserting
     * messages into the SQLite database.
     *
     * @author Joseph Traglia
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

        /**
         * onCreate
         * This method creates the SQLite database.
         *
         * @param sqLiteDatabase Database being created.
         */
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            System.out.println(DBContract.ConversationEntry.CREATE_CONVERSATION_TABLE_CMD);
            sqLiteDatabase.execSQL(DBContract.ConversationEntry.CREATE_CONVERSATION_TABLE_CMD);
        }

        /**
         * onUpgrade
         * This method drops the SQLite database.
         *
         * @param sqLiteDatabase Database being dropped.
         * @param i              First cursor location.
         * @param i1             Second cursor location.
         */
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DBContract.ConversationEntry.DROP_CONVERSATION_TABLE_CMD);
            onCreate(sqLiteDatabase);
        }

        /**
         * saveConversation
         * This method inserts a conversation into the SQLite database.
         *
         * @param conversationID  A Conversation's ID.
         * @param student1ID      The first student in the Conversation.
         * @param student2ID      The second student in the Conversation.
         * @param imageID         The image ID of the recipient within the Conversation.
         * @param timestamp       The time the last message was sent within the Conversation.
         * @param lastMessageSent The contents of the last message sent within the Conversation.
         */
        public void saveConversation(int conversationID, int student1ID, int student2ID, int imageID, String timestamp, String lastMessageSent) {
            //INSERT INTO message (int conversationId, String person1, String person2)
            //VALUES (, , 'Hey, how are you doing?')
            String insertString = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    conversationID,
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

        /**
         * fetchAllConversations
         * This method obtains all conversations currently located within the SQLite database by
         * utilizing a cursor to get their attributes' position within a column.
         *
         * @return An ArrayList of Student objects.
         */
        public ArrayList<Conversation> fetchAllConversations() {

            ArrayList<Conversation> allConversations = new ArrayList<>();

            String selectAllString = "SELECT * FROM " + DBContract.ConversationEntry.TABLE_NAME;

            System.out.println("FETCHING all: " + selectAllString);

            SQLiteDatabase db = this.getReadableDatabase();

            //Cursor starts at the -1th position
            Cursor cursor = db.rawQuery(selectAllString, null);

            //Get the position of your columns
            int idPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_ID);
            int conversationIDPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_CONVERSATION_ID);
            int student1IDPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_STUDENT_1_ID);
            int student2IDPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_STUDENT_2_ID);
            int imageIDPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_IMAGE_ID);
            int timestampPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_TIMESTAMP);
            int lastMessageSentPos = cursor.getColumnIndex(DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT);


            //Use positions to request the values in the columns
            while (cursor.moveToNext()) {
                //Get information from current record
                int id = cursor.getInt(idPos);
                int conversationID = cursor.getInt(conversationIDPos);
                int student1ID = cursor.getInt(student1IDPos);
                int student2ID = cursor.getInt(student2IDPos);
                int imageID = cursor.getInt(imageIDPos);
                String timestamp = cursor.getString(timestampPos);
                String lastMessageSent = cursor.getString(lastMessageSentPos);


                allConversations.add(new Conversation(id, conversationID, student1ID, student2ID, imageID, timestamp, lastMessageSent));
            }

            cursor.close();
            db.close();
            return allConversations;
        }

        /**
         * insertConversation
         * This method inserts a conversation into the SQLite database via SQL queries.
         */
        public void insertConversation() {

            String insertConversationString1 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    10002,
                    1,
                    2,
                    700002,
                    "10:01",
                    "How are you?");

            String insertConversationString2 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    10003,
                    1,
                    3,
                    700002,
                    "10:02",
                    "How are you?");

            String insertConversationString3 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    10004,
                    1,
                    4,
                    700002,
                    "10:03",
                    "How are you?");

            String insertConversationString4 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    10005,
                    1,
                    5,
                    700002,
                    "10:04",
                    "How are you?");

            String insertConversationString5 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    10006,
                    1,
                    6,
                    700002,
                    "10:05",
                    "How are you?");

            String insertConversationString6 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    10007,
                    1,
                    7,
                    700002,
                    "10:06",
                    "How are you?");

            String insertConversationString7 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    10008,
                    1,
                    8,
                    700002,
                    "10:07",
                    "How are you?");

            String insertConversationString8 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    20001,
                    2,
                    1,
                    700002,
                    "10:01",
                    "How are you?");


            String insertConversationString9 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    20003,
                    2,
                    3,
                    700002,
                    "10:03",
                    "How are you?");

            String insertConversationString10 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    20004,
                    2,
                    4,
                    700002,
                    "10:01",
                    "How are you?");

            String insertConversationString11 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    20005,
                    2,
                    5,
                    700002,
                    "10:01",
                    "How are you?");

            String insertConversationString12 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    20006,
                    2,
                    6,
                    700002,
                    "10:01",
                    "How are you?");

            String insertConversationString13 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    20007,
                    2,
                    7,
                    700002,
                    "10:01",
                    "How are you?");

            String insertConversationString14 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    20008,
                    2,
                    8,
                    700002,
                    "10:01",
                    "How are you?");

            String insertConversationString15 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    30001,
                    3,
                    1,
                    700002,
                    "10:15",
                    "How are you?");

            String insertConversationString16 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    30002,
                    3,
                    2,
                    700002,
                    "10:16",
                    "How are you?");

            String insertConversationString17 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    30004,
                    3,
                    4,
                    700002,
                    "10:17",
                    "How are you?");

            String insertConversationString18 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    30005,
                    3,
                    5,
                    700002,
                    "10:18",
                    "How are you?");

            String insertConversationString19 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    30006,
                    3,
                    6,
                    700002,
                    "10:19",
                    "How are you?");

            String insertConversationString20 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    30007,
                    3,
                    7,
                    700002,
                    "10:20",
                    "How are you?");

            String insertConversationString21 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    30008,
                    3,
                    8,
                    700002,
                    "10:21",
                    "How are you?");

            String insertConversationString22 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    40001,
                    4,
                    1,
                    700002,
                    "10:22",
                    "How are you?");

            String insertConversationString23 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    40002,
                    4,
                    2,
                    700002,
                    "10:23",
                    "How are you?");

            String insertConversationString24 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    40003,
                    4,
                    3,
                    700002,
                    "10:24",
                    "How are you?");

            String insertConversationString25 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    40005,
                    4,
                    5,
                    700002,
                    "10:25",
                    "How are you?");

            String insertConversationString26 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    40006,
                    4,
                    6,
                    700002,
                    "10:26",
                    "How are you?");

            String insertConversationString27 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    40007,
                    4,
                    7,
                    700002,
                    "10:27",
                    "How are you?");

            String insertConversationString28 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    40008,
                    4,
                    8,
                    700002,
                    "10:28",
                    "How are you?");

            String insertConversationString29 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    50001,
                    5,
                    1,
                    700002,
                    "10:29",
                    "How are you?");

            String insertConversationString30 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    50002,
                    5,
                    2,
                    700002,
                    "10:30",
                    "How are you?");

            String insertConversationString31 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    50003,
                    5,
                    3,
                    700002,
                    "10:31",
                    "How are you?");

            String insertConversationString32 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    50004,
                    5,
                    4,
                    700002,
                    "10:32",
                    "How are you?");

            String insertConversationString33 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    50006,
                    5,
                    6,
                    700002,
                    "10:33",
                    "How are you?");

            String insertConversationString34 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    50007,
                    5,
                    7,
                    700002,
                    "10:34",
                    "How are you?");

            String insertConversationString35 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    50008,
                    5,
                    8,
                    700002,
                    "10:35",
                    "How are you?");

            String insertConversationString36 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    60001,
                    6,
                    1,
                    700002,
                    "10:36",
                    "How are you?");

            String insertConversationString37 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    60002,
                    6,
                    2,
                    700002,
                    "10:37",
                    "How are you?");

            String insertConversationString38 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    60003,
                    6,
                    3,
                    700002,
                    "10:38",
                    "How are you?");

            String insertConversationString39 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    60004,
                    6,
                    4,
                    700002,
                    "10:39",
                    "How are you?");

            String insertConversationString40 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    60005,
                    6,
                    5,
                    700002,
                    "10:40",
                    "How are you?");

            String insertConversationString41 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    60007,
                    6,
                    7,
                    700002,
                    "10:41",
                    "How are you?");

            String insertConversationString42 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    60008,
                    6,
                    8,
                    700002,
                    "10:42",
                    "How are you?");

            String insertConversationString43 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    70001,
                    7,
                    1,
                    700002,
                    "10:43",
                    "How are you?");

            String insertConversationString44 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    70002,
                    7,
                    2,
                    700002,
                    "10:44",
                    "How are you?");

            String insertConversationString45 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    70003,
                    7,
                    3,
                    700002,
                    "10:45",
                    "How are you?");

            String insertConversationString46 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    70004,
                    7,
                    4,
                    700002,
                    "10:46",
                    "How are you?");

            String insertConversationString47 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    70005,
                    7,
                    5,
                    700002,
                    "10:47",
                    "How are you?");

            String insertConversationString48 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    70006,
                    7,
                    6,
                    700002,
                    "10:48",
                    "How are you?");

            String insertConversationString49 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    70008,
                    7,
                    8,
                    700002,
                    "10:49",
                    "How are you?");

            String insertConversationString50 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    80001,
                    8,
                    1,
                    700002,
                    "10:50",
                    "How are you?");

            String insertConversationString51 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    80002,
                    8,
                    2,
                    700002,
                    "10:51",
                    "How are you?");

            String insertConversationString52 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    80003,
                    8,
                    3,
                    700002,
                    "10:52",
                    "How are you?");

            String insertConversationString53 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    80004,
                    8,
                    4,
                    700002,
                    "10:53",
                    "How are you?");

            String insertConversationString54 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    80005,
                    8,
                    5,
                    700002,
                    "10:54",
                    "How are you?");

            String insertConversationString55 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    80006,
                    8,
                    6,
                    700002,
                    "10:55",
                    "How are you?");

            String insertConversationString56 = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) " +
                            "VALUES (%d, %d, %d, %d, '%s', '%s')",
                    DBContract.ConversationEntry.TABLE_NAME,
                    DBContract.ConversationEntry.COLUMN_CONVERSATION_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_1_ID,
                    DBContract.ConversationEntry.COLUMN_STUDENT_2_ID,
                    DBContract.ConversationEntry.COLUMN_IMAGE_ID,
                    DBContract.ConversationEntry.COLUMN_TIMESTAMP,
                    DBContract.ConversationEntry.COLUMN_LAST_MESSAGE_SENT,
                    80007,
                    8,
                    7,
                    700002,
                    "10:56",
                    "How are you?");

            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL(insertConversationString1);
            db.execSQL(insertConversationString2);
            db.execSQL(insertConversationString3);
            db.execSQL(insertConversationString4);
            db.execSQL(insertConversationString5);
            db.execSQL(insertConversationString6);
            db.execSQL(insertConversationString7);
            db.execSQL(insertConversationString8);
            db.execSQL(insertConversationString9);
            db.execSQL(insertConversationString10);
            db.execSQL(insertConversationString11);
            db.execSQL(insertConversationString12);
            db.execSQL(insertConversationString13);
            db.execSQL(insertConversationString14);
            db.execSQL(insertConversationString15);
            db.execSQL(insertConversationString16);
            db.execSQL(insertConversationString17);
            db.execSQL(insertConversationString18);
            db.execSQL(insertConversationString19);
            db.execSQL(insertConversationString20);
            db.execSQL(insertConversationString21);
            db.execSQL(insertConversationString22);
            db.execSQL(insertConversationString23);
            db.execSQL(insertConversationString24);
            db.execSQL(insertConversationString25);
            db.execSQL(insertConversationString26);
            db.execSQL(insertConversationString27);
            db.execSQL(insertConversationString28);
            db.execSQL(insertConversationString29);
            db.execSQL(insertConversationString30);
            db.execSQL(insertConversationString31);
            db.execSQL(insertConversationString32);
            db.execSQL(insertConversationString33);
            db.execSQL(insertConversationString34);
            db.execSQL(insertConversationString35);
            db.execSQL(insertConversationString36);
            db.execSQL(insertConversationString37);
            db.execSQL(insertConversationString38);
            db.execSQL(insertConversationString39);
            db.execSQL(insertConversationString40);
            db.execSQL(insertConversationString41);
            db.execSQL(insertConversationString42);
            db.execSQL(insertConversationString43);
            db.execSQL(insertConversationString44);
            db.execSQL(insertConversationString45);
            db.execSQL(insertConversationString46);
            db.execSQL(insertConversationString47);
            db.execSQL(insertConversationString48);
            db.execSQL(insertConversationString49);
            db.execSQL(insertConversationString50);
            db.execSQL(insertConversationString51);
            db.execSQL(insertConversationString52);
            db.execSQL(insertConversationString53);
            db.execSQL(insertConversationString54);
            db.execSQL(insertConversationString55);
            db.execSQL(insertConversationString56);

            db.close();
        }

    }

}
