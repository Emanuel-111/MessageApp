package com.hfab.desalesmessanger;

public class Conversation {

    private int conversationId;
    private String person1;
    private String person2;

    public Conversation(int conversationId, String person1, String person2)
    {
        this.conversationId = conversationId;
        this.person1 = person1;
        this.person2 = person2;
    }

    public int getConversationId()
    {
        return this.conversationId;
    }

    public void setConversationId(int conversationId)
    {
        this.conversationId = conversationId;
    }

    public String getPerson1()
    {
        return this.person1;
    }

    public void setPerson1(String person1)
    {
        this.person1 = person1;
    }

    public String getPerson2()
    {
        return this.person2;
    }

    public void setPerson2(String person2)
    {
        this.person2 = person2;
    }

    public String toString()
    {
        return "CONVERSATION ID: " + conversationId +
                "\nPERSON: " + person1 +
                "\nPERSON2: " + person2;
    }



}
