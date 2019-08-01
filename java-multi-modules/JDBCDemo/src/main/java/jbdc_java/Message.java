package jbdc_java;

import java.sql.Timestamp;

public class Message {
    private int m_id;
    private String m_title;
    private String m_detail;
    private Timestamp starttime;
    private Timestamp edittime;
    private int userid;
    private String username;

    public int getm_id() {
        return m_id;
    }
    public void setm_id(int m_id) {
        this.m_id = m_id;
    }
    public String getm_title() {
        return m_title;
    }
    public void setm_title(String m_title) {
        this.m_title = m_title;
    }
    public String getm_detail() {
        return m_detail;
    }
    public void setm_detail(String m_detail) {
        this.m_detail = m_detail;
    }

    public void setstarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public void setedittime(Timestamp edittime) {
        this.edittime= edittime;
    }

    public void setuserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public Timestamp getEdittime() {
        return edittime;
    }

    public int getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
