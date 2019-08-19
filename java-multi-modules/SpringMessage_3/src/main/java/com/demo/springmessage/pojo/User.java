package com.demo.springmessage.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String tel;
    private int messageNum;
    private int groupid;
    private int roleid;
    private String photo_path;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(int messageNum) {
        this.messageNum = messageNum;
    }


    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }


    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }
}
