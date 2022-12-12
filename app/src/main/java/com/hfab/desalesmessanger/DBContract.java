package com.hfab.desalesmessanger;

import android.provider.BaseColumns;

public class DBContract {

    /**
     * LoginEntry creates the Login table
     *
     * Contains: Student ID, name, email, and password.
     */
    class LoginEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "logins";
        public static final String COLUMN_STUDENT_ID = "student ID";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_ID = _ID;

        public static final String CREATE_LOGIN_TABLE_CMD = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STUDENT_ID + " INTEGER NOT NULL, "+ COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_EMAIL + " TEXT NOT NULL, " + COLUMN_PASSWORD + " TEXT NOT NULL)";

        public static final String DROP_LOGIN_TABLE_CMD = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /**
     * MessageEntry creates the Message table
     *
     * Contains: Messages, sender, recipient and contents.
     */
    class MessageEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "messages";
        public static final String COLUMN_SENDER = "sender";
        public static final String COLUMN_RECIPIENT = "recipient";
        public static final String COLUMN_CONTENTS = "contents";
        public static final String COLUMN_ID = _ID;

        public static final String CREATE_MESSAGE_TABLE_CMD = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SENDER + " INTEGER NOT NULL, " + COLUMN_RECIPIENT + " INTEGER NOT NULL, " +
                COLUMN_CONTENTS + " TEXT NOT NULL)";

        public static final String DROP_MESSAGE_TABLE_CMD = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
