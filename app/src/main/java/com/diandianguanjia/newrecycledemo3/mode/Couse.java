package com.diandianguanjia.newrecycledemo3.mode;

/**
 * Created by an on 2017/8/18.
 */

public class Couse {

    public Couse(String name) {
        this.name = name;
    }

    public Couse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
