package com.hfab.desalesmessanger;

import android.provider.BaseColumns;

/**
 * DBContract.java
 * This class represents the "contract" agreeement between the Java class and the SQLite database.
 * Each "contract" contains constant variables, a create command, and a drop command.
 *
 * @author Joseph Traglia
 */
public class DBContract {

    /**
     * LoginEntry
     * This class represents the Login class's contract to instantiate an ID,
     * name, email, and password for each database entry.
     *
     * @author Joseph Traglia
     */
    class LoginEntry implements BaseColumns {
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
     * MessageEntry
     * This class represents the Message class's contract to instantiate an ID,
     * conversation ID, contents, a timestamp, and a sender ID for each database entry.
     *
     * @author Joseph Traglia
     */
    class MessageEntry implements BaseColumns {
        public static final String TABLE_NAME = "messages";
        public static final String COLUMN_CONVERSATION_ID = "conversation";
        public static final String COLUMN_CONTENTS = "contents";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_SENDER_ID = "sender";
        public static final String COLUMN_ID = _ID;

        public static final String CREATE_MESSAGE_TABLE_CMD = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CONVERSATION_ID + " INTEGER NOT NULL, " + COLUMN_CONTENTS + " TEXT NOT NULL, " +
                COLUMN_TIMESTAMP + " TEXT NOT NULL, " + COLUMN_SENDER_ID + " INTEGER NOT NULL)";

        public static final String DROP_MESSAGE_TABLE_CMD = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /**
     * ConversationEntry
     * This class represents the Conversation class's contract to instantiate an ID,
     * conversation ID, student 1 ID, student 2 ID, image ID, a timestamp, and
     * when the last message was sent for each database entry.
     *
     * @author Joseph Traglia
     */
    class ConversationEntry implements BaseColumns {
        public static final String TABLE_NAME = "conversations";
        public static final String COLUMN_CONVERSATION_ID = "conversation_ID";
        public static final String COLUMN_STUDENT_1_ID = "student1_ID";
        public static final String COLUMN_STUDENT_2_ID = "student2_ID";
        public static final String COLUMN_IMAGE_ID = "image_ID";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_LAST_MESSAGE_SENT = "last";
        public static final String COLUMN_ID = _ID;

        public static final String CREATE_CONVERSATION_TABLE_CMD = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CONVERSATION_ID + " INTEGER NOT NULL, " + COLUMN_STUDENT_1_ID + " INTEGER NOT NULL, " +
                COLUMN_STUDENT_2_ID + " INTEGER NOT NULL, " + COLUMN_IMAGE_ID + " INTEGER NOT NULL, " +
                COLUMN_TIMESTAMP + " TEXT NOT NULL, " + COLUMN_LAST_MESSAGE_SENT + " TEXT NOT NULL)";

        public static final String DROP_CONVERSATION_TABLE_CMD = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
