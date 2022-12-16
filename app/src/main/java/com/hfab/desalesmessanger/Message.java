package com.hfab.desalesmessanger;

//Wyatt Giberson
//This is the Message Class That Stores Information about the message object. and is used to create individual messages from the DB
public class Message {

    //Private Variables
    private int id;
    private int conversationID;
    private String contents;
    private String timestamp;
    private int senderID;

    //Constants for Message Type
    public final static int TYPE_SENT = 0;
    public final static int TYPE_RECEIVED = 1;

    //Constructor For Message Class
    public Message(int id, int conversationID, String contents, String timestamp, int senderID) {
        this.id = id;
        this.conversationID = conversationID;
        this.contents = contents;
        this.timestamp = timestamp;
        this.senderID = senderID;
    }

    //Getter's and Setter's
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


    //To String
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
