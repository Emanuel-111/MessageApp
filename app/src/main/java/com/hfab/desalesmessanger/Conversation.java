package com.hfab.desalesmessanger;

/**
 * Conversation.java
 * This class represents the conversation information for each conversation within the
 * messenger application.
 *
 * @author Joseph Traglia
 */
public class Conversation {

    private int id; // Column Id
    private int conversationID; // ConversationId for each user
    private int student1ID; // Student 1 Id -> The user logged into their account
    private int student2ID; // Student 2 Id -> the other users
    private int imageID; // Image Id to associate with profile picture
    private String timestamp; // The time associates with the last message sent
    private String lastMessageSent; // The last message that was sent per conversation

    /**
     * Conversation
     * This constructor represents the unique identifier for the conversation,
     * the IDs of the two students participating in the conversation,
     * the ID of the image associated with the conversation,
     * the timestamp for when the conversation was created,
     * and the last message that was sent in the conversation.
     *
     * @param id              - Column Id
     * @param conversationID  - conversationID
     * @param student1ID      - Student 1 Id
     * @param student2ID      - Student 2 Id
     * @param imageID         - Image Id to associate with profile picture
     * @param timestamp       - The time associated with the last message sent
     * @param lastMessageSent - The last message that was sent per conversation
     */
    public Conversation(int id, int conversationID, int student1ID, int student2ID, int imageID, String timestamp, String lastMessageSent) {
        this.id = id;
        this.conversationID = conversationID;
        this.student1ID = student1ID;
        this.student2ID = student2ID;
        this.imageID = imageID;
        this.timestamp = timestamp;
        this.lastMessageSent = lastMessageSent;
    }

    /**
     * getId
     * Gets the conversation's ID.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * setId
     * Sets the conversation's ID.
     *
     * @param id The conversation's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getConversationID
     * Gets the conversationID.
     *
     * @return conversationID.
     */
    public int getConversationID() {
        return conversationID;
    }

    /**
     * setConversationID
     * Sets the conversationID.
     *
     * @param conversationID The conversationID.
     */
    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    /**
     * getStudent1ID
     * Gets student 1's ID.
     *
     * @return student1ID
     */
    public int getStudent1ID() {
        return student1ID;
    }

    /**
     * setStudent1ID
     * Sets the student 1's ID.
     *
     * @param student1ID Student 1's ID.
     */
    public void setStudent1ID(int student1ID) {
        this.student1ID = student1ID;
    }

    /**
     * getStudent2ID
     * Gets the student 2's ID.
     *
     * @return student2ID
     */
    public int getStudent2ID() {
        return student2ID;
    }

    /**
     * setStudent2Id
     * Sets the student's 2's ID.
     *
     * @param student2ID Student 2's ID.
     */
    public void setStudent2ID(int student2ID) {
        this.student2ID = student2ID;
    }

    /**
     * getImageID
     * Gets the image identifier.
     *
     * @return imageID
     */
    public int getImageID() {
        return imageID;
    }

    /**
     * setImageID
     * Sets the image identifier.
     *
     * @param imageID The image identifier.
     */
    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    /**
     * getTimestamp
     * Gets the time the last message was sent.
     *
     * @return timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * setTimestamp
     * Sets the time the last message was sent.
     *
     * @param timestamp The time the last message was sent.
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * getLastMessageSent
     * Gets the last message the user sent.
     *
     * @return lastMessageSent
     */
    public String getLastMessageSent() {
        return lastMessageSent;
    }

    /**
     * setLastMessageSent
     * Sets the last message the user sent.
     *
     * @param lastMessageSent The last message the user sent.
     */
    public void setLastMessageSent(String lastMessageSent) {
        this.lastMessageSent = lastMessageSent;
    }

    /**
     * toString
     * Prints the Conversation class's fields with their current values.
     *
     * @return The Conversation's fields in a String.
     */
    @Override
    public String toString() {
        return "Conversation{" +
                "id=" + id +
                ", conversationID=" + conversationID +
                ", student1ID=" + student1ID +
                ", student2ID=" + student2ID +
                ", imageID=" + imageID +
                ", timestamp='" + timestamp + '\'' +
                ", lastMessageSent='" + lastMessageSent + '\'' +
                '}';
    }
}