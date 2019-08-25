package org.wt.model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;
    private String nick;

    public User(){

    }
    public User(String name,String password,String nick){
        this.name = name;
        this.password = password;
        this.nick = nick;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
