package com.hfab.desalesmessanger;

import java.sql.Timestamp;

public class Message {

    private int id;
    private int conversationID;
    private String contents;
    private String timestamp;
    private int senderID;

    public final static int TYPE_SENT = 0;
    public final static int TYPE_RECEIVED = 1;

    public Message(int id, int conversationID, String contents, String timestamp, int senderID)
    {
        this.id = id;
        this.conversationID = conversationID;
        this.contents = contents;
        this.timestamp = timestamp;
        this.senderID = senderID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConversationID() {
        return conversationID;
    }

    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", conversationID=" + conversationID +
                ", contents='" + contents + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", senderID=" + senderID +
                '}';
    }
}
