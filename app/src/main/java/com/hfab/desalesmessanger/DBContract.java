package com.hfab.desalesmessanger;

import android.provider.BaseColumns;

/**
 * LoginEntry creates the Login table
 *
 * Contains: Student ID, name, email, and password.
 */
public class DBContract {

        /**
         * LoginEntry creates the Login table
         *
         * Contains: Student ID, name, email, and password.
         */
        class LoginEntry implements BaseColumns
        {
            public static final String TABLE_NAME = "logins";
            public static final String COLUMN_NAME = "name";
            public static final String COLUMN_EMAIL = "email";
            public static final String COLUMN_PASSWORD = "password";
            public static final String COLUMN_ID = _ID;

            public static final String CREATE_LOGIN_TABLE_CMD = "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_EMAIL + " TEXT NOT NULL, " +
                    COLUMN_PASSWORD + " TEXT NOT NULL)";

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
            public static final String COLUMN_CONVERSATION_ID = "conversation ID";
            public static final String COLUMN_CONTENTS = "contents";
            public static final String COLUMN_TIMESTAMP = "timestamp";
            public static final String COLUMN_SENDER_ID = "sender ID";
            public static final String COLUMN_ID = _ID;

            public static final String CREATE_MESSAGE_TABLE_CMD = "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CONVERSATION_ID + " INTEGER NOT NULL, " + COLUMN_CONTENTS + " TEXT NOT NULL, " +
                    COLUMN_TIMESTAMP + " TEXT NOT NULL, " + COLUMN_SENDER_ID + " INTEGER NOT NULL)";

            public static final String DROP_MESSAGE_TABLE_CMD = "DROP TABLE IF EXISTS " + TABLE_NAME;
        }

        class ConversationEntry implements BaseColumns
        {
            public static final String TABLE_NAME = "conversations";
            public static final String COLUMN_STUDENT_1_ID = "student 1 ID";
            public static final String COLUMN_STUDENT_2_ID = "student 2 ID";
            public static final String COLUMN_IMAGE_ID = "image ID";
            public static final String COLUMN_TIMESTAMP = "timestamp";
            public static final String COLUMN_LAST_MESSAGE_SENT = "last message sent";
            public static final String COLUMN_ID = _ID;

            public static final String CREATE_CONVERSATION_TABLE_CMD = "CREATE TABLE " + TABLE_NAME +
                    " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_STUDENT_1_ID + " INTEGER NOT NULL, " + COLUMN_STUDENT_2_ID + " INTEGER NOT NULL, " +
                    COLUMN_IMAGE_ID + " INTEGER NOT NULL, " + COLUMN_TIMESTAMP + " TEXT NOT NULL, " +
                    COLUMN_LAST_MESSAGE_SENT + " TEXT NOT NULL)";

            public static final String DROP_CONVERSATION_TABLE_CMD = "DROP TABLE IF EXISTS " + TABLE_NAME;
        }

    }
