package com.hfab.desalesmessanger;

public class Login {

    private String emailAddress;
    private String password;
    private String studentName;
    private int studentId;
    private int id;

    public Login(int id, int studentId, String studentName, String emailAddress, String password)
    {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String toString()
    {
        return "";
    }

}
