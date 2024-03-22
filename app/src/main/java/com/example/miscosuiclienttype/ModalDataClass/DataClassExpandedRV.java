package com.example.miscosuiclienttype.ModalDataClass;


import java.util.List;

public class DataClassExpandedRV {

    private final List<String> nestedList;
    private final String itemText;
    private boolean isExpandable;

    public DataClassExpandedRV(List<String> itemList, String itemText) {
        this.nestedList = itemList;
        this.itemText = itemText;
        isExpandable = false;
    }

    public List<String> getNestedList() {
        return nestedList;
    }

    public String getItemText() {
        return itemText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}