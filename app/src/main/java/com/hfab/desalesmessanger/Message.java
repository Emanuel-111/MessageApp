package com.hfab.desalesmessanger;

import java.sql.Timestamp;

public class Message {

    private int conversationId;
    private String message;
    private Timestamp timestamp;
    private int senderId;

    public Message(int conversationId, String message, Timestamp timestamp, int senderId)
    {
        this.conversationId = conversationId;
        this.message = message;
        this.timestamp = timestamp;
        this.senderId = senderId;
    }

    public int getConversationId()
    {
        return conversationId;
    }

    public void setConversationId(int conversationId)
    {
        this.conversationId = conversationId;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }

    public int getSenderId()
    {
        return senderId;
    }

    public void setSenderId(int senderId)
    {
        this.senderId = senderId;
    }

    public String toString()
    {
        return "CONVERSATION ID: " + conversationId +
                "\nMESSAGE: " + message +
                "\nTIME SENT: " + timestamp;
    }

}
