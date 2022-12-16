package com.hfab.desalesmessanger;

/**
 * @author Emanuel Luna
 * Login (class) - represents the login information that the
 * user must enter correctly before accessing their conversations
 */
public class Login {

    private String emailAddress;
    private String password;
    private String studentName;
    private int id;

    /**
     * Login - creates a new Login instance
     *
     * @param id           - id of the new Login instance
     * @param studentName  - the student name
     * @param emailAddress - the email address
     * @param password     - the password
     */
    public Login(int id, String studentName, String emailAddress, String password) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
        this.studentName = studentName;
    }

    /**
     * getId - returns the id of the Login
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * setId - sets the id of the Login
     *
     * @param id - id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getEmailAddress - gets the email address of the Login
     *
     * @return emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * setEmailAddress - sets the emailAddress of the Login
     *
     * @param emailAddress - emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * getPassword - gets the password of the Login
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword - sets the password of the Login
     *
     * @param password - password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getStudentName - gets the student name of the Login
     *
     * @return studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * setStudentName - sets the student name of the Login
     *
     * @param studentName - student name
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * toString - displays information of the Login
     *
     * @return the string that contains information of the Login
     */
    @Override
    public String toString() {
        return "Login{" +
                "emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", studentName='" + studentName + '\'' +
                ", id=" + id +
                '}';
    }
}
