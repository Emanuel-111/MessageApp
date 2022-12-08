package com.hfab.desalesmessanger;

import java.util.ArrayList;

// This will be replaced with a SQL database
public class ConversationDatabase {

    private static ArrayList<Conversation> conversations = new ArrayList<Conversation>();

    public static ArrayList<Conversation> getData()
    {
        if (conversations == null)
            loadData();

        return conversations;
    }

    private static void loadData()
    {
        conversations.add(new Conversation(1, "Emanuel", "Austin"));
    }

}
