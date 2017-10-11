package com.example.user.mcfm.Adapter_Item;

/**
 * Created by User on 2017-10-11.
 */

public class First_RecyclerView_Item {
    private String name;
    private String place;

    public First_RecyclerView_Item(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
