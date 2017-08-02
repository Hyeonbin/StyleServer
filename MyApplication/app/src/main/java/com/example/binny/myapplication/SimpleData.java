package com.example.binny.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by binny on 2017. 8. 2..
 */

public class SimpleData {
    List<SimpleObject> simpleObjects = new ArrayList<SimpleObject>();

    public List<SimpleObject> getSimpleObjects() {
        return simpleObjects;
    }

    public void setSimpleObjects(List<SimpleObject> simpleObjects) {
        this.simpleObjects = simpleObjects;
    }
}
