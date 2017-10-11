package com.example.user.mcfm.Chat_item;

/**
 * Created by Choiwongyun on 2017-10-07.
 */

public class ChatData {
    private String username;
    private String message;

    public ChatData() { //빈 생성자를 꼭 만들어 줘야 데이터를 가져올때 error를 발생시키지 않는다.
    }

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
