package com.example.user.mcfm.Adapter_Item;

/**
 * Created by User on 2017-10-11.
 */

public class Fourth_RecyclerView_Dialog_Tuty_Item {
    private String location;
    private Boolean check;

    public Fourth_RecyclerView_Dialog_Tuty_Item(String location, Boolean check) {
        this.location = location;
        this.check = check;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
}
