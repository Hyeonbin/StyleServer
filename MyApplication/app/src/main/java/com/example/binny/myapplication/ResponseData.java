package com.example.binny.myapplication;

import java.util.List;

/**
 * Created by binny on 2017. 8. 2..
 */

public class ResponseData {
    int id;
    String name;
    String imagename;
    String style;
    String location;
    SimpleData simpleData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public SimpleData getSimpleData() {
        return simpleData;
    }

    public void setSimpleData(SimpleData simpleData) {
        this.simpleData = simpleData;
    }
}


