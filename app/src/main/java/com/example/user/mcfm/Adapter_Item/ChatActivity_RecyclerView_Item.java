package com.example.user.mcfm.Adapter_Item;

/**
 * Created by User on 2017-10-15.
 */

public class ChatActivity_RecyclerView_Item {
    private String chat_name;
    private String chat_content;

    public ChatActivity_RecyclerView_Item() {
    }

    public ChatActivity_RecyclerView_Item(String chat_name, String chat_content) {
        this.chat_name = chat_name;
        this.chat_content = chat_content;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getChat_content() {
        return chat_content;
    }

    public void setChat_content(String chat_content) {
        this.chat_content = chat_content;
    }
}
