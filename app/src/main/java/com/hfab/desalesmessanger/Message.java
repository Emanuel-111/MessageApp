package com.hfab.desalesmessanger;

import java.sql.Timestamp;

public class Message {

    private int conversationId;
    private String message;
    private String timestamp;
    private int senderId;

    public Message(int conversationId, String message, String timestamp, int senderId)
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

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
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
