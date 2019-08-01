package jbdc_java;

public class User {
    private String username;
    private int id;
    private String password;
    private String email;
    private String telnumber;
    private int Message_coumt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public int getMessage_coumt() {
        return Message_coumt;
    }

    public void setMessage_coumt(int message_coumt) {
        Message_coumt = message_coumt;
    }
}
