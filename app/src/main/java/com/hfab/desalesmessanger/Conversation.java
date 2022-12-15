package com.hfab.desalesmessanger;

public class Conversation {

    private int id; // Column Id
    private int conversationID; // ConversationId for each user
    private int student1ID; // Student 1 Id -> The user logged into their account
    private int student2ID; // Student 2 Id -> the other users
    private int imageID; // Image Id to associate with profile picture
    private String timestamp; // The time associates with the last message sent
    private String lastMessageSent; // The last message that was sent per conversation

    /**
     * The Conversation constructor represents the unique identifier for the conversation,
     * the IDs of the two students participating in the conversation,
     * the ID of the image associated with the conversation,
     * the timestamp for when the conversation was created,
     * and the last message that was sent in the conversation.
     *
     * @param id - Column Id
     * @param conversationID - conversationID
     * @param student1ID - Student 1 Id
     * @param student2ID - Student 2 Id
     * @param imageID - Image Id to associate with profile picture
     * @param timestamp - The time associated with the last message sent
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
     * getId - grabs the column id
     */
    public int getId() {
        return id;
    }

    /**
     * setId - sets the column id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getConversationID - gets the conversationID
     * @return conversationID
     */
    public int getConversationID() {
        return conversationID;
    }

    /**
     * setConversationID - sets the conversationID
     * @param conversationID
     */
    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    /**
     * getStudent1ID - gets the student 1's id
     * @return student1ID
     */
    public int getStudent1ID() {
        return student1ID;
    }

    /**
     * setStudent1ID - sets the student 1's Id
     * @param student1ID
     */
    public void setStudent1ID(int student1ID) {
        this.student1ID = student1ID;
    }

    /**
     * getStudent2ID - gets the student 2's Id
     * @return
     */
    public int getStudent2ID() {
        return student2ID;
    }

    /**
     * setStudent2Id - sets the student's 2's Id
     * @param student2ID
     */
    public void setStudent2ID(int student2ID) {
        this.student2ID = student2ID;
    }

    /**
     * getImageID - gets the image identifier
     * @return
     */
    public int getImageID() {
        return imageID;
    }

    /**
     * setImageID - sets the image identifier
     * @param imageID
     */
    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    /**
     * getTimestamp - gets the time the last message was sent
     * @return timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * setTimestamp - sets the time the last message was sent
     * @param timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * getLastMessageSent - gets the last message the user was sent
     * @return lastMessageSent
     */
    public String getLastMessageSent() {
        return lastMessageSent;
    }

    /**
     * setLastMessageSent - sets the last message the user was sent
     * @param lastMessageSent
     */
    public void setLastMessageSent(String lastMessageSent) {
        this.lastMessageSent = lastMessageSent;
    }

    /**
     * Conversation toString - Shows all information about the conversation
     * @return
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