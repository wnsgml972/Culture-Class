package com.example.user.mcfm.Chat_item;

/**
 * Created by choi on 2017-10-07.
 */

public class ChatData {
    private String username;
    private String message;

    public ChatData(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
