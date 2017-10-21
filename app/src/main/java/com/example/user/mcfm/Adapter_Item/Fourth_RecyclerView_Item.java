package com.example.user.mcfm.Adapter_Item;

/**
 * Created by hscom-018 on 2017-10-21.
 */

public class Fourth_RecyclerView_Item {
    private String name;
    private int draw;
    public Fourth_RecyclerView_Item(String name, int draw) {
        this.name = name;
        this.draw =  draw;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}