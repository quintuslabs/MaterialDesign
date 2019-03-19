package com.santosh.net.materialdesign.home.model;

import java.util.List;

public class Parent {
    int id;
    String title;
    List<Child> childList;

    public Parent() {
    }

    public Parent(int id, String title, List<Child> childList) {
        this.id = id;
        this.title = title;
        this.childList = childList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }
}
