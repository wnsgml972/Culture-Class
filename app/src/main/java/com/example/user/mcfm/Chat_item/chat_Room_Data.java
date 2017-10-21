package com.example.user.mcfm.Chat_item;

/**
 * Created by Choiwongyun on 2017-10-07.
 */

class chat_Room_Data {
    private String content;
    private String time;

    public chat_Room_Data() { //빈 생성자를 꼭 만들어 줘야 데이터를 가져올때 error를 발생시키지 않는다.
    }

    public chat_Room_Data(String content, String time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
