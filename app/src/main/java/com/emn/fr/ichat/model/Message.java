package com.emn.fr.ichat.model;

public class Message {

    private String uuid;
    private String login;
    private String message;

    public Message() {}

    public Message(String uuid, String login, String message) {
        this.uuid = uuid;
        this.login = login;
        this.message = message;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
