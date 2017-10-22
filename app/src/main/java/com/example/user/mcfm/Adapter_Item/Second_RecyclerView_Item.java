package com.example.user.mcfm.Adapter_Item;

/**
 * Created by User on 2017-10-14.
 */

public class Second_RecyclerView_Item {
    private String name;
    private String last_content;

    public Second_RecyclerView_Item( String name, String place) {
        this.name = name;
        this.last_content = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return last_content;
    }

    public void setPlace(String place) {
        this.last_content = place;
    }
}
