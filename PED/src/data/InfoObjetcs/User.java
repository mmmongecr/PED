/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.InfoObjetcs;

import java.util.Date;

/**
 *
 * @author manuel.mora
 */
public class User {
    
    private int ID;
    private String username, name, last_name, user_type, status;
    private Date date;

    public User(int ID, String username, String name, String last_name, String user_type, String status, Date date) {
        this.ID = ID;
        this.username = username;
        this.name = name;
        this.last_name = last_name;
        this.user_type = user_type;
        this.status = status;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[][] getUser() {
        return new String[][] {
            {"user_ID", ID + ""},
            {"username", username},
            {"name", name},
            {"last_name", last_name},
            {"user_type", user_type},
            {"status", status},
            {"last_login", date.getTime() + ""}
        };
    }
}
